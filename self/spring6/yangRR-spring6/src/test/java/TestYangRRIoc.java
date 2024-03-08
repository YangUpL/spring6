import com.yangRR.bean.AnnotationApplicationContext;
import com.yangRR.bean.ApplicationContext;
import com.yangRR.service.UserService;
import org.junit.jupiter.api.Test;

public class TestYangRRIoc {

    @Test
    public void testIOC(){
        ApplicationContext context =
                new AnnotationApplicationContext("com.yangRR");

        UserService userService = (UserService)context.getBean(UserService.class);
        System.out.println(userService);
        userService.add();
    }
}


