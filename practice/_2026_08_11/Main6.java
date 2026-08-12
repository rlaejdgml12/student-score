package _2026_08_11;

import java.util.LinkedList;

class MyHashSet{
    private LinkedList<String>[] buckets;
    private int capacity;

    public MyHashSet(int capacity){
        this.capacity = capacity;
        this.buckets = new LinkedList[capacity];
        for(int i = 0; i < capacity; i++){
            buckets[i] = new LinkedList<>();
        }
    }

    public void add(String value){
        int index = Math.floorMod(value.hashCode(), capacity);
        if(!buckets[index].contains(value)){
            buckets[index].add(value);
        }
    }

    public boolean contains(String value){
        int index = Math.floorMod(value.hashCode(), capacity);
        return buckets[index].contains(value);
    }

}

public class Main6 {
    public static void main(String[] args) {
        MyHashSet set = new MyHashSet(5);
        set.add("cat");
        set.add("dog");
        set.add("bird");
        set.add("cat");
        System.out.println(set.contains("cat"));
        System.out.println(set.contains("fish"));
    }
}
