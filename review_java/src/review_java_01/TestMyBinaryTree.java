package review_java_01;


import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-03
 * Time: 22:40
 */
public class TestMyBinaryTree {
    public static void main(String[] args) {

        MyBinaryTree<Character> binaryTree = new MyBinaryTree<>();
        binaryTree.createBinaryTree();

        binaryTree.preOrder(binaryTree.root);
        System.out.println();
        binaryTree.inOrder(binaryTree.root);
        System.out.println();
        binaryTree.postOrder(binaryTree.root);
        System.out.println();

        List<Character> list1 =  binaryTree.otherPreOrder(binaryTree.root);
        System.out.println(list1);

        List<Character> list2 =  binaryTree.otherInOrder(binaryTree.root);
        System.out.println(list2);

        List<Character> list3 =  binaryTree.otherPostOrder(binaryTree.root);
        System.out.println(list3);

        int numTreeNode = binaryTree.getNumNode(binaryTree.root);
        System.out.println("树中节点的个数：" + numTreeNode);




    }

}
