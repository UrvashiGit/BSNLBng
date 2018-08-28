package com.sterlite.bsnl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;

import com.sterlite.bsnl.interceptor.LoginInterceptor;
import com.sterlite.bsnl.utill.reportbuilder.ExcelViewReport;


@SuppressWarnings("deprecation")
@Configuration

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
