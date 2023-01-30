package annotations;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class AnnotationsTest {

    //Here we are testing BookService class, (ie : BookService under test)
    @InjectMocks
    BookService bookService;

    @Mock
    BookRepository bookRepository;

    @Test
    public void someTest(){

    }

    @Test
    @DisplayName("Verifying first Book data")
    public void newDiscountPriceTest(){

        Book book1 = new Book("1234","Junit In Action",500, LocalDate.now());
        Book book2 = new Book("1235","Mockito In Action",1000, LocalDate.now());
        Book book3 = new Book("1236","Spring In Action",1000, LocalDate.now());

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        //Stubbing the response
        Mockito.when(bookRepository.findNewBooks(7)).thenReturn(books);

        List<Book> discountAppliedBooks = bookService.getNewBooksWithAppliedDiscount(10,7);

        System.out.println(discountAppliedBooks.size());

        //Validating no of books returned by the bookService.getNewBooksWithAppliedDiscount(10,7);
        Assertions.assertEquals(3,discountAppliedBooks.size());

        //Validating the discounted price for the first book
        Assertions.assertEquals(450,discountAppliedBooks.get(0).getPrice());
        //validating title of the book
        Assertions.assertEquals("Junit In Action",discountAppliedBooks.get(0).getTitle());
    }


    //Test case will not be executed , as we annotated with Disabled
    //eg:we have done changes to the logic , for the updated logic test case yet to write

    @Test
    @Disabled
    public void newTitleChangeTest(){
        Assertions.assertEquals("","");
    }

}
