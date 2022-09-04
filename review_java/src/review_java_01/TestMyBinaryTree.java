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

        int numKLevelNode = binaryTree.getNumKLevelNode(binaryTree.root, 3);
        System.out.println("该层的节点个数：" + numKLevelNode);

        int treeHeight = binaryTree.getTreeHeight(binaryTree.root);
        System.out.println("该树的高度是：" + treeHeight);

        System.out.println("D所在节点的值为：" + binaryTree.find(binaryTree.root, 'D').item);

        binaryTree.levelOrder(binaryTree.root);

        List<List<Character>> lists = binaryTree.otherLevelOrder(binaryTree.root);
        System.out.println(lists);

        //是不是完全二叉树
        System.out.println(binaryTree.isCompleteTree(binaryTree.root));

        MyBinaryTree<Character> myBinaryTree = new MyBinaryTree<>();
        myBinaryTree.createBinaryTree();
        System.out.println(myBinaryTree.isSameTree(myBinaryTree.root, binaryTree.root));


    }

}
