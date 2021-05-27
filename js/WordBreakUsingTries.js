class TrieNode{
  constructor(){
    this.children = {};
    this.isWord = false;
    this.word = "";
  }
}
var WordBreak = function(s, wordDict){
  let root = new TrieNode()
  function buildTrie(){
    let node = root;
    let word = "";
    for(let i=0;i< wordDict.length;i++){
      node = root;
      word = wordDict[i];  
      for(let i=0;i< word.length;i++){
        if(!node.children[word[i]]){
          node.children[word[i]] =  new TrieNode();
        }
        node =  node.children[word[i]];
      }
      node.isWord= true;
      node.word =  word;
    }
  }
  buildTrie();
  let result =[];
  function CheckIfCanBeFomed(s, currentWords){
    if(s.length ==0){
      result.push(currentWords.join(" "));
      return
    }
    let node = root;
    for( let i=0;i< s.length;i++){
      if(!node.children[s[i]]){
        return;
      }
      node= node.children[s[i]];
      if(node.isWord){
        CheckIfCanBeFomed(s.slice(node.word.length), currentWords.concat(node.word))
      }
    }
  }
  CheckIfCanBeFomed(s, [])
  console.log( result);
}
WordBreak("catsanddog", ["cat","cats","and","sand","dog"])