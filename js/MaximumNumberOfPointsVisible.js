// Its in leetcode https://leetcode.com/problems/maximum-number-of-visible-points/discuss/889670/JavaScript-sliding-window-easy-reading-code-and-explanation

//  first find the angele made by each point with the given target point and store it in array sort tehm based on angele

//  we want it to be circular so rotate the array by adding 360 to each point once again

// Now its sliding window problem 
let start=0,n=points.length,result=0
  for (let end = 0; end < n; end++) {
      while(start<end&&points[start]<points[end]-angle) //if the point of start is no bueno
          start++ // shrink the window until all the points are within angle degrees 
      result=Math.max(result,end-start+1)
  }