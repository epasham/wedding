package org.debugroom.wedding.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.debugroom.wedding.app.web.filter.MDCFilter;
import org.debugroom.wedding.app.web.helper.AuditLoggingHelper;
import org.debugroom.wedding.app.web.helper.docker.AuditLoggingHelperImpl;
import org.debugroom.wedding.app.web.interceptor.AddUserInfoInterceptor;
import org.debugroom.wedding.app.web.interceptor.FrontendAuditLoggingInterceptor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.accept.MappingMediaTypeFileExtensionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ComponentScan("org.debugroom.wedding.app.web")
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter{
	
	/* Interceptorでインジェクションが行われないため、手動でコンストラクタインジェクションを行う。
	 * See : https://stackoverflow.com/questions/23349180/java-config-for-spring-interceptor-where-interceptor-is-using-autowired-spring-b
	 */
	@Inject
	AuditLoggingHelper auditLoggingHelper;

	@Bean
	public AddUserInfoInterceptor addUserInfoInterceptor(){
		return new AddUserInfoInterceptor();
	}
	
	@Bean
	public FrontendAuditLoggingInterceptor auditLoggingInterceptor(){
		return new FrontendAuditLoggingInterceptor(auditLoggingHelper);
	}

	@Bean
	public FilterRegistrationBean mdcFilter(){
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new MDCFilter());
		filterRegistrationBean.setOrder(0);
		return filterRegistrationBean;
	}
	
	@Bean
	public ViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    	converters.add(new BufferedImageHttpMessageConverter());
        converters.add(byteArrayHttpMessageConverter());
        converters.add(new StringHttpMessageConverter());
        converters.add(new MappingJackson2HttpMessageConverter());
        super.configureMessageConverters(converters);
    }

    @Bean
    public ByteArrayHttpMessageConverter byteArrayHttpMessageConverter() {
        ByteArrayHttpMessageConverter arrayHttpMessageConverter = new ByteArrayHttpMessageConverter();
        arrayHttpMessageConverter.setSupportedMediaTypes(getSupportedMediaTypes());
        return arrayHttpMessageConverter;
    }
     
    private List<MediaType> getSupportedMediaTypes() {
        List<MediaType> list = new ArrayList<MediaType>();
        list.add(MediaType.IMAGE_JPEG);
        list.add(MediaType.IMAGE_PNG);
        list.add(MediaType.APPLICATION_OCTET_STREAM);
        return list;
    }
    
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    	configurer.defaultContentType(MediaType.APPLICATION_JSON);
    	configurer.mediaType("xml", MediaType.APPLICATION_XML);
    	configurer.mediaType("json", MediaType.APPLICATION_JSON);
    	configurer.mediaType("jpeg", MediaType.IMAGE_JPEG);
    	configurer.mediaType("jpg", MediaType.IMAGE_JPEG);
    	configurer.mediaType("png", MediaType.IMAGE_PNG);
    	configurer.mediaType("gif", MediaType.IMAGE_GIF);
    	configurer.mediaType("mpeg", MediaType.APPLICATION_OCTET_STREAM);
    	configurer.mediaType("mp4", MediaType.APPLICATION_OCTET_STREAM);
    	configurer.mediaType("wmv", MediaType.APPLICATION_OCTET_STREAM);
    }

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry){
		registry.addResourceHandler("/static/**", "/webjars/**")
		        .addResourceLocations("classpath:/static/", 
		        		"classpath:/META-INF/resources/webjars/")
		        .resourceChain(false);
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(addUserInfoInterceptor());
		registry.addInterceptor(auditLoggingInterceptor());
	}

	
}
