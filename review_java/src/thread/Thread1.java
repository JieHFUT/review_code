package thread;


/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: JIE
 * Date: 2022-10-17
 * Time: 9:58
 */
public class Thread1 {
    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("this is a thread");
            }
        }, "thread'name");

        System.out.println(thread.getId());
        System.out.println(thread.getName());
    }
}
