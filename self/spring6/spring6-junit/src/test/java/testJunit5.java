import com.yangRR.spring6.junit5.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


@SpringJUnitConfig(locations = "classpath:bean.xml")
public class testJunit5 {

    @Autowired
    private User user;

    @Test
    public void testUser(){
        System.out.println(user);
    }
}
