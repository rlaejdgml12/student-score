package _2026_08_11;

class MyArrayList<E>{
    private Object[] elements = new Object[2];
    private int size = 0;
    public int growCount = 0;

    public void add(E e){
        if(size >= elements.length){
            grow();
        }
        elements[size++] = e;
    }

    public void add(int index, E e){
        if(size >= elements.length){
            grow();
        }
        for(int i = size; i > index; i--){
            elements[i] = elements[i - 1];
        }
        elements[index] = e;
        size++;
    }
    @SuppressWarnings("unchecked")
    public E get(int index){
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("잘못된 값입니다.");
        }
        return (E) elements[index];
    }

    public void set(int index, E e){
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("잘못된 값입니다.");
        }
        elements[index] = e;
    }

    public void remove(int index){
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("잘못된 값입니다.");
        }
        for(int i = index; i < size - 1; i++){
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
    }

    public int size(){
        return size;
    }

    void grow(){
        Object[] newArray = new Object[elements.length * 2];
        for(int i = 0; i < size; i++){
            newArray[i] = elements[i];
        }
        elements = newArray;
        growCount++;
    }
}

public class Main3 {
    public static void main(String[] args) {
        MyArrayList<Integer> listCount = new MyArrayList<Integer>();

        for(int i = 1; i <= 100; i++){
            listCount.add(i);
        }
        System.out.println(listCount.growCount);
    }
}
