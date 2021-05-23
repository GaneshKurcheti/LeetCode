var MinIncrements =  function(arr){
  let res =  arr[0];
  for(let i =1;i<arr.length;i++){
    if(arr[i]< arr[i-1]){
      continue;
    }
    res = res+arr[i]- arr[i-1];
  }
  return res;
}
console.log(MinIncrements([1,2,3,2,1]))