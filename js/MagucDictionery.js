class TrieNode{
  constructor(){
      this.children ={};
      this.childs =[]
      this.isWord =false;
      this.word ="";
  }
}
class MagicDictionary{
  constructor(){
      this.rootNode = new TrieNode();
  }
  buildDict(words){
      let node;
      for(var word of words){
          node =  this.rootNode;
          for(let i=0;i<word.length;i++){
              if(!node.children[word[i]]){
                  node.children[word[i]] = new TrieNode();
                  node.childs.push(word[i])
              }
              node = node.children[word[i]];
          }
          node.isWord = true;
          node.word = word;
      }
  }
  search(word){
      let node = this.rootNode; 
      function checkIfMatch(node, i, isSkipped){
          if(i== word.length && isSkipped ){
              return node.isWord;
          }
          if(isSkipped && !node.children[(word[i])]){
              return false;
          }

          if(isSkipped && node.children[word[i]]){
              return checkIfMatch(node.children[word[i]], i+1, isSkipped)
          } 
          if(!isSkipped){
              for(let j=0;j< node.childs.length;j++){
                  if(checkIfMatch(node.children[node.childs[j]], i+1, word[i] && node.childs[j] != word[i])){
                      return true 
                  }
              }
              return false;
          }
          return false;
      }
      return checkIfMatch(node, 0, false)
      
  }
}