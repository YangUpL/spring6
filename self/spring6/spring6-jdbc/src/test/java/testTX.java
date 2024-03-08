import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

@SpringJUnitConfig(locations = "classpath:beans.xml")
@Transactional
public class testTX {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void test1(){
        String sql = "insert into t_emp values(null,?,?,?)";
        int result = jdbcTemplate.update(sql, "yang", 25, "男");
        System.out.println(result);

        int a = 1 / 0;

        String sql1 = "update t_emp set name=? where id=?";
        int result1 = jdbcTemplate.update(sql, "张三yangRR", 1);
    }
}
