package tech.build.run.jbank.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import tech.build.run.jbank.interceptors.InterceptorAudit;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    private final InterceptorAudit interceptorAudit;

    public InterceptorConfig(InterceptorAudit interceptorAudit) {
        this.interceptorAudit = interceptorAudit;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptorAudit)
                .order(0);
    }
}
