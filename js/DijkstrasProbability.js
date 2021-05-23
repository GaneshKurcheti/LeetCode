/**
 * @param {number} n
 * @param {number[][]} edges
 * @param {number[]} succProb
 * @param {number} start
 * @param {number} end
 * @return {number}
 */
var maxProbability = function(n, edges, succProb, start, end) {
    let map = new Map();
    for(let i=0;i< edges.length;i++){
        if(!map.has(edges[i][0])){
            map.set(edges[i][0], [])
        }
        if(!map.has(edges[i][1])){
            map.set(edges[i][1], []);
        }
        map.get(edges[i][0]).push([edges[i][1], succProb[i]])        
        map.get(edges[i][1]).push([edges[i][0], succProb[i]])
    }
    let visited = new Set();
    let values =  [[start, 1]]
    while(values.length> 0){
        let [currentNode, prob]  =  values.shift();
        if(visited.has(currentNode)){
            continue;
        }
        visited.add(currentNode)
        if(end == currentNode){
            return prob;
        }
        if(map.has(currentNode)){
        for(let each of map.get(currentNode)){
            if(!visited.has(each[0])){
                values.push([each[0], prob*each[1]])
            }
        }
        }
        values.sort((a,b)=>b[1]-a[1])
    }
    return 0;
};