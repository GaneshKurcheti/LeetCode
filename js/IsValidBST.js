var isValidBST = function(root){
  function isValidNode(node,min, max){
    if(!node){
      return true;
    }
    return node.val> min && node.val< max && isValidNode(node.right, node.val, max) && isValidNode(node.left, min, node.val);
  }
  return isValidNode(root, Number.MIN_SAFE_INTEGER, Number.MAX_SAFE_INTEGER)
}
