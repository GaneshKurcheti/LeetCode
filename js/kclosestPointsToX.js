var findClosestElements = function(arr, k, x) {
  let l = 0
 let r = arr.length
 let index = -1  
 if(arr[arr.length-1] <x){
   return arr.slice(arr.length-k)
 }
 else if(arr[0] >x) {
   return arr.slice(0, k)
 }
 while(l<r){
     mid =parseInt( (l+r)/2);
     if(arr[mid] == x){
         index = mid
         break;
     }
     else if(arr[mid] < x && arr[mid+1]>x){
         index  =  x-arr[mid]>  arr[mid+1]-x ? mid+1 : mid
         break;
     }
     else if(arr[mid]> x){
         r= mid;
     }
     else{
         l = mid;
     } 
 }
 let i=index;
 let j = index;
 let result =[];
 while(k!=1){
   if(i==0){
     j++;
   }
   else if(j==arr.length-1){
     i--;
   }
   else if(x - arr[i-1] <= arr[j+1]-x){
     i--;
   }
   else{
     j++;
   }
   k--;
 }
 return arr.slice(i, j+1);
};
console.log(findClosestElements([0,0,0,1,3,5,6,7,8,8]
  ,2
  ,2))