package top.sp817.handle;

import cn.dev33.satoken.stp.StpUtil;
import org.apache.dubbo.rpc.*;

public class TokenFilter implements Filter {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        String keyName = "satoken";
        System.out.println(invocation.getAttachments());
        String token = invocation.getAttachments().get(keyName);
        StpUtil.setTokenValue(token);
        Result result= invoker.invoke(invocation);
        Result appResponse = ((AsyncRpcResult) result).getAppResponse();
        return result;
    }
}