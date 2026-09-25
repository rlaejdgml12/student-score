"""갤럭시 Z 폴드8 울트라 흑백 배경화면 생성기.

사진 1장으로 4장(메인 홈/잠금, 커버 홈/잠금)과 위젯 위치 미리보기 1장을 만든다.

사용 예:
    python3 make_wallpapers.py photo.jpg --name moon
    python3 make_wallpapers.py photo.jpg --name ridge --focus-x 0.7 --flip
"""

import argparse
from pathlib import Path

import numpy as np
from PIL import Image, ImageDraw, ImageFont, ImageOps

MAIN_W, MAIN_H = 2256, 2504
COVER_W, COVER_H = 1080, 2520
HALF_W = MAIN_W // 2  # 1128

# 커버 화면(1080 x 2520) 기준 위젯 위치: (라벨, y1, y2, x1, x2, 삭제 예정 여부)
COVER_LAYOUT = [
    ("G80 widget", 200, 700, 50, 1030, False),
    ("Calendar (remove)", 790, 1310, 50, 1030, True),
    ("Weather", 1390, 1600, 50, 1030, False),
    ("App icons", 1670, 1900, 50, 1030, False),
    ("Google search", 1990, 2130, 60, 1020, False),
    ("Dock", 2230, 2410, 120, 960, False),
]
HERO_BAND = (0.30, 0.64)  # 주인공을 둘 세로 구간 (비율)


def load_gray(path, flip, contrast):
    img = ImageOps.exif_transpose(Image.open(path)).convert("L")
    if flip:
        img = ImageOps.mirror(img)
    if contrast:
        img = ImageOps.autocontrast(img, cutoff=0.5)
    return img


def fit_main(img, focus_x, focus_y, zoom):
    """사진을 2256 x 2504에 꽉 차게 확대한 뒤 focus 위치를 기준으로 자른다."""
    scale = max(MAIN_W / img.width, MAIN_H / img.height) * zoom
    w, h = round(img.width * scale), round(img.height * scale)
    img = img.resize((w, h), Image.LANCZOS)
    left = round((w - MAIN_W) * focus_x)
    top = round((h - MAIN_H) * focus_y)
    return img.crop((left, top, left + MAIN_W, top + MAIN_H))


def cover_from_main(main):
    """커버 규칙: 왼쪽 절반 → 세로 2520으로 확대 → 가운데 1080만 남김."""
    half = main.crop((0, 0, HALF_W, MAIN_H))
    w = round(HALF_W * COVER_H / MAIN_H)  # 1135
    half = half.resize((w, COVER_H), Image.LANCZOS)
    left = (w - COVER_W) // 2
    return half.crop((left, 0, left + COVER_W, COVER_H))


def make_lock(main, brightness, spot):
    """같은 그림을 어둡게. spot=(x, y, r)이면 그 원 밖은 더 어둡게 해서 일부만 남긴다."""
    arr = np.asarray(main, dtype=np.float32) * brightness
    if spot:
        sx, sy, r = spot
        yy, xx = np.mgrid[0:MAIN_H, 0:MAIN_W]
        d = np.hypot(xx - sx * MAIN_W, yy - sy * MAIN_H) / (r * MAIN_W)
        # 원 안쪽은 그대로, 가장자리에서 부드럽게 줄어 원 밖은 25%만 남김
        mask = 0.25 + 0.75 * np.clip(1.5 - d, 0, 1) ** 2
        arr *= mask
    return Image.fromarray(np.clip(arr, 0, 255).astype(np.uint8))


def cover_to_main_xy(x, y):
    """커버 좌표를 메인 화면 왼쪽 절반 좌표로 옮긴다 (커버 규칙의 역변환)."""
    k = MAIN_H / COVER_H
    offset = (round(HALF_W * COVER_H / MAIN_H) - COVER_W) // 2
    return (x + offset) * k, y * k


def get_font(size):
    for f in ("/usr/share/fonts/truetype/dejavu/DejaVuSans.ttf",
              "/usr/share/fonts/truetype/liberation/LiberationSans-Regular.ttf"):
        if Path(f).exists():
            return ImageFont.truetype(f, size)
    return ImageFont.load_default(size=size)


