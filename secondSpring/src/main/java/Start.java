import com.jieHFUT.controller.FastController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-config.xml");
        FastController controller = context.getBean("fastController", FastController.class);
        controller.sayHello();
    }
}
