var TwoSum = function(arr, k){
  let map = new Map();
  for(let i=0;i<arr.length;i++){
    if(map.has(k-arr[i])){
      return [map.get(k-arr[i]), i]
    }
    else {
      map.set(arr[i], i)
    }
  }
  return -1;
}
console.log(TwoSum([3,5],9))