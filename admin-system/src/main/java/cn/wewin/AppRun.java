package cn.wewin;

import cn.wewin.backend.modules.system.repository.MyRepositoryImpl;
import cn.wewin.common.utils.SpringContextHolder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;

/**
 * @author jie
 * @date 2018/11/15 9:20:19
 */
@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(
        repositoryBaseClass = MyRepositoryImpl.class)
@EnableWebSocketMessageBroker
public class AppRun {

    public static void main(String[] args) {
        SpringApplication.run(AppRun.class, args);
    }

    @Bean
    public SpringContextHolder springContextHolder() {
        return new SpringContextHolder();
    }
}
