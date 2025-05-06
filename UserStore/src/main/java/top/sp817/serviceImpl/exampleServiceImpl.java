package top.sp817.serviceImpl;

//import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import jakarta.annotation.Resource;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import top.sp817.component.RedisUtil;
import top.sp817.source.userstore.exampleService;
import top.sp817.source.provider.testProvider;

import java.time.LocalDateTime;


@DubboService(retries = 1, timeout = 10 * 1000, weight = 100)
public class exampleServiceImpl implements exampleService {

    @NacosValue(value = "${a}")
    private Integer a;

    @DubboReference
    testProvider t;

    @Resource
    RedisUtil redisUtil;

    @Override
    public String hello() {
        return "example-UserStore: hello :" + StpUtil.getLoginId(-1L);
    }

    @Override
    public String test() {
        return "example-UserStore触发:" + t.providerCallBack() + ":" + a;
//        return "example-UserStore触发:" + StpUtil.getLoginIdAsLong() + ":" + a;
    }


    @Override
    public String login() {
        Long id = 10001L;
        StpUtil.login(id, 30000L);
        return StpUtil.getLoginId() +
                "登录成功："
                + StpUtil.getTokenValue();
    }


    @Override
    public String logout() {
        Long id = 10001L;
        System.out.println(StpUtil.isLogin(id));
        StpUtil.logout(id);
        System.out.println(StpUtil.isLogin(id));
        return "登出成功" + id;
    }


}
