package review_java_01;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-08-29
 * Time: 18:44
 */
public class Demo1 {

    public static void func(Demo4<? extends Object> demo4){
        System.out.println(demo4.getMessage());
     }

    public static void main(String[] args) {
        Demo3<Integer> integerDemo3 = new Demo3<>();

        integerDemo3.setVal(0,10);
        integerDemo3.setVal(1,20);

        System.out.println(integerDemo3.getPos(1));
        System.out.println("=============================");

        Demo4<Integer> integerDemo4 = new Demo4<>();
        integerDemo4.setMessage(99);
        func(integerDemo4);

        Demo4<String> stringDemo4 = new Demo4<>();
        stringDemo4.setMessage("好好学习!");
        func(stringDemo4);
    }
}
