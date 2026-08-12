package _2026_08_11;

import java.util.HashMap;
import java.util.Map;

interface Repository<T, ID>{
    void save(ID id, T item);
    T findById(ID id);

    class MemoryRepository<ID, T> implements Repository<T, ID>{
        private Map<ID, T> map = new HashMap<ID, T>();


        @Override
        public void save(ID id, T item){
            map.put(id, item);
        }

        @Override
        public T findById(ID id){
            return map.get(id);
        }
    }

}

public class Main2 {
    public static void main(String[] args) {
        Repository.MemoryRepository<Long, String> memory = new Repository.MemoryRepository<Long, String>();
        memory.save(1L, "동희");
        System.out.println(memory.findById(1L));

    }
}
