package com.zulmaidi.orderservice.config;

import com.zulmaidi.orderservice.client.ProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {
    @Autowired
    private LoadBalancedExchangeFilterFunction filterFunction;
    @Bean
    public WebClient productWebClient(){
        return WebClient.builder()
                .baseUrl("http://product-service")
                .filter(filterFunction)
                .build();
    }

    @Bean
    public ProductClient productClient(){
        HttpServiceProxyFactory httpServiceProxyFactory
                = HttpServiceProxyFactory
                .builder(WebClientAdapter.forClient(productWebClient()))
                .build();
        return httpServiceProxyFactory.createClient(ProductClient.class);
    }
}
