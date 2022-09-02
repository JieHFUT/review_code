package review_java_01;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-31
 * Time: 22:42
 */
public class Demo6 {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(10);
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        linkedList.add(50);
        System.out.println(linkedList.toArray());
        System.out.println(linkedList.peekFirst());
        System.out.println(linkedList);

        //遍历
        for (int e:linkedList
             ) {
            System.out.print(e + " ");
        }
        System.out.println();

        ListIterator<Integer> it = linkedList.listIterator();
        while (it.hasNext()){
            System.out.print(it.next() + " ");
        }
        System.out.println();


        ListIterator<Integer> integerListIterator = linkedList.listIterator(linkedList.size());
        while (integerListIterator.hasPrevious()){
            System.out.print(integerListIterator.previous() + " ");
        }
        System.out.println();












    }
}



















