var sum = function(a , b){
  while((a&b)!=0){
    a= a^b;
    b= (a&b)<<1;
  }
  return a^b;
}
console.log(sum(3,8))