package cc.vihackerframework.core.doc.configure;

import cc.vihackerframework.core.factory.YamlPropertySourceFactory;
import cc.vihackerframework.core.doc.properties.ViHackerDocProperties;
import cn.hutool.core.util.RandomUtil;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.OAuthFlows;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springdoc.core.customizers.GlobalOpenApiCustomizer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import springfox.documentation.annotations.ApiIgnore;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *
 * @author Ranger
 * @email wilton.icp@gmail.com
 * @since 2021/6/4
 */
@Configuration
@EnableKnife4j
@EnableConfigurationProperties(ViHackerDocProperties.class)
@PropertySource(factory = YamlPropertySourceFactory.class, value = "classpath:vihacker-doc.yml")
@ConditionalOnProperty(value = ViHackerDocProperties.PREFIX + ".enable", havingValue = "true", matchIfMissing = true)
public class ViHackerDocAutoConfigure {

    private final ViHackerDocProperties properties;

    public ViHackerDocAutoConfigure(ViHackerDocProperties properties) {
        this.properties = properties;
    }

    /**
     * Swagger忽略的参数类型
     */
    private final Class[] ignoredParameterTypes = new Class[]{
            ServletRequest.class,
            ServletResponse.class,
            HttpServletRequest.class,
            HttpServletResponse.class,
            HttpSession.class,
            ApiIgnore.class,
            Principal.class,
            Map.class
    };

    /**
     * 根据@Tag 上的排序，写入x-order
     *
     * @return the global open api customizer
     */
    @Bean
    public GlobalOpenApiCustomizer orderGlobalOpenApiCustomizer() {
        return openApi -> {
            if (openApi.getTags() != null) {
                openApi.getTags().forEach(tag -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("x-order", RandomUtil.randomInt(0, 100));
                    tag.setExtensions(map);
                });
            }
            if (openApi.getPaths() != null) {
                openApi.addExtension("x-test123", "333");
                openApi.getPaths().addExtension("x-abb", RandomUtil.randomInt(1, 100));
            }
            openApi.setInfo(apiInfo());
            openApi.schemaRequirement("111",securityScheme());
        };
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(apiInfo())
                .schemaRequirement("111",securityScheme());
    }

    private SecurityScheme securityScheme(){
        SecurityScheme securityScheme = new SecurityScheme();
        securityScheme.setType(SecurityScheme.Type.APIKEY);
        securityScheme.description("securityScheme描述");
        securityScheme.setName("Authorization");
        securityScheme.in(SecurityScheme.In.HEADER);
        securityScheme.scheme("1111");
        securityScheme.setBearerFormat("Bearer");
//        securityScheme.flows(new OAuthFlows());
        securityScheme.setOpenIdConnectUrl(properties.getPasswordTokenUrl());

        return securityScheme;
    }

    private List<SecurityRequirement> securityRequirement(){
        List<SecurityRequirement> securityRequirement = new ArrayList<>();

        return securityRequirement;
    }

    public Info apiInfo(){
        String description = String.format("<div style='font-size:%spx;color:%s;'>%s</div>",
                properties.getDescriptionFontSize(), properties.getDescriptionColor(), properties.getDescription());
        Contact contact = new Contact().name(properties.getName()).url(properties.getUrl()).email(properties.getEmail());

        License license = new License().name(properties.getLicense())
                .url(properties.getLicenseUrl());

        return new Info()
                .title(properties.getTitle())
                .version(properties.getVersion())
                .contact(contact)
                .description(description)
                .termsOfService(properties.getServiceUrl())
                .license(license);
    }
}
