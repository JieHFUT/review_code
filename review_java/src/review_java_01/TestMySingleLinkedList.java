package review_java_01;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-01
 * Time: 20:20
 */
public class TestMySingleLinkedList {

    public static void main(String[] args) {

        MySingleLinkedList<Integer> mySingleLinkedList = new MySingleLinkedList<>();

        mySingleLinkedList.addFirst(11);
        mySingleLinkedList.addFirst(22);
        mySingleLinkedList.addFirst(33);
        mySingleLinkedList.addFirst(44);
        mySingleLinkedList.display();

        System.out.println(mySingleLinkedList.size());
        mySingleLinkedList.addIndex(4,55);
        mySingleLinkedList.display();

        System.out.println(mySingleLinkedList.contains(12));
        System.out.println(mySingleLinkedList.contains(44));
        System.out.println("=============================");


        mySingleLinkedList.remove(11);
        mySingleLinkedList.display();
        //mySingleLinkedList.remove(1);


        mySingleLinkedList.addLast(11);
        mySingleLinkedList.addIndex(3,11);
        mySingleLinkedList.addIndex(5,11);
        mySingleLinkedList.addFirst(11);
        mySingleLinkedList.display();
        mySingleLinkedList.removeAllKey(11);
        mySingleLinkedList.display();


        //mySingleLinkedList.clear();
        //mySingleLinkedList.display();

        mySingleLinkedList.reverse();
        mySingleLinkedList.display();


        System.out.println(mySingleLinkedList.returnLastK(2).value);


    }


}
