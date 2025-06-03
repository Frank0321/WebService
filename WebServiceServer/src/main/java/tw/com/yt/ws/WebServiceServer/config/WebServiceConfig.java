/**
 * @Description : TODO
 * @ClassName : WebServiceConfig.java
 * @Copyright : Copyright (c) 2025 
 * @ModifyHistory : 
 *  v1.00, 2025/05/04, frankchang
 *   1) First Release.
 */

package tw.com.yt.ws.WebServiceServer.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig {
	
    private static final String NAMESPACE_URI = "http://WebServiceServer.ws.yt.com.tw/book";
    
    private static final String NAMESPACE_URI2 = "http://www.richbank.com.tw/";

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/*");
    }
		
    @Bean
    public XsdSchema bookSchema() {
        return new SimpleXsdSchema(new ClassPathResource("book.xsd"));
    }

    @Bean(name = "book")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema bookSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("BookPort");
        wsdl11Definition.setLocationUri("/bookService");
        wsdl11Definition.setTargetNamespace(NAMESPACE_URI);
        wsdl11Definition.setSchema(bookSchema);
        return wsdl11Definition;
    }
    
    @Bean
    public XsdSchema msGroupSchema() {
    	return new SimpleXsdSchema(new ClassPathResource("MsQuerySerGroup.xsd"));
    }
    
    @Bean(name = "msQuerySerGroup")
    public DefaultWsdl11Definition defaultWsdl11DefinitionMsQuerySerGroup(XsdSchema msGroupSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("msQuerySerGroup");
        wsdl11Definition.setLocationUri("/msQuerySerGroup");
        wsdl11Definition.setTargetNamespace(NAMESPACE_URI2);
        wsdl11Definition.setSchema(msGroupSchema);
        return wsdl11Definition;
    }
	

}
