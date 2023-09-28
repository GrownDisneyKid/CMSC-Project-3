public class BinaryTree {
    private TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public void constructTree(String s) {
        root = constructTree(s, 0, s.length() - 1);
    }

    private TreeNode constructTree(String s, int start, int end) {
        if (start > end) {
            return null;
        }

        int split = splitIndex(s.substring(start, end + 1));
        if (split == -1) {
            return null;
        }

        String rootData = s.substring(start, start + split + 1);

        TreeNode rootNode = new TreeNode(rootData);

        rootNode.left = constructTree(s, start + split + 2, end - 1);
        rootNode.right = constructTree(s, end + 2, end);

        return rootNode;
    }

    // Method to find the split index for the given parenthesized string
    private int splitIndex(String s) {
        int balance = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                balance++;
            } else if (c == ')') {
                balance--;
            }
            if (balance == 0) {
                return i;
            }
        }
        return -1; // Invalid input
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(TreeNode node) {
        if (node == null) {
            return true;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        if (Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(node.left) && isBalanced(node.right)) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        return isFull(root);
    }

    private boolean isFull(TreeNode node) {
        if (node == null) {
            return true;
        }

        if (node.left == null && node.right == null) {
            return true;
        }

        if (node.left != null && node.right != null) {
            return isFull(node.left) && isFull(node.right);
        }

        return false;
    }

    public boolean isProper() {
        return isProper(root);
    }

    private boolean isProper(TreeNode node) {
        if (node == null) {
            return true;
        }

        if (node.left == null && node.right == null) {
            return true;
        }

        if (node.left != null && node.right != null) {
            return isProper(node.left) && isProper(node.right);
        }

        return false;
    }

    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int getNodeCount() {
        return getNodeCount(root);
    }
    
    private int getNodeCount(TreeNode node) {
        if (node == null) {
            return 0;
        }
    
        return 1 + getNodeCount(node.left) + getNodeCount(node.right);
    }

    public String inorderTraversal() {
        StringBuilder result = new StringBuilder();
        inorderTraversal(root, result);
        return result.toString();
    }

    private void inorderTraversal(TreeNode node, StringBuilder result) {
        if (node != null) {
            inorderTraversal(node.left, result);
            result.append(node.data).append(" ");
            inorderTraversal(node.right, result);
        }
    }

    public String finalOrder() {
        StringBuilder result = new StringBuilder();
        finalOrder(root, result);
        return result.toString();
    }
    
    private void finalOrder(TreeNode node, StringBuilder result) {
        if (node != null) {
            finalOrder(node.left, result);
            finalOrder(node.right, result);
            result.append(node.data).append(" ");
        }
    }
}
