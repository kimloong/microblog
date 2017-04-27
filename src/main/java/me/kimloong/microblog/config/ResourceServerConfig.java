package me.kimloong.microblog.config;

import org.springframework.boot.autoconfigure.security.oauth2.OAuth2ClientProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

/**
 * Created by KimLoong on 17-4-24.
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "microblog_resource";

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.antMatcher("/**")
                .authorizeRequests()
                .anyRequest().access("#oauth2.hasScope('read')");
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(RESOURCE_ID);
    }

    @Primary
    @Bean
    public RemoteTokenServices tokenService(
            ResourceServerProperties resourceServerProperties,
            OAuth2ClientProperties auth2ClientProperties) {
        //这里目前没有找到更优雅的解决方式，所以先拼接两个地方配置的方式解决
        //或者直接使用@ConfigurationProperties
        RemoteTokenServices tokenService = new RemoteTokenServices();
        tokenService.setCheckTokenEndpointUrl(resourceServerProperties.getTokenInfoUri());
        //这里必须要有clientId及clientSecret且该client需要注册在AuthorizationServer中
        tokenService.setClientId(resourceServerProperties.getClientId());
        tokenService.setClientSecret(auth2ClientProperties.getClientSecret());
        return tokenService;
    }
}
