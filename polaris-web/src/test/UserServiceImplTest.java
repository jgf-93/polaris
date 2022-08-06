import com.alibaba.fastjson.JSON;
import com.polaris.Application;
import com.polaris.common.entity.User;
import com.polaris.common.mapper.UserMapper;
import com.polaris.common.redis.RedisHashServiceImpl;
import com.polaris.common.redis.RedisValueServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 类上面的两个注解不能缺少
 *
 * @RunWith(SpringRunner.class)
 * @SpringBootTest(classes = 启动类（引导类）.class)
 * 当此测试类所在的包与启动类所在的包：在同一级包下或是启动类所在包的子包
 * 测试方法的注解不能缺少
 * @Test 直接注入UserService对象就能够实现测试接口的调用，记得加@Autowired。
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserServiceImplTest {

    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisValueServiceImpl redisValueService;
    @Resource
    private RedisHashServiceImpl redisHashService;

    @Test
    public void addUser() {
        User user = new User();
        user.setUserName("1186967953@qq.com");
        user.setPassword("123456");
        user.setMobile("15757857623");
        user.setPhoto("/user/test.jpg");
        user.setQq("1186967953");
        user.setLoginTime(new Date());
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userMapper.insert(user);
        System.out.println("插入用户结束");
    }

    @Test
    public void reditTest() {
        User user = new User();
        user.setUserName("1186967953@qq.com");
        user.setPassword("123456");
        user.setMobile("15757857623");
        user.setPhoto("/user/test.jpg");
        user.setQq("1186967953");
        user.setLoginTime(new Date());
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        redisValueService.set("jgf", user);
        User redisUser = (User) redisValueService.get("jgf");
        System.out.println("获取到valueops:" + JSON.toJSONString(redisUser));

        redisHashService.hSet("hash","userName","张健");
        redisHashService.hSet("hash","tel","15757857623");
        String value= (String) redisHashService.hGet("hash","userName");
        System.out.println("获取到hashops:" + JSON.toJSONString(value));

    }
}