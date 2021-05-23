var mergeIntervals = function(arr){
  let stack = [];
  arr.sort((a,b)=> a[0]-b[0]);
  console.log(JSON.stringify(arr));
  for(let i =0;i<arr.length;i++){
    if(stack.length==0){
      stack.push(arr[i]);
    }
    else if(stack[stack.length-1][1]>=arr[i][0] && stack[stack.length-1][1]<=arr[i][1]){
      stack[stack.length-1][1]= arr[i][1]
    }
    else{
      stack.push(arr[i])
    }
  }
  return stack;
}
console.log(JSON.stringify(mergeIntervals([[1,4],[4,5]])))