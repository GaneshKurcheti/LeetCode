var balencedBraces = function(input){
  let result = [];
  function getBraces(input, output, current){
    if( input == output && input ==0){
      result.push(current);
      return;
    }
    else if(input ==0 ){
      getBraces(input, output-1,current+")");
    }
    else if(input == output){
      getBraces(input-1,output, current+"(")
    }
    else if(input< output){
      getBraces(input-1, output, current+"(");
      getBraces(input, output-1, current+")")
    }
    return;
  }
  getBraces(input, input, "")
  console.log(result);
}
balencedBraces(1)