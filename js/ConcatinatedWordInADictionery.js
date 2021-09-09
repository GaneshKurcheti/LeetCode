class TrieNode{
  constructor(){
    this.children = {};
    this.isWord = false;
    this.word = "";
  }
}
var findAllConcatenatedWordsInADict = function(words) {
  if(words.length==1 ){
    return []
  }
  words.sort((a,b)=> a.length- b.length);
  let result = new Set();
  let root = new TrieNode();
  for(var word of words){
    if(!checkIfPossibleToBuild(word)){
      addToTrie(word);
    }
    else{
      result.add(word)
    }
  }
  function addToTrie(word){
    let node = root;
    for(let i=0;i< word.length; i++){
      if(!node.children[word[i]]){
        node.children[word[i]]= new TrieNode();
      }
      node = node.children[word[i]]
    }
    node.isWord=true;
    node.word =  word;
  }

  function checkIfPossibleToBuild(word){
    let node = root;
    if(word.length ==0 || result.has(word)){
      return true;
    }
    for(let i=0;i< word.length;i++){
      if(node.children[word[i]]){
        node = node.children[word[i]]
        if(node.isWord && checkIfPossibleToBuild(word.slice(node.word.length))){
          return true;
        }
      }
      else{
        return false;
      }
    }
  }
  return Array.from(result)
};
console.log(findAllConcatenatedWordsInADict(["cat","cats","catsdogcats","catsdog","dog"]))