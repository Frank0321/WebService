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
	
    private static final String NAMESPACE_BOOK = "http://WebServiceServer.ws.yt.com.tw/book";
    
    private static final String NAMESPACE_MSQUERYSERGROUP = "http://www.richbank.com.tw/";

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/*");
    }
	
    /***
     * book schema
     * 
     * @return
     */
    @Bean
    public XsdSchema bookSchema() {
        return new SimpleXsdSchema(new ClassPathResource("book.xsd"));
    }

    /***
     * book url setting
     * 
     * @param bookSchema
     * @return
     */
    @Bean(name = "book")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema bookSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("BookPort");
        wsdl11Definition.setLocationUri("/bookService");
        wsdl11Definition.setTargetNamespace(NAMESPACE_BOOK);
        wsdl11Definition.setSchema(bookSchema);
        return wsdl11Definition;
    }
    
    /***
     * MsQuerySerGroup schema
     * 
     * @return
     */
    @Bean
    public XsdSchema msQuerySerGroupSchema() {
    	return new SimpleXsdSchema(new ClassPathResource("MsQuerySerGroup.xsd"));
    }
    
    /***
     * msQuerySerGroup url setting
     * 
     * @param msQuerySerGroupSchema
     * @return
     */
    @Bean(name = "msQuerySerGroup")
    public DefaultWsdl11Definition msQuerySerGroupDefaultWsdl11Definition(XsdSchema msQuerySerGroupSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("msQuerySerGroup");
        wsdl11Definition.setLocationUri("/msQuerySerGroup");
        wsdl11Definition.setTargetNamespace(NAMESPACE_MSQUERYSERGROUP);
        wsdl11Definition.setSchema(msQuerySerGroupSchema);
        return wsdl11Definition;
    }
	

}
