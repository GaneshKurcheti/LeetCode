var checkIfEqual = function(root1, root2){
  function isEqual(node1, node2){
    if(!node1 &&! node2){
      return true;
    }
    if(!node1 || !node2){
      return false;
    }
    return (node1.val == node2.val && isEqual(node1.right, node2.right) && isEqual(node1.left, node2.left));
  }
  return isEqual(root1, root2)
}
