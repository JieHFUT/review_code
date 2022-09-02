package review_java_01;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-30
 * Time: 22:55
 */
public class Demo5 {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(10);
        integerList.add(1,20);
        System.out.println(integerList.get(1));
        System.out.println(integerList.size());
        System.out.println(integerList.contains(11));

        System.out.println(integerList);
    }
}
