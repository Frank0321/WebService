//
// 此檔案是由 Eclipse Implementation of JAXB, v3.0.0 所產生 
// 請參閱 https://eclipse-ee4j.github.io/jaxb-ri 
// 一旦重新編譯來源綱要, 對此檔案所做的任何修改都將會遺失. 
// 產生時間: 2025.05.03 於 11:52:32 PM CST 
//


package tw.com.yt.ws.webserviceserver.book;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the tw.com.yt.ws.webserviceserver.book package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tw.com.yt.ws.webserviceserver.book
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetBookRequest }
     * 
     */
    public GetBookRequest createGetBookRequest() {
        return new GetBookRequest();
    }

    /**
     * Create an instance of {@link GetBookResponse }
     * 
     */
    public GetBookResponse createGetBookResponse() {
        return new GetBookResponse();
    }

    /**
     * Create an instance of {@link Book }
     * 
     */
    public Book createBook() {
        return new Book();
    }

}
