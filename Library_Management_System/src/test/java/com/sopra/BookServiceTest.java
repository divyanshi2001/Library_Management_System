package com.sopra;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;



import java.util.ArrayList;
import java.util.Iterator;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;



import com.sopra.repo.BookRepository;

//test class
@SpringBootTest
public class BookServiceTest {
    
    
    ArrayList<Book> libraries=null;
    ArrayList<Book> library=null;
    
    @Mock
    private BookRepository libRepo;
    
    @InjectMocks
    private BookService helloService = new BookService();
    
    
    
    
    
    @BeforeEach
    void setMockOutput() {
        libraries = new ArrayList<Book>();
        libraries.add(new Book(1,"Merchant","Ankit",250,"available","two"));
        libraries.add(new Book(2,"Merchant of","Ankit j",300,"available","five"));
        when(helloService.findAll()).thenReturn(libraries);
    }



   
    @DisplayName("FindAll test")
    @Test
    void testfindAll() {
    	
    	 library = new ArrayList<Book>();
         library.add(new Book(1,"Merchant","Ankit",250,"available","two"));
         library.add(new Book(2,"Merchant of","Ankit j",300,"available","five"));
        
        
        Iterator<Book> it1 = library.iterator();
        Iterator<Book> it2 = helloService.findAll().iterator();
        while (it1.hasNext() && it2.hasNext()) {
            assertEquals(it1.next().getId(), it2.next().getId());
            
        }
    }
}
