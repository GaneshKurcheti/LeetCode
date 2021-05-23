var kadanesAlgo = function(arr){
  let cummulative = arr[0];
  let max = arr[0];
  let endIndex =0;
  for(let i=1;i<arr.length;i++){
    cummulative =  Math.max(arr[i]+cummulative, arr[i]);
    if(cummulative> max){
      max = cummulative;
      endIndex = i;
    }
  }
  console.log(endIndex);
  return max;
}
console.log(kadanesAlgo([-2,1,-3,4,-1,2,1,-5,4]))
