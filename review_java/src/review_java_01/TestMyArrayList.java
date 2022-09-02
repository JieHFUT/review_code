package review_java_01;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-31
 * Time: 22:24
 */
public class TestMyArrayList {
    public static void main(String[] args) {
        MyArrayList<Integer> integerMyArrayList = new MyArrayList<>();
        integerMyArrayList.add(1);
        integerMyArrayList.add(2);
        integerMyArrayList.add(3);
        integerMyArrayList.add(4);
        integerMyArrayList.add(5);
        integerMyArrayList.add(6);
        System.out.println(integerMyArrayList.toString());


        System.out.println(integerMyArrayList.isEmpty());
        System.out.println(integerMyArrayList.size());

        integerMyArrayList.add(0,99);
        System.out.println(integerMyArrayList.toString());
        System.out.println("=====================");


        integerMyArrayList.remove(99);
        System.out.println(integerMyArrayList.toString());
    }
}
