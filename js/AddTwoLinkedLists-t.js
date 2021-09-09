
var reverseLinkedList = function(list){
  let head = list;
  if( head== null){
    return null;
  }
  let prev = null;
  while(head.next){
    let next = head.next;
    head.next = prev;
    prev = head;
    head= next;
  }
  return head;
}
var calcSum = function (l1, l2){
  let carry =0;
  let sum  =  new ListNode(-1);
  let res = sum;
  let l1Val=0;
  let l2Val=0;
  while(l1||l2){
    l1Val  =  l1 ?  l1.val : 0;
    l2Val =  l2 ?  l2.val : 0;
    sum.next = new ListNode((l1Val+l2Val+carry)%10);
    carry =  parseInt((l1Val+l2Val+carry)/10);
    l1 = l1.next ? l1 : null;
    l2 = l2.next ? l2 : null; 
  }
  if(carry!= 0){
    sum.next = new ListNode(carry);
  }
  return res.next;
}