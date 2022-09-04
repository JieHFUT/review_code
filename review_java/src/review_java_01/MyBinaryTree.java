package review_java_01;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-03
 * Time: 22:39
 */
public class MyBinaryTree<E> {

    class Node<E> {
        E item;
        Node<E> right;
        Node<E> left;

        public Node(E item) {
            this.item = item;
        }
    }

    Node<Character> root;

    public void createBinaryTree(){
        Node<Character> A = new Node<>('A');
        Node<Character> B = new Node<>('B');
        Node<Character> C = new Node<>('C');
        Node<Character> D = new Node<>('D');
        Node<Character> E = new Node<>('E');
        Node<Character> F = new Node<>('F');
        Node<Character> G = new Node<>('G');
        Node<Character> H = new Node<>('H');

        A.left = B;
        A.right = C;
        B.left = D;
        B.right = E;
        C.left = F;
        C.right = G;
        D.left = H;
        this.root = A;

    }


    //遍历
    public void preOrder(Node<E> root){
        if (root == null) return;
        System.out.print(root.item + " ");
        this.preOrder(root.left);
        this.preOrder(root.right);
        return;
    }

    public void inOrder(Node<E> root){
        if (root == null) return;
        this.inOrder(root.left);
        System.out.print(root.item + " ");
        this.inOrder(root.right);
        return;
    }

    public void postOrder(Node<E> root){
        if (root == null) return;
        this.postOrder(root.left);
        this.postOrder(root.right);
        System.out.print(root.item + " ");
        return;
    }


    public List<E> otherPreOrder(Node<E> root){

        List<E> ret = new ArrayList<>();
        if (root == null) return ret;

        ret.add(root.item);

        List<E> leftTree = this.otherPreOrder(root.left);
        ret.addAll(leftTree);

        List<E> rightTree = this.otherPreOrder(root.right);
        ret.addAll(rightTree);

        return ret;
    }


    public List<E> otherInOrder(Node<E> root){

        List<E> ret = new ArrayList<>();
        if (root == null) return ret;

        List<E> leftTree = this.otherInOrder(root.left);
        ret.addAll(leftTree);

        ret.add(root.item);

        List<E> rightTree = this.otherInOrder(root.right);
        ret.addAll(rightTree);

        return ret;
    }

    public List<E> otherPostOrder(Node<E> root){

        List<E> ret = new ArrayList<>();
        if (root == null) return ret;

        List<E> leftTree = this.otherPostOrder(root.left);
        ret.addAll(leftTree);

        List<E> rightTree = this.otherPostOrder(root.right);
        ret.addAll(rightTree);

        ret.add(root.item);

        return ret;
    }


    /**
     * 获取树中的节点个数
     * @param root
     * @return
     */
    private static int numTreeNode;

    public int getNumNode(Node<E> root){
        if (root == null) return 0;
        return this.getNumNode(root.left) +
                this.getNumNode(root.right) + 1;
    }

    public int owngetNumNode(Node<E> root){
        if (root == null) return numTreeNode;
        numTreeNode++;
        this.owngetNumNode(root.right);
        this.owngetNumNode(root.left);
        return numTreeNode;
    }


    /**
     * 获取叶子节点个数
     * @param root
     * @return
     */
    public int getNumLeafNode(Node<E> root){
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return this.getNumLeafNode(root.right) +
                this.getNumLeafNode(root.left);
    }


    /**
     * 获取第 K 层节点个数
     * @param root
     * @param k
     * @return
     */
    public int getNumKLevelNode(Node<E> root, int k){
        if (root == null) return 0;
        if (root != null && k == 1) return 1;
        return this.getNumKLevelNode(root.left, k-1) +
                this.getNumKLevelNode(root.right, k-1);
    }

    /**
     * 获取二叉树的树的高度
     * @param root
     * @return
     */
    public int getTreeHeight(Node<E> root){
        if (root == null) return 0;
        return Math.max(this.getTreeHeight(root.right),
                         this.getTreeHeight(root.left)) + 1;
    }


