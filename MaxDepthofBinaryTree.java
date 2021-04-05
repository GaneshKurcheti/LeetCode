public class MaxDepthofBinaryTree {
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

  public static int getMaxDepthHelper(TreeNode node, int currentMax) {
    if (node == null) {
      return currentMax;
    }
    return Math.max(getMaxDepthHelper(node.left, currentMax + 1), getMaxDepthHelper(node.right, currentMax + 1));
  }

  public static int getMaxDepth(TreeNode root) {
    return getMaxDepthHelper(root, 0);

  }
}
