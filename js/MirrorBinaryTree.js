var mirrorTree = function(node){
  function mirror(node){
    if(node==null){
      return null;
    }
    let temp = node.left;
    node.left = mirrorTree(node.right);
    node.right = mirrorTree(temp);
    return node;
  }
  return mirror(node)
}