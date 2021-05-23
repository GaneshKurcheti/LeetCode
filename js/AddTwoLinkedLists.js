var addTwoNumbers = function(l1, l2) {
  let root  = new ListNode(0);
  let res = root;
  let carry = 0;
  let l1Val =0;
  let l2Val =0;
  let sum  =0 ;
  while(l1||l2){
    l1Val = l1? l1.val :0;
    l2Val = l2 ? l2.val :0;
    sum = l1Val+ carry+ l2Val;
    if(sum> 9){
      carry = parseInt(sum/10);
      sum  = sum %10;
    }
    else{
      carry =0;
    }
    root.next  = new ListNode(sum);
    root = root.next;
    l1 = l1 ? l1.next : null;
    l2 = l2 ? l2.next : null;
  }
  if(carry>0){
    root.next = new ListNode(carry)
  }
  return res.next;
}
