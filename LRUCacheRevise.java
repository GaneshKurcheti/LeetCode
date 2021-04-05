import java.util.LinkedHashMap;

public class LRUCacheRevise {
  class LRUCache {
    LinkedHashMap<Integer, Integer> vals;
    int currentCount;
    int capacity;

    public LRUCache(int capacity) {
      this.capacity = capacity;
      this.currentCount = 0;
      vals = new LinkedHashMap<>();
    }

    public int get(int key) {
      if (vals.containsKey(key)) {
        int value = vals.get(key);
        vals.remove(key);
        vals.put(key, value);
        return vals.get(key);
      } else {
        return -1;
      }
    }

    public void put(int key, int value) {
      if (vals.containsKey(key)) {
        this.get(key);
        this.vals.put(key, value);
        return;
      } else {
        if (currentCount < capacity) {
          vals.put(key, value);
          currentCount++;
        } else if (currentCount == capacity) {
          vals.remove(vals.keySet().toArray()[0]);
          vals.put(key, value);
        }
      }
    }
  }
}
