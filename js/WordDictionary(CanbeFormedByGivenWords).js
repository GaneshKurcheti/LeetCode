var isPossible = function(words, str){
  let result=[]; 
  function checkForPossibility(str, current){
    if(str.length ==0){
      result.push(current)
      return;
    }
    for(let i=0;i<words.length;i++){
      if(str.startsWith(words[i])){
        checkForPossibility(str.substring(words[i].length), current.concat([words[i]]))
      }
    }
  }
  checkForPossibility(str, [])
  console.log(JSON.stringify(result));
}
isPossible(["app", "apple", "test", "le" ], "applettest")
