var threeSum =  function(arr, k){
  quicksort(arr, 0, arr.length-1);
  result =  [];
  for(let i=0;i<arr.length;i++){
    if(arr[i]>k){
      return result;
    }
    if(arr[i]==arr[i-1]){
       continue;
    }
    let l = i+1;
    let r = arr.length-1
    while(l<r){
      if(arr[i]+arr[l]+arr[r] ===k){
        result.push([arr[i], arr[l], arr[r]]);
        l++;
        r--;
        while(l<r && arr[l]==arr[l-1]){
          l++
        }
        while(l<r && arr[r]==arr[r+1]){
          r--;
        }
      }
      else if(arr[i]+arr[l]+arr[r] >k){
        r--;
      }
      else{
        l++;
      }
    }
  }
  return result;
}
var quicksort = function(arr, start, end){
  if(start>=end){
    return;
  }
  let i =-1;
  let j =0;
  let pivot = arr[end];
  while(j<end){
    if(arr[j]<=pivot){
      let temp = arr[i+1]
      arr[i+1]=arr[j]
      arr[j] = temp;
      i++;
    }
    j++;
  }
  i++;
  let temp = arr[i]
  arr[i] = pivot;
  arr[end] =  temp;
  quicksort(arr, start,i-1);
  quicksort(arr, i+1, end );
}
console.log(JSON.stringify(threeSum([-1,0,1,2,-1,-4], 0)))