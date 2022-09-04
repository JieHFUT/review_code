package review_java_01;

import java.util.ArrayList;
import java.util.List;

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



    public int getNumKLevelNode(Node<E> root, int k){

    }




























}
