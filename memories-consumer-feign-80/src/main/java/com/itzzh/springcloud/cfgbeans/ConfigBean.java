package com.itzzh.springcloud.cfgbeans;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced  //开启Ribbon
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

	@Bean   //负载均衡的策略，如果自定义了要记得注销掉，防止冲突
	public IRule getRandomRule() {
		return new RandomRule();
	}
}
