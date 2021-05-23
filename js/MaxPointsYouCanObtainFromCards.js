var maxScore = function(cardPoints, k) {
    let sum = 0;
    let maxSum =0;
    if( k > cardPoints.length){
      return cardPoints.reduce((a,b)=> a+b, 0)
    }
    for(let i=0;i< k;i++ ){
      sum = sum + cardPoints[i];
    }
    maxSum = sum;
    k = k-1;
    let n = cardPoints.length -1;
    while(k>=0){
      sum = sum - cardPoints[k] + cardPoints[n]
      maxSum = Math.max(maxSum, sum)
      k--;
      n--;
    }
    return maxSum;
};
console.log(maxScore([1,3,4],2))