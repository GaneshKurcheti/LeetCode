var debounce = function(fn, delay){
  let timeout;
  return function(...args){
    if(timeout){
      clearTimeout(timeout);
    }
    timeout = setInterval(()=> {fn(...args)}, delay)
  }
}


var throttle = function(fn, delay){
  let time;
  return function(...args){
    let now = new Date().getTime()
    if(time && now-time < delay){
      return;
    }
    time = now;
    return fn(...args)
  }
}