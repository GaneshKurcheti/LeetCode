public class ValidateBinarySearchTree {
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

  public static boolean isValid(TreeNode node, int max, int min) {
    if (node == null) {
      return true;
    }
    if ((node.val > max && max != -1) || (node.val < min && min != -1)) {
      return false;
    }
    return isValid(node.left, node.val, min) && isValid(node.right, max, node.val);

  }
}
