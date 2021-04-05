import java.util.ArrayList;
import java.util.List;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}

class NodeWithLevel {
  TreeNode NodeVal;
  int NodeLevel;

  public NodeWithLevel(TreeNode node, int level) {
    this.NodeVal = node;
    this.NodeLevel = level;
  }
}

public class BinaryTreeRightSideView {
  public static List<Integer> BinaryTreeRightSideBFS(TreeNode node) {
    List<NodeWithLevel> queue = new ArrayList<>();
    List<Integer> rights = new ArrayList<>();
    if (node == null) {
      return rights;
    }
    queue.add((new NodeWithLevel(node, 0)));
    while (queue.size() > 0) {
      NodeWithLevel current = queue.get(0);
      if (current.NodeVal.left != null) {
        queue.add(new NodeWithLevel(current.NodeVal.left, current.NodeLevel + 1));
      }
      if (current.NodeVal.right != null) {
        queue.add(new NodeWithLevel(current.NodeVal.right, current.NodeLevel + 1));
      }
      if (queue.size() == 1 || queue.get(1).NodeLevel != current.NodeLevel) {
        rights.add(current.NodeVal.val);
      }
      queue.remove(0);
    }
    return rights;
  }

  public static void BinaryTreeRightSideDFSHelper(TreeNode node, List<Integer> values, int level) {
    if (values.size() == level) {
      values.add(level);
    }
    if (node.right != null)
      BinaryTreeRightSideDFSHelper(node.right, values, level + 1);
    if (node.left != null)
      BinaryTreeRightSideDFSHelper(node.left, values, level + 1);
  }

  public static List<Integer> BinaryTreeRightSideDFS(TreeNode node) {
    List<Integer> results = new ArrayList<>();
    BinaryTreeRightSideDFSHelper(node, results, 0);
    return results;
  }

}
