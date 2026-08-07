package _2026_08_07;

class Speaker{
    private int volume;

    public Speaker(int volume){
        if(volume < 0 || volume > 100){
            throw new IllegalArgumentException("volume must be between 0 and 100");
        }
        this.volume = volume;
    }

    public void volumeUp(){
        if(volume + 10 > 100){
            volume = 100;
            return;
        }
        volume += 10;
    }

    public int getVolume(){
        return volume;
    }
}

public class Main {
    public static void main(String[] args) {
        Speaker speaker = new Speaker(95);
        speaker.volumeUp();
        System.out.println(speaker.getVolume());
    }
}
