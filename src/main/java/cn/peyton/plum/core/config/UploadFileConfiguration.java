package cn.peyton.plum.core.config;

import jakarta.servlet.MultipartConfigElement;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.unit.DataSize;

/**
 * <h4>图片上传配置类</h4>
 * <pre>
 * @author <a href="http://www.peyton.cn">peyton</a>
 * @mail <a href="mailto:fz2919@tom.com">fz2919@tom.com</a>
 * @name cn.peyton.plum.core.config.
 * @date 2023年11月20日 17:24
 * @version 1.0.0
 * </pre>
 */
@Configuration
public class UploadFileConfiguration {

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //允许上传文件最大值
        factory.setMaxFileSize(DataSize.parse("3MB"));
        //  设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.parse("-1"));
        return factory.createMultipartConfig();
    }

}
