/**
 * @Description : init Data
 * @ClassName : InitDataService.java
 * @Copyright : Copyright (c) 2025 
 * @ModifyHistory : 
 *  v1.00, 2025/05/03, frankchang
 *   1) First Release.
 */

package tw.com.yt.ws.WebServiceServer;

import java.util.HashMap;
import java.util.Map;

import jakarta.annotation.PostConstruct;
import tw.com.yt.ws.WebServiceServer.book.Book;

public class InitDataService {
	
	private static final Map<String, Book> books = new HashMap<>();
	
	/***
	 * 找尋一筆資料
	 */
	@PostConstruct
	void initData() {
		
        Book harryPotterI = new Book();
        harryPotterI.setIsbn("9573317249");
        harryPotterI.setName("哈利波特：神秘的魔法石");;
        harryPotterI.setAuthor("J. K. 羅琳");
        harryPotterI.setPublishing("1997");
        harryPotterI.setEdition(1);

        books.put(harryPotterI.getIsbn(), harryPotterI);

        Book iceAndFireI = new Book();
        iceAndFireI.setIsbn("9789861856216");
        iceAndFireI.setName("冰與火之歌：權力遊戲");;
        iceAndFireI.setAuthor("喬治馬汀");
        iceAndFireI.setPublishing("2011");
        iceAndFireI.setEdition(1);

        books.put(iceAndFireI.getIsbn(), iceAndFireI);

        Book lordOfRingsI = new Book();
        lordOfRingsI.setIsbn("9789570841008");
        lordOfRingsI.setName("魔戒首部曲：魔戒現身");;
        lordOfRingsI.setAuthor("托爾金");
        lordOfRingsI.setPublishing("2001");
        lordOfRingsI.setEdition(1);

        books.put(lordOfRingsI.getIsbn(), lordOfRingsI);
		
	}
	
	/***
	 * 使用 isbn 找出一筆資料
	 * 
	 * @param isbn
	 * @return
	 */
	public Book findBookByIsbn(String isbn) {
		
		return books.get(isbn);
		
	}

}
