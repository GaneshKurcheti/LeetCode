var frogPosition = function(n, edges, t, target) {
  let map = new Map();
  let visited = [];
  let current =0
  let val =0
  visited.push(1)
  function createMap(){
    while(visited.length>0){
      current = visited.shift();
      for(var edge of edges){ 
        if(edge[0]==-1){
          continue;
        }
        if(edge[0]==current || edge[1]==current){
          val = edge[0] == current ?  edge[1] : edge[0];
          if(map.has(current)){
            map.get(current).push(val);
          }
          else{
            map.set(current, [val]);
          }
          edge[0]=-1;
          visited.push(val)
        }   
      }
    }   
  }
  
  createMap();
  let result = 0;
  function dfs(node,currentProb, timeLeft){
    if(timeLeft==0 && node==target){
      result = currentProb;
      return;
    }
    if(timeLeft>0 && node==target && !map.get(node)){
      result = currentProb;
      return;
    }
    if( timeLeft==0){
      return;
    }
    for(let i =0; map.has(node) && i< map.get(node).length; i++){
      dfs(map.get(node)[i], currentProb* (1/map.get(node).length), timeLeft-1);
    }
  }
  dfs( 1, 1, t)
  return result;
};
