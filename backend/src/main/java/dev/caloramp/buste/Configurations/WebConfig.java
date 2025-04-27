package dev.caloramp.buste.Configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Reindirizza tutte le richieste non API al file index.html
        registry.addViewController("/{spring:[^\\.]*}")
                .setViewName("forward:/index.html");
    }
}