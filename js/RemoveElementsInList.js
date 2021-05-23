var removeElements = function(head, val) {
  let previous = new ListNode(1);
  let res = previous;
  let current = head;
  while(current){
      if(current.val!= val){
          previous.next = current;
          previous = previous.next;
      }
      current = current.next
  }
  previous.next = null;
  return res.next;
};