package pl.camp.it.library;

import org.hibernate.SessionFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.SessionScope;
import pl.camp.it.library.filter.UserFilter;
import pl.camp.it.library.session.SessionObject;

@Configuration
@ComponentScan("pl.camp.it.library")
public class AppConfiguration {

    @Bean
    public SessionFactory sessionFactory() {
        return new org.hibernate.cfg.Configuration()
                .configure().buildSessionFactory();
    }

    @Bean
    @SessionScope
    public SessionObject sessionObject() {
        return new SessionObject();
    }

    /*@Bean
    FilterRegistrationBean<UserFilter> userRoleFilter() {
        FilterRegistrationBean<UserFilter> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new UserFilter());
        registrationBean.addUrlPatterns("/main", "/register");

        return registrationBean;
    }*/
}
