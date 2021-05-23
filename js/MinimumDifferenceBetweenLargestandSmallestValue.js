var minDiff = function(arr){
  if(arr.length<=4){
    return 0;
  }
  arr.sort((a,b)=> a-b);
  let start = 0;
  let end = arr.length -1-3;
  let min = Number.MAX_SAFE_INTEGER;
  while(start<=3){
    min = Math.min(arr[start++]- arr[end++])
  }
  return min;

}