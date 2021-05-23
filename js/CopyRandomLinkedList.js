var copyRandomList = function(head) {
  let map = new Map();
  if(head== null){
      return null
  }
  let result  =  new Node(head.val)
  map.set(head, result)
  let value = result
  while(head!= null){
      if(head.next && map.has(head.next)){
          result.next =map.get(head.next);
      }
      else if(head.next){
          result.next = new Node(head.next.val);
          map.set(head.next , result.next)
      }
      if(head.random && map.has(head.random)){
          result.random =map.get(head.random);
      }
      else if(head.random ){
          result.random = new Node(head.random.val);
          map.set(head.random , result.random)
      }
      result = result.next;
      head= head.next;
      
  }
  return value
};