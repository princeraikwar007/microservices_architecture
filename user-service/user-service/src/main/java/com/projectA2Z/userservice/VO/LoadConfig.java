package com.projectA2Z.userservice.VO;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.DummyPing;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan
public class LoadConfig {


    IClientConfig config;

    @Bean
    public IClientConfig getConfig() {
        return config;
    }

    @Bean
    public IPing ribbonPing(IClientConfig config) {
        return new DummyPing();
    }

    @Bean
    public IRule ribbonRule(IClientConfig config) {
        return new AvailabilityFilteringRule();
    }
}