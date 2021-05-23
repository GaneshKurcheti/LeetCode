var hasPathSum = function(root, targetSum) {
  if(!root){
      return false
  }
  function isPathAvailable(node, currentSum){
      if(!node.left && !node.right){
          return currentSum+ node.val== targetSum;
      }
      let left=false
      let right =false;
      if(node.left ){
          left = isPathAvailable(node.left, currentSum+ node.val) 
      }
      if(node.right ){
          right =  isPathAvailable(node.right, currentSum+ node.val)
      }
      return left || right 
  }
  return isPathAvailable(root,0)
};