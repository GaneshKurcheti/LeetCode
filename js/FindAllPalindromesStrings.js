var findAllPallindromes = function(str){
  let count =0;
  let result = [];
  function getAllPallindromes(startIndex, endIndex){
    let l = startIndex;
    let r = endIndex;
    while(l>=0 && r<=str.length  && str[l] == str[r]){
      result.push(str.substring(l,r+1))
      count++;
      l--;
      r++;
    }
  }
  for(let i=0;i< str.length; i++){
    getAllPallindromes( i, i);
    if(i+1< str.length){
      getAllPallindromes( i, i+1)
    }
  }
  return result;
}
console.log(findAllPallindromes("abacdca"))