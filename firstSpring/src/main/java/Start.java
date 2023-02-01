import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import springTest.User;

public class Start {
    public static void main(String[] args) {
        // 后续的实现
        // 1、得到spring的上下文对象
        ApplicationContext  context =
                new ClassPathXmlApplicationContext("spring-config.xml");
        // BeanFactory beanFactory =
        //         new XmlBeanFactory(new ClassPathResource("spring-config.xml"));

        // 2、从spring上下文中取出Bean对象
        User user = (User) context.getBean("user");
        // User user = context.getBean("User.class")
        // User user = context.getBean("user", User.class);

        // 3、使用Bean对象
        user.sayHi();
    }
}