def draw_overlay(panel, scale, boxes, font, fold_x=None):
    """반투명 위젯 상자, 주인공 띠, 접히는 선을 그린다."""
    base = panel.convert("RGBA")
    layer = Image.new("RGBA", base.size, (0, 0, 0, 0))
    d = ImageDraw.Draw(layer)
    for label, x1, y1, x2, y2, removed in boxes:
        rect = [x1 * scale, y1 * scale, x2 * scale, y2 * scale]
        if removed:
            d.rectangle(rect, outline=(255, 90, 90, 220), width=2)
        else:
            d.rectangle(rect, fill=(80, 170, 255, 90), outline=(80, 170, 255, 230), width=2)
        d.text((rect[0] + 6, rect[1] + 4), label, fill=(255, 255, 255, 240), font=font)
    h = base.height
    for frac in HERO_BAND:
        y = frac * h
        for x in range(0, base.width, 16):
            d.line([(x, y), (x + 8, y)], fill=(255, 210, 60, 220), width=2)
    label = "hero 30-64%"
    tw = d.textlength(label, font=font)
    d.text((base.width - tw - 6, HERO_BAND[0] * h - 24), label, fill=(255, 210, 60, 240), font=font)
    if fold_x is not None:
        x = fold_x * scale
        for y in range(0, h, 16):
            d.line([(x, y), (x, y + 8)], fill=(255, 255, 255, 160), width=2)
    return Image.alpha_composite(base, layer).convert("RGB")


def make_preview(cover_lock, cover_home, main_lock, main_home, title):
    ph = 1000
    font = get_font(18)
    s_cover = ph / COVER_H
    s_main = ph / MAIN_H

    cover_boxes = [(l, x1, y1, x2, y2, r) for l, y1, y2, x1, x2, r in COVER_LAYOUT]
    main_boxes = []
    for l, y1, y2, x1, x2, r in COVER_LAYOUT:
        mx1, my1 = cover_to_main_xy(x1, y1)
        mx2, my2 = cover_to_main_xy(x2, y2)
        main_boxes.append((l, mx1, my1, mx2, my2, r))

    def small(img, s):
        return img.convert("RGB").resize((round(img.width * s), round(img.height * s)), Image.LANCZOS)

    panels = [
        ("Cover LOCK", draw_overlay(small(cover_lock, s_cover), s_cover, [], font)),
        ("Cover HOME", draw_overlay(small(cover_home, s_cover), s_cover, cover_boxes, font)),
        ("Main LOCK", draw_overlay(small(main_lock, s_main), s_main, [], font, HALF_W)),
        ("Main HOME", draw_overlay(small(main_home, s_main), s_main, main_boxes, font, HALF_W)),
    ]
    gap, top = 30, 70
    width = sum(p.width for _, p in panels) + gap * (len(panels) + 1)
    sheet = Image.new("RGB", (width, ph + top + gap), (40, 40, 40))
    d = ImageDraw.Draw(sheet)
    d.text((gap, 12), title, fill=(255, 255, 255), font=get_font(26))
    x = gap
    for label, p in panels:
        d.text((x, top - 28), label, fill=(200, 200, 200), font=font)
        sheet.paste(p, (x, top))
        x += p.width + gap
    return sheet


def main():
    ap = argparse.ArgumentParser(description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter)
    ap.add_argument("photo", help="원본 사진 경로")
    ap.add_argument("--name", help="결과 파일 이름 (기본: 사진 파일 이름)")
    ap.add_argument("--out", default="output", help="결과 폴더 (기본: output)")
    ap.add_argument("--focus-x", type=float, default=0.5, help="가로 자르는 위치 0=왼쪽 끝, 1=오른쪽 끝")
    ap.add_argument("--focus-y", type=float, default=0.5, help="세로 자르는 위치 0=위, 1=아래")
    ap.add_argument("--zoom", type=float, default=1.0, help="추가 확대 배율 (1 이상)")
    ap.add_argument("--flip", action="store_true", help="좌우 뒤집기 (주인공을 오른쪽으로 옮길 때)")
    ap.add_argument("--no-contrast", action="store_true", help="자동 대비 보정 끄기")
    ap.add_argument("--lock-brightness", type=float, default=0.30, help="잠금 화면 밝기 (기본 0.30)")
    ap.add_argument("--spot", type=float, nargs=3, metavar=("X", "Y", "R"),
                    help="잠금 화면에서 남길 부분: 메인 기준 비율 좌표 X Y와 반지름 R (가로 비율)")
    args = ap.parse_args()

    name = args.name or Path(args.photo).stem
    out = Path(args.out) / name
    out.mkdir(parents=True, exist_ok=True)

    src = load_gray(args.photo, args.flip, not args.no_contrast)
    main_home = fit_main(src, args.focus_x, args.focus_y, args.zoom)
    main_lock = make_lock(main_home, args.lock_brightness, args.spot)
    cover_home = cover_from_main(main_home)
    cover_lock = cover_from_main(main_lock)

    files = {
        "main_home": main_home, "main_lock": main_lock,
        "cover_home": cover_home, "cover_lock": cover_lock,
    }
    for key, img in files.items():
        img.convert("RGB").save(out / f"{name}_{key}.jpg", quality=95)
    make_preview(cover_lock, cover_home, main_lock, main_home, name).save(out / f"{name}_preview.jpg", quality=90)
    print(f"완료: {out}/")
    for key, img in files.items():
        print(f"  {name}_{key}.jpg  {img.width} x {img.height}")
    print(f"  {name}_preview.jpg")


if __name__ == "__main__":
    main()
