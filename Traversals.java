import java.util.ArrayList;
import java.util.List;

public class Traversals {
  public class TreeNode {
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

  public static List<Integer> InorderHelper(TreeNode root, List<Integer> values) {
    if (root == null) {
      return values;
    }
    InorderHelper(root.left, values);
    values.add(root.val);
    InorderHelper(root.right, values);
    return values;
  }

  public static List<Integer> PreorderHelper(TreeNode root, List<Integer> values) {
    if (root == null) {
      return values;
    }
    values.add(root.val);
    PreorderHelper(root.left, values);
    PreorderHelper(root.right, values);
    return values;
  }

  public static List<Integer> PostorderHelper(TreeNode root, List<Integer> values) {
    if (root == null) {
      return values;
    }
    PostorderHelper(root.left, values);
    PostorderHelper(root.right, values);
    values.add(root.val);
    return values;
  }

  public static List<Integer> inOrder(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    return InorderHelper(root, result);
  }

}
