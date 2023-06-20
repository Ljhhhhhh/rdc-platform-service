package rdc.platform.java.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * MyBatis配置类
 */
@Configuration
@MapperScan("rdc.platform.java.mbg.mapper")
public class MyBatisConfig {
}
