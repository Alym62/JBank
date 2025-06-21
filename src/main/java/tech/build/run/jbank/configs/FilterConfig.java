package tech.build.run.jbank.configs;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.build.run.jbank.filters.FilterIp;

@Configuration
public class FilterConfig {
    private final FilterIp filterIp;

    public FilterConfig(FilterIp filterIp) {
        this.filterIp = filterIp;
    }

    @Bean
    public FilterRegistrationBean<FilterIp> filterIpFilterRegistrationBean() {
        var registrationBean = new FilterRegistrationBean<FilterIp>();
        registrationBean.setFilter(filterIp);
        registrationBean.setOrder(0);

        return registrationBean;
    }
}
