package com.polaris;

import com.alibaba.fastjson.JSON;
import com.polaris.client.UserDubboService;
import com.polaris.client.dto.UserDto;
import com.polaris.common.entity.User;
import com.polaris.common.mapper.UserMapper;
import com.polaris.common.redis.RedisService;
import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 类上面的两个注解不x能缺少
 *
 * @RunWith(SpringRunner.class)
 * @SpringBootTest(classes = 启动类（引导类）.class)
 * 当此测试类所在的包与启动类所在的包：在同一级包下或是启动类所在包的子包
 * 测试方法的注解不能缺少
 * @Test 直接注入UserService对象就能够实现测试接口的调用，记得加@Autowired。
 */
public class DubboTest extends com.polaris.Test {

    @Resource
    private UserMapper userMapper;
    @Resource
    private RedisService redisService;
    @Reference
    private UserDubboService userDubboService;

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
    public void dubboTest() {
        UserDto userDto = userDubboService.getUser();
        System.out.println(JSON.toJSONString(userDto));
    }
}