var GetImportance = function(employees, id) {
  let result = 0;
  let map = new Map();
  for(var each of employees){
      map.set(each.id, each)
  }
  function dfs(id){
      let emp = map.get(id);
      result = result+ emp.importance;
      for(let each of emp.subordinates){
          dfs(each);
      }
  }
  dfs(id);
  return result;
};