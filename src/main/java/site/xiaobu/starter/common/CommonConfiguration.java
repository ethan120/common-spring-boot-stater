package site.xiaobu.starter.common;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Import;
import site.xiaobu.starter.common.exception.config.ExceptionConfig;

@SpringBootConfiguration
@Import(ExceptionConfig.class)
public class CommonConfiguration {
}
