package top.sp817.config;

import cn.dev33.satoken.reactor.filter.SaReactorFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.sp817.source.provider.testProvider;

/**
 * [Sa-Token 权限认证] 配置类
 * @author click33
 */
@Configuration
public class SaTokenConfigure {
    // 注册 Sa-Token全局过滤器

    @DubboReference
    testProvider provider;


    @Bean
    public SaReactorFilter getSaReactorFilter() {

        return new SaReactorFilter()
                .addInclude("/**")
                .setAuth(obj -> {
                    // 模拟不需要登录的接口
                    System.out.println(StpUtil.getLoginId(-1L));
                    SaRouter.match("/UserStore/demo/hello/**").stop();
                    SaRouter.match("/UserStore/demo/login/**").stop();
                    SaRouter.match("/UserStore/demo/logout/**").stop();
                    // 模拟需要认证的接口
                    SaRouter.match("/UserStore/demo/test/**")
                            .check(r -> StpUtil.checkPermission("test"))
                            .stop();
                    // 不存在的路由
                    SaRouter.match("/**").check(r -> StpUtil.checkPermission("*"));
                })
                .setError(e -> SaResult.error(e.getMessage()));

    }

}
