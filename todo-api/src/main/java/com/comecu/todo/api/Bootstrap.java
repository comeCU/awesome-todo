package com.comecu.todo.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Bootstrap
 *
 * @author comeCU
 * @date 2022/3/23 20:42
 */
@SpringBootApplication()
// @MapperScan("com.comecu.todo.core")
@EnableJpaRepositories("com.comecu.todo.core")
@EntityScan("com.comecu.todo.core.domain")
@ComponentScan("com.comecu.todo")
public class Bootstrap {
    public static void main(String[] args) {
        SpringApplication.run(Bootstrap.class, args);
    }
}
