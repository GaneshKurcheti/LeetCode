
var countSquares = function(matrix) {
    let sum =0;
    function getAllSquares(){
        for(let i=0;i< matrix.length;i++){
            for(let j=0;j< matrix[0].length; j++){
                if(matrix[i][j]>=1){
                    sum+=1;
                }
                if(i-1>=0 &&j-1>=0&& matrix[i-1][j]!=0 &&matrix[i-1][j-1]!=0&& matrix[i][j-1]!=0 && matrix[i][j]>=1){
                    matrix[i][j] = Math.min( matrix[i-1][j], matrix[i-1][j-1],  matrix[i][j-1])+1;
                    sum += matrix[i][j]-1
                }
            }
        }
        return sum;
    }
    getAllSquares();
    return sum; 
    
};