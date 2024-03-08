import com.yangRR.testDL.Calculator;
import com.yangRR.testDL.CalculatorImpl;
import com.yangRR.testDL.ProxyFactory;
import org.junit.jupiter.api.Test;

public class testDL {


    @Test
    public void testDLL(){
        Calculator proxy = (Calculator)new ProxyFactory(new CalculatorImpl()).getProxy();
        proxy.add(2, 4);
    }
}
