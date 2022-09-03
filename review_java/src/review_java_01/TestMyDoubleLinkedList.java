package review_java_01;


import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-09-02
 * Time: 8:42
 */
public class TestMyDoubleLinkedList {
    public static void main(String[] args) {
        MyDoubleLinkedLIst<Integer> myDoubleLinkedLIst = new MyDoubleLinkedLIst<>();
        myDoubleLinkedLIst.addFirst(10);

        myDoubleLinkedLIst.remove(10);
        System.out.println(myDoubleLinkedLIst);

        myDoubleLinkedLIst.addFirst(11);
        myDoubleLinkedLIst.addFirst(12);
        myDoubleLinkedLIst.addFirst(13);
        myDoubleLinkedLIst.addFirst(14);

        System.out.println(myDoubleLinkedLIst);
        System.out.println(myDoubleLinkedLIst.size());

        myDoubleLinkedLIst.addIndex(2,99);
        System.out.println(myDoubleLinkedLIst);

        System.out.println(myDoubleLinkedLIst.contains(99));
        System.out.println(myDoubleLinkedLIst.contains(199));

        myDoubleLinkedLIst.remove(99);
        //myDoubleLinkedLIst.remove(999);
        System.out.println(myDoubleLinkedLIst);

        myDoubleLinkedLIst.addFirst(11);
        myDoubleLinkedLIst.addFirst(11);
        myDoubleLinkedLIst.addFirst(11);
        myDoubleLinkedLIst.addIndex(3,11);
        myDoubleLinkedLIst.addLast(11);
        myDoubleLinkedLIst.addIndex(5,11);
        System.out.println(myDoubleLinkedLIst);
        myDoubleLinkedLIst.removeAllKey(11);
        System.out.println(myDoubleLinkedLIst);

        LinkedList<Integer> linkedList = new LinkedList<>();
        //遍历
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);

        for (int x:
             linkedList) {
            System.out.print(x + ",");
        }
        System.out.println();


        ListIterator<Integer> integerListIterator1 = linkedList.listIterator();
        while (integerListIterator1.hasNext()){
            System.out.print(integerListIterator1.next() + ",");
        }
        System.out.println();

        ListIterator<Integer> integerListIterator2 = linkedList.listIterator(linkedList.size());
        while (integerListIterator2.hasPrevious()){
            System.out.print(integerListIterator2.previous() + ",");
        }
        System.out.println();

    }

}
