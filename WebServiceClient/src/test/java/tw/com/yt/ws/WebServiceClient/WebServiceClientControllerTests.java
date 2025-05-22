package tw.com.yt.ws.WebServiceClient;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.MediaType;
import tw.com.yt.ws.WebServiceClient.book.GetBookResponse;
import tw.com.yt.ws.WebServiceClient.controller.WebServiceClientController;
import tw.com.yt.ws.WebServiceClient.service.BookClient;

@WebMvcTest(WebServiceClientController.class)
public class WebServiceClientControllerTests {

	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookClient bookClient;

    @Test
    public void testGetBook() throws Exception {
        // 模擬回應對象
        GetBookResponse mockResponse = new GetBookResponse();
        // 可依需要模擬更多屬性

        // 模擬服務呼叫
        when(bookClient.getBook(anyString())).thenReturn(mockResponse);

        String xmlContent = "9789861856216";

        mockMvc.perform(MockMvcRequestBuilders.post("/getBook")
                .contentType(MediaType.TEXT_XML)
                .content(xmlContent))
                .andExpect(status().isOk());
    }

    // 測試用的內部類 BookRequest
    static class BookRequest {
        private String isbn;

        public BookRequest(String isbn) {
            this.isbn = isbn;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }
    }
}
