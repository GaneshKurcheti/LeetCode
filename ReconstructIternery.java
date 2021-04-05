import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class ReconstructIternery {
  public static HashMap<String, List<String>> generatePathMap(List<List<String>> paths) {
    HashMap<String, List<String>> pathMap = new HashMap<>();
    for (var each : paths) {
      if (pathMap.containsKey(each.get(0))) {
        pathMap.get(each.get(0)).add(each.get(1));
      } else {
        List<String> temps = new ArrayList<>();
        temps.add(each.get(1));
        pathMap.put(each.get(0), temps);
      }
    }
    for (var entry : pathMap.entrySet()) {
      Collections.sort(entry.getValue());
    }
    return pathMap;
  }

  public static List<String> getTotalPath(List<List<String>> paths) {
    HashMap<String, List<String>> pathMap = generatePathMap(paths);
    List<String> result = new ArrayList<>();
    Stack<String> vals = new Stack<>();
    vals.push("JFK");
    while (vals.size() > 0) {
      var curr = pathMap.getOrDefault(vals.peek(), null);
      if (curr != null && curr.size() > 0) {
        vals.push(curr.get(0));
        curr.remove(0);
      } else {
        result.add(vals.pop());
      }
    }
    Collections.reverse(result);

    return result;
  }

  public static void main(String[] args) {
    List<List<String>> paths = new ArrayList<>();
    paths.add(Arrays.asList("MUC", "LHR"));
    paths.add(Arrays.asList("JFK", "MUC"));
    paths.add(Arrays.asList("SFO", "SJC"));
    paths.add(Arrays.asList("LHR", "SFO"));
    List<String> result = getTotalPath(paths);
    System.out.println(Arrays.toString(result.toArray()));
  }
}
