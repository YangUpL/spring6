import com.yangRR.config.AopConfig;
import com.yangRR.aop.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class testAopAnnoConfig {


    @Test
    public void testConfig(){
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AopConfig.class);

        Calculator bean = applicationContext.getBean(Calculator.class);
        bean.add(1,1);

    }
}
