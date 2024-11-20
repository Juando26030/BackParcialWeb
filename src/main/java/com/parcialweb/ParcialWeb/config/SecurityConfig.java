package com.parcialweb.ParcialWeb.config;

import io.micrometer.common.lang.NonNull;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Aplica a todas las rutas
                .allowedOrigins("http://localhost:4200") // Permite el origen específico
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                .allowedHeaders("*") // Permite todos los encabezados
                .allowCredentials(true); // Permite enviar cookies si es necesario
    }
}