var maxAreaOfIsland = function(grid) {
    let result  = 0;
    function getArea(i, j){
      if(i<0 || j<0 || i>= grid.length || j>= grid[0].length || grid[i][j]==0){
        return 0;
      }
      else{
        grid[i][j]=0;
        return 1+ getArea(i-1, j)+ getArea(i+1,j)+ getArea(i,j+1) +getArea(i, j-1);
      }
    }
    for(let i=0;i< grid.length;i++){
      for(let j=0;j< grid[0].length;j++){
        if(grid[i][j]==1){
          result =  Math.max(getArea(i, j), result);
        }
      }
    }
    return result;
};