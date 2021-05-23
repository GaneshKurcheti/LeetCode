var checkIfPossible = function(words, str){
  function isPossible(str){
    if(str.length ==0 ){
      return true;
    }
    for(let i = 0;i< words.length;i++){
      if(str.startsWith(words[i])){
        return isPossible(str.substring(words[i].length))
      }
    }
    return false;
  }
  return isPossible(str)
}
console.log(checkIfPossible(["apple", "app", "le", "test"],"appletest"))