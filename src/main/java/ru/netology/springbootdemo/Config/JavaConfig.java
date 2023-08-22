package ru.netology.springbootdemo.Config;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.springbootdemo.systemProfile.DevProfile;
import ru.netology.springbootdemo.systemProfile.ProductionProfile;
import ru.netology.springbootdemo.systemProfile.SystemProfile;

@Configuration
public class JavaConfig {

    @Bean
    @ConditionalOnProperty(prefix ="profile",name = "dev",havingValue = "true",matchIfMissing = true)
    public SystemProfile devProfile() {
        return new DevProfile();
    }


    @Bean
    @ConditionalOnProperty(prefix = "profile",name = "dev",havingValue = "false")
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
