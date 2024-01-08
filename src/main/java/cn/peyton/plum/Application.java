package cn.peyton.plum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        System.out.println("================= >>>>>初始化数据>>>>> ================" + System.currentTimeMillis());
        //System.out.println(HttpServletRequestUtils.getSiteRootPath());
        SpringApplication.run(Application.class, args);
    }

}
