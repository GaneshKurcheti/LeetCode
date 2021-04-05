import java.util.HashMap;

import javax.lang.model.element.Element;

class Node {
  int value;
  Node next;
  Node prev;
  int key;

  public Node(int value, Node next, Node prev, int key) {
    this.value = value;
    this.key = key;
    this.next = next;
    this.prev = prev;
  }

  public Node(int key, int value) {

    this.value = value;
    this.key = key;
    this.next = null;
    this.prev = null;
  }

  public String toString() {
    return "(" + this.key + "->" + this.value + ")";
  }
}

public class LRUCache {

  int capacity;
  Node beginNode;
  Node endNode;
  int currentLength;
  HashMap<Integer, Node> map;

  public LRUCache(int capacity) {
    this.capacity = capacity;
    this.beginNode = null;
    this.endNode = null;
    this.currentLength = 0;
    this.map = new HashMap<>();
  }

  public int get(int key) {
    if (!map.containsKey(key)) {
      return -1;
    } else {
      var node = map.get(key);
      if (node.next != null && node.prev == null) {
        beginNode.next.prev = null;
        this.beginNode.prev = this.endNode;
        this.endNode.next = this.beginNode;
        this.endNode = this.beginNode;
        this.beginNode = this.endNode.next;
        this.endNode.next = null;
      } else if (node.next != null && node.prev != null) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.next = null;
        this.endNode.next = node;
        node.prev = this.endNode;
        this.endNode = node;
      }
      return node.value;
    }

  }

  public void put(int key, int value) {
    if (map.containsKey(key)) {
      this.get(key);
      this.map.get(key).value = value;
      return;
    }
    Node node = new Node(key, value);
    if (currentLength == 0) {
      beginNode = node;
      endNode = node;
      map.put(key, node);
      currentLength++;
      return;
    }
    if (capacity > currentLength) {
      this.endNode.next = node;
      node.prev = endNode;
      this.endNode = node;
      this.map.put(key, node);
      currentLength++;
      return;
    }
    this.endNode.next = node;
    node.prev = this.endNode;
    endNode = node;
    this.map.remove(beginNode.key);
    this.beginNode.next.prev = null;
    this.beginNode = this.beginNode.next;
    map.put(key, node);
  }
}