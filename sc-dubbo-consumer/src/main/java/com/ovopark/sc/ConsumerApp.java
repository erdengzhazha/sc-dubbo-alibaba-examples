package com.ovopark.sc;

import com.alibaba.cloud.dubbo.annotation.DubboTransported;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

/*** * http://www.qiusunzuo.com/
 *                     .::::. *       FUCK YOU     
 *                  .::::::::.  @Description 消费者启动项
 *                 :::::::::::  @Auther Xiu_Er 13813641925@163.com
 *             ..:::::::::::'   @Date 2021/6/8 11:39 上午
 *           '::::::::::::'     @Version 1.0.0    
 *             .::::::::::
 *        '::::::::::::::..
 *             ..::::::::::::.
 *           ``::::::::::::::::
 *            ::::``:::::::::'        .:::.
 *           ::::'   ':::::'       .::::::::.
 *         .::::'      ::::     .:::::::'::::.
 *        .:::'       :::::  .:::::::::' ':::::.
 *       .::'        :::::.:::::::::'      ':::::.
 *      .::'         ::::::::::::::'         ``::::.
 *  ...:::           ::::::::::::'              ``::.
 * ```` ':.          ':::::::::'                  ::::..
 *                    '.:::::'                    ':'````..
 */
@EnableDiscoveryClient
@EnableAutoConfiguration
@EnableFeignClients
@EnableScheduling
@EnableCaching
public class ConsumerApp {


//  @Value("${provider.application.name}")
//  private String providerApplicationName;

  @Autowired
  @LoadBalanced
  private RestTemplate restTemplate;

  @Bean
  @LoadBalanced
  @DubboTransported
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }


  public static void main(String[] args) {
    new SpringApplicationBuilder(ConsumerApp.class)
      .properties("spring.profiles.active=nacos").run(args); //选择nacos为注册中心
  }
}
