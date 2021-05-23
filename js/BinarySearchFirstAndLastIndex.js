var binarySearch = function(arr, k){
  let l = 0;
  let r = arr.length-1;
  let startIndex = -1;
  let endIndex = -1;
  while(l<=r){
    let mid = parseInt((l+r)/2)
    if(arr[mid] == k && arr[mid-1] !=k ){
      startIndex = mid
      break;
    }
    if(arr[mid] >=k ){
      r = mid-1;
    }
    else{
      l = mid+1;
    }
  }
  l=0;
  r= arr.length-1;
  while(l<=r){
    let mid = parseInt((l+r)/2)
    if(arr[mid] == k && arr[mid+1]!=k){
      endIndex = mid;
      break;
    }
    if(arr[mid]<=k){
      l= mid+1;
    }
    else{
      r= mid-1;
    }
  }
  return [startIndex,endIndex]
}
 console.log(binarySearch([5,6,7,7,7,7,7,9,9,10], 10))
