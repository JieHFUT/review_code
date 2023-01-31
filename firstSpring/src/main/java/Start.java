import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springTest.User;

public class Start {
    public static void main(String[] args) {
        // 后续的实现
        // 1、得到spring的上下文对象
        ApplicationContext  context =
                new ClassPathXmlApplicationContext("spring-config.xml");
        // 2、从spring上下文中取出Bean对象
        User user = (User) context.getBean("user");
        // 3、使用Bean对象
        user.sayHi();
    }
}
