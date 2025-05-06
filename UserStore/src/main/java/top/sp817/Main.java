package top.sp817;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import top.sp817.Utils.PortUtil;

import java.io.File;


@SpringBootApplication
@EnableDubbo
@NacosPropertySource(dataId = "${nacos.config.data-id}", autoRefreshed = true)
public class Main {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Main.class);
        // 添加自定义的ApplicationContextInitializer
        application.addInitializers(context -> {
            // 获取Environment对象
            Environment env = context.getEnvironment();
            // 从Environment中读取属性值
            String appName = env.getProperty("spring.application.name");
//            String port = String.valueOf(PortUtil.getLocalPort());
            String port = "9090";
            String filePath = System.getProperty("user.home") + File.separator + ".dubbo" +File.separator + appName + port;
            // 修改dubbo的本地缓存路径，避免缓存冲突
            System.setProperty("dubbo.meta.cache.filePath", filePath);
            System.setProperty("dubbo.mapping.cache.filePath",filePath);
            System.setProperty("dubbo.protocol.port", port);
            System.out.println("使用端口:" + port);
        });
        application.run(args);
    }
}