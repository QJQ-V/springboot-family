package demo.springboot.mybatis.generator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

// 开启组件扫描和自动配置
@SpringBootApplication
// mapper 接口类扫描包配置
@MapperScan("demo.springboot.mybatis.generator.repository")

public class SpringbootMybatisGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootMybatisGeneratorApplication.class, args);
    }

}
