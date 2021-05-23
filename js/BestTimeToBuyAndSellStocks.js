let BestTimeToBuyAndSellShare =  function(arr){
  if(arr.length <= 1 ){
    return -1;
  }
  let minVal  =  arr[0];
  let maxValue  =  Number.MIN_SAFE_INTEGER;
  for(let k of arr){
    maxValue = Math.max(maxValue, k- minVal );
    minVal = Math.min(k,minVal);
  }
  return maxValue;
}
