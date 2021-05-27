class TrieNode{
  constructor(){
      this.children ={};
      this.isWord = false;
      this.word = true;
      this.childs =[]
      this.rank =0;
  }
}
class SuggestionSystem{
  constructor(sentences, times){
      this.currentStream ="";
      this.root = new TrieNode() 
      this.buildTrie(sentences, times);
      this.currentStream ="";
  }

  buildTrie(sentences, times){
      let word;
      for( let i=0;i< sentences.length; i++){
          word = sentences[i]
          let node =  this.root;
          for(let j=0;j< word.length; i++){
              if(!node.children[word[j]]){
                  node.children[word[j]] = new TrieNode();
                  node.childs.push(word[i])
              }
              node = this.children[word[j]];
          }
          node.isWord= true;
          node.word =word;
          node.rank = times[i];
      }
  }
  
  input(c){
      if(c =="#" ){
          this.currentStream ="";
          return 
      }
      this.currentStream += c;
      let node = this.root;
      let word = this.currentStream;
      for( let i=0;i< word.length; i++){
          if(!node.children[word[i]]){
              return []
          }
          node= node.children[word[i]];
      }
      console.log(word, node, this.root);
      let res =[]
      dfs(node)
      function dfs(node){
          if(node.isWord){
              res.push([node.word, node.rank]);
          }
          let childs = node.childs;
          for(let each of childs){
              dfs(node.children[each])
          }
      }
      return res.sort((a,b)=> b[1]-a[1]);
  }
}

let t = new SuggestionSystem