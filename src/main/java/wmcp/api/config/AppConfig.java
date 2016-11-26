package wmcp.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * Defines Beans and configurations.
 *
 * @author tlmader.dev@gmail.com
 * @since 2016-11-17
 */
@Configuration
public class AppConfig extends WebMvcConfigurationSupport {

    @Bean
    public HibernateJpaSessionFactoryBean createSessionFactory() {
        return new HibernateJpaSessionFactoryBean();
    }

    @Bean
    public MappingJackson2HttpMessageConverter customJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        HibernateAwareObjectMapper mapper = new HibernateAwareObjectMapper();
        converter.setObjectMapper(mapper);
        return converter;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(customJackson2HttpMessageConverter());
        super.addDefaultHttpMessageConverters(converters);
    }
}
