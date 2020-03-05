//-------------------------------------------------------------------------------
//    Misha Ward
//-------------------------------------------------------------------------------

/*-------------------------------------------------------------------------------

Problem:
Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1


Example 2:
Input:

        1
       / \
      2   3
     /   / \
    4   5   6
       /
      7

Output:
7

-------------------------------------------------------------------------------*/

//-------------------------------------------------------------------------------
//    Approach
//-------------------------------------------------------------------------------

/*
    1) Breath first search, store the imediate first value in each loop on the level
*/

//-------------------------------------------------------------------------------
//    Soluton
//-------------------------------------------------------------------------------

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int size = q.size();
        int res = 0;
        while (!q.isEmpty()) {
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.remove();
                if (i == 0)
                    res = temp.val;
                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);
            }
            size = q.size();
        }
        return res;
    }
}

/*
    Runtime: 1 ms, faster than 69.52% of Java online submissions for Find Bottom Left Tree Value.
    Memory Usage: 41.3 MB, less than 8.70% of Java online submissions for Find Bottom Left Tree Value.
*/
