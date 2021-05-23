var thisFunction =  function(){
  console.log(this);
}
let obj ={t: "dest"}
thisFunction.call(obj)
console.log(2-'2') // 0 -  number operator only
console.log(2+'2') // 22-concatinate operator
let nums = [1,2,2,3]
nums = new Set(nums)
// console.log(Array.from(nums))
console.log([...(nums)])
console.log(5<6<7); // 5<6 ---true ----1
console.log(7>6>5); // 7>6---true----1

var func = function(){
 {

 (function(){
    let l = "let";
    var v = "var";
  })()
}
  // console.log(v)
  // console.log(l)
}
func()

Object.freeze(t); // will not able to add more properties or update the existing
Object.seal(t); // will able to add new but able to update


class EventEmitter {
  constructor () {
    this.events = {}
  }

  on (eventName, callbackFn) {
    if (!this.events[eventName])  {
      this.events[eventName] = []
    }
    this.events[eventName].push(callbackFn)
  }

  emit (eventName, eventData) {
    if (!this.events[eventName]) return
    this.events[eventName].forEach(fn => fn(eventData))  
  }

  removeListener (eventName, callbackFn) {
    const idx = this.events[eventName].indexOf(callbackFn)
    if (idx === -1) return
    this.events[eventName].splice(idx, 1)
  }
}
// Promises
// Debiunce
// Throttle
// Closure as a counter
function tracker (fn) {
  let numTimesCalled = 0
  return function () {
    numTimesCalled++
    console.log('I was called', numTimesCalled)
    return fn()
  }
}

function hello () {
  console.log('hello')
}

const trackedHello = tracker(hello)