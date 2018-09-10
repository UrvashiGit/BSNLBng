package com.sterlite.bsnl;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.sterlite.bsnl.interceptor.LoginInterceptor;


@SuppressWarnings("deprecation")
@Configuration
@ComponentScan("com.sterlite.bsnl.*")
public class ConfigApplication extends WebMvcConfigurerAdapter{
	
	@Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**")
        .excludePathPatterns("/image/**","/css/**","/vendor/**","/js/**");
    }
	
	/*@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
	configurer
	.defaultContentType(MediaType.APPLICATION_JSON)
	.ignoreAcceptHeader(true);
	}
	
	@Override
	 public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/jsp/", ".jsp").viewClass(JstlView.class);
		registry.enableContentNegotiation(
				new ExcelViewReport());
			//	new XlsxView(),
			//	new PdfView());
	}
	
	
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/image/**").addResourceLocations("image/");
		registry.addResourceHandler("/css/**").addResourceLocations("css/");
		registry.addResourceHandler("/vendor/**").addResourceLocations("vendor/");
		registry.addResourceHandler("/js/**").addResourceLocations("js/");
	}*/

	/*@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
	registry.enableContentNegotiation(
	new ExcelViewReport()
	);
	}*/
}
