class Node{
  constructor(key,value) {
    this.value = value;
    this.key = key; 
    this.prev = null;
    this.next = null;
  }
}
class LRUCache{
  constructor(capacity){
      this.map = new Map();
      this.end = null;
      this.begin =null;
      this.capacity =capacity;
      this.currentLength = 0;
  }
  put(key, value){
    if(this.map.has(key)){
      this.get(key);
      this.map.get(key).value = value;
    }
    else{
      let node = new Node(key, value)
      if(this.currentLength ==0){
        this.begin = node;
        this.end = node;
      }
      else if(this.currentLength< this.capacity){
        this.end.next = node;
        node.prev = this.end;
        this.end = node;
      }
      else if( this.currentLength >= this.capacity){
        this.end.next = node;
        node.prev = this.end;
        this.end = node;
        this.begin.next.prev= null;
        this.map.delete(this.begin.key)
        this.begin = this.begin.next;
      }
      this.currentLength++;
      this.map.set(key, node)
    }
  }
  get(key){
    if(!this.map.has(key)){
      return -1;
    }
    else{
      let node =  this.map.get(key);
      if(node.next!= null && node.prev == null){
        node.next.prev = null;
        this.begin = node.next;
        node.next = null;
        this.end.next = node;
        node.prev = this.end;
        this.end = this.end.next;
      }
      else if(node.next!= null && node.prev != null){
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.prev = this.end;
        node.next = null;
        this.end.next = node;
        this.end = this.end.next;
      }
      return this.map.get(key).value;
    }
  }
}