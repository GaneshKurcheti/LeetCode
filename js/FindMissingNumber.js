var findMissing = function(arr){
  let n = arr.length
  let sum = (n*(n+1))/2;
  let currentSum =0;
  for (let i = 0; i < arr.length; i++) {
    currentSum = currentSum + arr[i]
  }
  return sum-currentSum;
}
console.log(findMissing([4,0,3,1,5]))