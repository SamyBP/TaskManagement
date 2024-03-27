package ro.app.taskmanagement.configuration;

import lombok.NonNull;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class MvcConfiguration implements WebMvcConfigurer {

    private static final long MAX_AGE = 3600;

    @Override
    public void addCorsMappings(@NonNull CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("${allowed.origins}")
                .allowedMethods("GET", "PUT", "POST", "DELETE", "PATCH")
                .maxAge(MAX_AGE);
    }
}
