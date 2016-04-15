package cc.firstTest.servlet;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by cheng on 2016/4/15 0015.
 */
@EnableWebMvc
@Configuration
@ComponentScan(value = "cc.firstTest.servlet.*")
public class WebConfig {
}
