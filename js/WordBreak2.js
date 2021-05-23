var wordBreak = function(s, wordDict) {
  let res =  [];
  function dfs(currentWord, words){
    if(currentWord.length ==0){
      res.push(words.join(" "));
      return;
    }
    for(let i=0;i< wordDict.length;i++){
      if(currentWord.startsWith(wordDict[i])){
        dfs(currentWord.slice(wordDict[i].length,words.concat([wordDict[i]])))
      }
    }
  }
  dfs(s,[])
  return res;
}