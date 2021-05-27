var minSumOfLengths = function(arr, target) {
    let map = new Map();
    let sum =0;
    map.set(0, -1);
    for(let i=0;i<arr.length ;i++){
        sum += arr[i];
        map.set(sum, i);
    }
    sum =0;
    let leftMin = Number.MAX_SAFE_INTEGER;    
    let res = Number.MAX_SAFE_INTEGER;
    for(let i=0;i< arr.length ;i++){
        sum = sum +arr[i]
        if(map.has(sum- target)){
            leftMin = Math.min(leftMin, i- map.get(sum- target)) 
        }
        if(map.has(sum+target) && leftMin<Number.MAX_SAFE_INTEGER){
            res =  Math.min(res, leftMin+ map.get(sum+target)-i)
        }
    }
    return res==Number.MAX_SAFE_INTEGER ? -1 : res;
};