    /**
     * 检测 e 这个值是不是存在
     * @param root
     * @param e
     * @return
     */
    public Node<E> find(Node<E> root, E e){

        if (root == null) return null;
        if (root.item.equals(e)) return root;

        Node<E> node1 = this.find(root.left, e);
        if (node1 != null) return node1;

        Node<E> node2 = this.find(root.right, e);
        if (node2 != null) return node2;

        return null;
    }


    /**
     * 层序遍历
     * @param root
     */
    public void levelOrder(Node<E> root){
        if (root == null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            System.out.print(queue.poll().item + " ");
            if (root.left != null){
                queue.offer(root.left);
            }
            if (root.right != null){
                queue.offer(root.right);
            }
            root = queue.peek();
        }
        System.out.println();
        return;
    }


    public List<List<E>> otherLevelOrder(Node<E> root){
        List<List<E>> lists = new ArrayList<>();
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<E> eList = new ArrayList<>();
            while (size > 0){
                eList.add(queue.poll().item);
                size--;
                if (root.left != null)
                    queue.offer(root.left);
                if (root.right != null)
                    queue.offer(root.right);
                root = queue.peek();
            }
            lists.add(eList);
        }
        return lists;
    }


    /**
     * 判断一棵树是不是完全二叉树
     * @param root
     * @return
     */
    public boolean isCompleteTree(Node<E> root){
        if (root == null) return true;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            queue.poll();
            if (root != null){
                queue.offer(root.left);
                queue.offer(root.right);
            }else {
                break;
            }
            root = queue.peek();
        }
        //判断queue是不是全部都是null
        while (!queue.isEmpty()){
            if (queue.poll() != null) return false;
        }
        return true;
    }


    public boolean isSameTree(Node<E> root1, Node<E> root2){
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        return this.isSameTree(root1.left, root2.left) &&
                this.isSameTree(root1.right, root2.right) &&
                root1.item == root2.item;
    }



    /**
     * 判断一棵树是不是包含另外一颗树 ------- 没有解决
     * @param root
     * @param subRoot
     * @return
     */
    public boolean isSubtree(Node<E> root, Node<E> subRoot){
        if (subRoot == null) return true;
        if (root == null) return false;

        while (root != null){
            if (root.item == subRoot.item){
                boolean flg = judgeSameRootIsSubTree(root, subRoot);
                if (flg == true) return true;
            }else {
                boolean flg1 = this.isSubtree(root.left, subRoot);
                if (flg1 == true) return true;
                boolean flg2 = this.isSubtree(root.right, subRoot);
                if (flg2 == true) return true;
            }
        }

        return false;
    }

    private boolean judgeSameRootIsSubTree(Node<E> root, Node<E> subRoot){

        if (subRoot.left == null && subRoot.right == null) return true;

        if (subRoot.left != null){
            if (root.left == null || subRoot.left.item != root.left.item) return false;
            boolean flg1 = judgeSameRootIsSubTree(root.left, subRoot.left);
            if (flg1 != true) return false;
        }
        if (subRoot.right != null){
            if (root.right == null || subRoot.right.item != root.right.item) return false;
            boolean flg2 = judgeSameRootIsSubTree(root.right, subRoot.right);
            if (flg2 != true) return false;
        }
        return true;
    }



    /*public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        //先找到头结点都相同的节点
        boolean res;
        res = isOrNot(root, subRoot);
        res |= isSubtree(root.left, subRoot);
        res |= isSubtree(root.right, subRoot);
        return res;
    }
    //节点比对
    public boolean isOrNot(TreeNode root, TreeNode subRoot) {
        if (subRoot == null && root == null) return true;
        if (root == null || subRoot == null) return false;
        if (root.val != subRoot.val) return false;
        boolean res = true;
        //入果当前节点相等，那么从左到右依次比较
        //向左递归
        res &= isOrNot(root.left, subRoot.left);
        //向右递归
        res &= isOrNot(root.right, subRoot.right);
        return res;
    }*/


    /**
     * 给定一个二叉树，判断它是否是高度平衡的二叉树。
     * 一棵高度平衡二叉树定义为：
     * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
     * @param root
     * @return
     */
    public boolean isBanlance(Node<E> root){
        return false;
    }


















}
