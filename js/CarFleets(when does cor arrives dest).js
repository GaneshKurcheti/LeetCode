var carFleet = (target, position, speed)=>{
  let cars  =  [];
  for(let i=0;i< position.length;i++){
    cars.push([position[i], speed[i]])
  }
  cars.sort((a,b)=>a[0]- b[0]);
  let lastCarIndex =  cars.length-1;
  let count = cars.length;
  for(var i = lastCarIndex-1 ; i>=0;i--){
    let lastCarTimeTaken  =  (target - cars[lastCarIndex][0])/ cars[lastCarIndex][1];
    let currCarTimeTaken  =  (target - cars[i][0])/ cars[i][1];
    if(currCarTimeTaken<=  lastCarTimeTaken){
      count--;
    }
    else{
      lastCarIndex = i;
    }
  }
  return count;

}

console.log(carFleet(12, [10,8,0,5,3], [2,4,1,1,3]));