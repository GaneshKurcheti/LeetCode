class TimeMapValue{
  constructor(timestamp, value){
    this.time = timestamp;
    this.val =  value;
  }
}
class TimeMap{
  constructor(){
    this.map = new Map();
  }
  set(key, value, timestamp){
    if(this.map.has(key)){
      this.map.get(key).push(new TimeMapValue(timestamp, value));
    }
    else{
      this.map.set(key, [new TimeMapValue(timestamp,value)])
    }
  }
  get(key, timestamp){
    if(!this.map.has(key)){
      return "";
    }
    let vals =  this.map.get(key);
    let l = 0;
    let r = vals.length-1;
    while(l<=r){
      let mid  = parseInt((l+r)/2);
      if( vals[mid].time == timestamp){
        return vals[mid].val;
      }
      else if(vals[mid].time < timestamp && !vals[mid+1]){
        return vals[mid].val;
      }
      else if(vals[mid].time < timestamp && vals[mid+1] && vals[mid+1].time>timestamp){
        return vals[mid].val;
      }
      else if(vals[mid].time > timestamp){
        r = mid-1; 
      }
      else{
        l = mid+1;
      }
    }
    return "";

  }
}