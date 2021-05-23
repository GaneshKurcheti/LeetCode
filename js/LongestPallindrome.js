var longestPallindrome =  function(str){
  let result ="";
  function getlongest(stratIndex, endIndex){
    let l = stratIndex;
    let r = endIndex;
    while(l>=0 && r<str.length && str[l]==str[r]){
      if(r-l+1 > result.length){
        result = str.substring(l,r+1)
      }
      l--;
      r++;
    }
  }
  for(var i=0;i< str.length;i++){
    getlongest(i,i);
    if(i+1< str.length){
      getlongest(i,i+1)
    }
  }
  return result;
}
console.log(longestPallindrome("aabcb"))