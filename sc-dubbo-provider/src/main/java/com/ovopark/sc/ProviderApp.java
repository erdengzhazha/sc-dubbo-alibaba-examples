package com.ovopark.sc;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/*** * http://www.qiusunzuo.com/
 *                     .::::. *       FUCK YOU     
 *                  .::::::::.  @Description Provider启动类
 *                 :::::::::::  @Auther Xiu_Er 13813641925@163.com
 *             ..:::::::::::'   @Date 2021/6/8 11:13 上午
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
public class ProviderApp {

  public static void main(String[] args) {

    new SpringApplicationBuilder(ProviderApp.class)
      .properties("spring.profiles.active=nacos").run(args); //选择nacos为注册中心
  }
}
