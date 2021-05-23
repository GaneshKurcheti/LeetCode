var mergeTwoLists = function(l1, l2) {
  let root = new ListNode(-1, null);
  let res = root;
  let l1Val=0;
  let l2Val=0;
  while(l1||l2){
    l1Val = l1 ? l1.val : Number.MAX_SAFE_INTEGER;
    l2Val = l2 ? l2.val : Number.MAX_SAFE_INTEGER;
    if(l1Val <= l2Val){
      root.next = new ListNode(l1.Val, null);
      root = root.next;
      l1= l1.next;
      continue;
    }
    else{
      root.next = new ListNode(l2.Val, null);
      root = root.next;
      l2= l2.next;
    }
  }
  return res.next;
};