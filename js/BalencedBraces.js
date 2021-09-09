let balencedBraces =  function(k){
  let results=[];
  let dfs = (current, opens, closes)=>{
    if(opens == closes && opens ==0 ){
      results.push(current);
      return;
    }
    else if(opens ==0){
      dfs(current +")", opens, closes-1)
    }
    else if(opens == closes){
      dfs(current+ "(", opens-1, closes)
    }
    else if(opens< closes){
      dfs(current+"(", opens-1, closes)
      dfs(current+")", opens, closes-1)
    }
  }
  dfs("",k,k);
  console.log(results);
}
balencedBraces(2);