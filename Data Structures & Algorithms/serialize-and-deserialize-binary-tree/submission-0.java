/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Serialize
    public String serialize(TreeNode root) {

        if (root == null) return "#";

        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        q.offer(root);

        while (!q.isEmpty()) {

            TreeNode node = q.poll();

            if (node == null) {
                sb.append("#,");
            } else {

                sb.append(node.val).append(",");

                q.offer(node.left);
                q.offer(node.right);
            }
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

    // Deserialize
    public TreeNode deserialize(String data) {

        if (data == null || data.isEmpty() || data.equals("#")) {
            return null;
        }

        String[] values = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;

        while (!q.isEmpty() && i < values.length) {

            TreeNode parent = q.poll();

            // Left child
            if (!values[i].equals("#")) {

                TreeNode left = new TreeNode(Integer.parseInt(values[i]));

                parent.left = left;
                q.offer(left);
            }

            i++;

            // Right child
            if (i < values.length && !values[i].equals("#")) {

                TreeNode right = new TreeNode(Integer.parseInt(values[i]));

                parent.right = right;
                q.offer(right);
            }

            i++;
        }

        return root;
    }
}
