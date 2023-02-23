import com.jieHFUT.component.FastComponent;
import com.jieHFUT.config.FastConfiguration;
import com.jieHFUT.controller.DogController;
import com.jieHFUT.controller.DogController2;
import com.jieHFUT.controller.FastController;
import com.jieHFUT.model.User;
import com.jieHFUT.repository.FastRepository;
import com.jieHFUT.serive.FastSerive;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {
    public static void main(String[] args) {

        ApplicationContext context1 =
                new ClassPathXmlApplicationContext("spring-config.xml");
        FastController controller = context1.getBean("fastController", FastController.class);
        controller.sayController();



        ApplicationContext context2 =
                new ClassPathXmlApplicationContext("spring-config.xml");
        FastSerive serive = context2.getBean("fastSerive", FastSerive.class);
        serive.saySerive();


        ApplicationContext context3 =
                new ClassPathXmlApplicationContext("spring-config.xml");
        FastRepository repository = context3.getBean("fastRepository", FastRepository.class);
        repository.sayRepository();


        ApplicationContext context4 =
                new ClassPathXmlApplicationContext("spring-config.xml");
        FastComponent component = context4.getBean("fastComponent", FastComponent.class);
        component.sayComponent();


        ApplicationContext context5 =
                new ClassPathXmlApplicationContext("spring-config.xml");
        FastConfiguration configuration = context5.getBean("fastConfiguration", FastConfiguration.class);
        configuration.sayConfiguration();


        ApplicationContext context6 =
                new ClassPathXmlApplicationContext("spring-config.xml");
        User user = context6.getBean("firstUser", User.class);
        System.out.println(user.getName());


        ApplicationContext context7 =
                new ClassPathXmlApplicationContext("spring-config.xml");
        DogController dogController = context7.getBean("dogController", DogController.class);
        dogController.doDisplay();



        ApplicationContext context8 =
                new ClassPathXmlApplicationContext("spring-config.xml");
        DogController2 dogController2 = context8.getBean("dogController2", DogController2.class);
        dogController2.doDisplay();




    }
}











