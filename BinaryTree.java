import java.util.Arrays;
import java.util.Stack;

/**
 * public class TreeNode {
 *     int data;
 *     TreeNode left;
 *     TreeNode right;
 *
 *     public TreeNode(int data){
 *         this.data = data;
 *         left = null;
 *         right = null;
 *     }
 * }
 */

public class main {

    /**
     * 先序遍历
     * @param root
     */
    public static void PreOrderLoop(TreeNode root){
        if (root == null) //为空
            return;
        Stack stack = new Stack(); //栈
        TreeNode cur = root;

        while (cur != null || !stack.empty()){ //结点不为空 栈不为空
            while (cur != null){
                System.out.println(cur.data);
                stack.push(cur);
                cur = cur.left;
            }

            cur = (TreeNode) stack.pop();
            cur = cur.right;
        }
    }

    /**
     * 中序遍历
     * @param root
     */
    public static void InOrderLoop(TreeNode root){
        if (root == null)
            return;
        Stack stack = new Stack(); //栈
        TreeNode cur = root;

        while (cur != null || !stack.empty()){ //结点不为空 栈不为空
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            cur = (TreeNode) stack.pop();
            System.out.println(cur.data);
            cur = cur.right;
        }
    }

    /**
     * 后序遍历
     * @param root
     */
    public static void PostOrderLoop(TreeNode root){
        if (root == null)
            return;
        Stack stack = new Stack(); //栈
        TreeNode cur = root;
        TreeNode top = null;
        TreeNode last = null;

        while (cur != null || !stack.empty()){ //结点不为空 栈不为空
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }

            top = (TreeNode) stack.peek();

            if (top.right == null || top.right == last){
                stack.pop();
                System.out.println(top.data);
                last = top;
            } else {
                cur = top.right;
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println("/========= 先序遍历 =========/");
        PreOrderLoop(root);
        System.out.println("/========= 中序遍历 =========/");
        InOrderLoop(root);
        System.out.println("/========= 后序遍历 =========/");
        PostOrderLoop(root);
    }
}