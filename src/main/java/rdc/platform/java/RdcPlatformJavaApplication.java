package rdc.platform.java;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("rdc.platform.java.dao")
@SpringBootApplication
public class RdcPlatformJavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(RdcPlatformJavaApplication.class, args);
    }

}
