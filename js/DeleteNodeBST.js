
class Node {
  constructor(value, left, right) {
    this.val = value;
    this.left = left;
    this.right = right;
  }
}
var deleteNode = function(root, key) {   
  function find(node, key){
    if(node === null){
      return null;
    }
    if(node.val == key){
    if(node.right){
      let swapNode =  getSwapNode(node.right);
      node.val = swapNode;
      node.right = find(node.right, node.val); 
    }
    else{
      return node.left;
    }
    }
    else if(node.val  > key){
      node.left = find(node.left, key);
    }
    else if(node.val<key){
      node.right = find(node.right, key)
    }
    return node;
  }
  function getSwapNode(node){
    if(!node.left){
      return node.val;
    }
    while(node.left!= null){
      node = node.left;
    }
    return node.val
  }
  return find(root, key)
};