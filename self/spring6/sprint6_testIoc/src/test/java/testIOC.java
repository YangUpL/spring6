import com.yangRR.config.Spring6Config;
import com.yangRR.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class testIOC {


    @Test
    public void testIoc(){
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Spring6Config.class);

        UserController userController = context.getBean("userController",UserController.class);

        userController.add();
    }
}
