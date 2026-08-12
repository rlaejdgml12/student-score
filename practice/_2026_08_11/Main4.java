package _2026_08_11;

class MyLinkedList<E>{

    DoubleNode first;
    DoubleNode last;
    int size;

    class DoubleNode{
        E data;
        DoubleNode prev;
        DoubleNode next;

        public DoubleNode(E data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public void addFirst(E data){
        DoubleNode newNode = new DoubleNode(data);
        if(first == null){
            first = newNode;
            last = newNode;
            size++;
        } else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
            size++;
        }
    }

    public void addLast(E data){
        DoubleNode newNode = new DoubleNode(data);
        if(last == null){
            first = newNode;
            last = newNode;
            size++;
        } else {
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
            size++;
        }
    }

    public void removeFirst(){
        DoubleNode tempNode;
        if(first == null){
            throw new IndexOutOfBoundsException("노드가 존재하지 않습니다.");
        } else if (first.next == null) {
            first = null;
            last = null;
            size--;
        } else {
            tempNode = first.next;
            first.next = null;
            tempNode.prev = null;
            first = tempNode;
            size--;
        }
    }

    public E get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("잘못된 인덱스 값입니다.");
        }else{
            DoubleNode tempNode;
            if(this.size/ 2.0 > index){
                tempNode = first;
                int count = 0;
                while(count != index){
                    tempNode = tempNode.next;
                    count++;
                }
                return tempNode.data;
            } else{
                tempNode = last;
                int count = size - 1;
                while (count != index){
                    tempNode = tempNode.prev;
                    count--;
                }
                return tempNode.data;
            }
        }

    }

}

public class Main4 {
    public static void main(String[] args) {
        MyLinkedList<Integer> linkList = new MyLinkedList<Integer>();
        MyArrayList<Integer> arrayList = new MyArrayList<Integer>();

        long time1 = System.nanoTime();
        for (int i = 0; i < 10000; i++){
            arrayList.add(0, i);
        }
        long time2 = System.nanoTime();

        long time3 = System.nanoTime();
        for (int i = 0; i < 10000; i++){
            linkList.addFirst(i);
        }
        long time4 = System.nanoTime();

        System.out.println("배열리스트 삽입 시간 : " + (time2 - time1) + ", 연결리스트 삽입 시간 : " + (time4 - time3));

        time1 = System.nanoTime();
        for (int i = 0; i < 10000; i++){
            arrayList.get(i);
        }
        time2 = System.nanoTime();

        time3 = System.nanoTime();
        for (int i = 0; i < 10000; i++){
            linkList.get(i);
        }
        time4 = System.nanoTime();

        System.out.println("배열리스트 조회 시간 : " + (time2 - time1) + ", 연결리스트 조회 시간 : " + (time4 - time3));

        time1 = System.nanoTime();
        for (int i = 0; i < 10000; i++){
            arrayList.remove(0);
        }
        time2 = System.nanoTime();

        time3 = System.nanoTime();
        for (int i = 0; i < 10000; i++){
            linkList.removeFirst();
        }
        time4 = System.nanoTime();

        System.out.println("배열리스트 삭제 시간 : " + (time2 - time1) + ", 연결리스트 삭제 시간 : " + (time4 - time3));

    }
}
