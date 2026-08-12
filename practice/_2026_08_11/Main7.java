package _2026_08_11;

import java.util.LinkedList;

class MyHashSetV2{
    private LinkedList<String>[] buckets;
    private int capacity;

    public MyHashSetV2(int capacity){
        this.capacity = capacity;
        this.buckets = new LinkedList[capacity];
        for(int i = 0; i < capacity; i++){
            buckets[i] = new LinkedList<>();
        }
    }

    private int indexOf(String value){
        int hash = value.hashCode();
        int spread = hash ^ (hash >>> 16);
        return (capacity - 1) & spread;
    }

    public void add(String value){
        int index = indexOf(value);
        if(!buckets[index].contains(value)){
            buckets[index].add(value);
        }
    }

    public boolean contains(String value){
        int index = indexOf(value);
        return buckets[index].contains(value);
    }

}

public class Main7 {
    public static void main(String[] args) {
        MyHashSetV2 set = new MyHashSetV2(4);


        System.out.println("Aa".hashCode());
        System.out.println("BB".hashCode());

        set.add("Aa");
        set.add("BB");

        System.out.println(set.contains("Aa"));
        System.out.println(set.contains("BB"));
        System.out.println(set.contains("CC"));
    }
}
