package top.sp817.serviceImpl;

import cn.dev33.satoken.stp.StpUtil;
import org.apache.dubbo.config.annotation.DubboService;
import top.sp817.source.provider.testProvider;


@DubboService(retries = 1, timeout = 10 * 1000, weight = 100)
public class testProviderImpl implements testProvider {

    @Override
    public String hello() {
        return "testProvider: hello";
    }

    @Override
    public String providerCallBack(){
        return "testProvider服务被调用" + StpUtil.getLoginId(-1L);
    }

}