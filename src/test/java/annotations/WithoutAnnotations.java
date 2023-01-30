package annotations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//Using Mockito without Annotation's Approach
public class WithoutAnnotations {

    @Test
    @DisplayName("Verifying first Book data")
    public void newDiscountPriceTest(){

        //Mocking the repository
        BookRepository bookRepository = Mockito.mock(BookRepository.class);

        BookService bookService = new BookService(bookRepository);

        Book book1 = new Book("1234","Junit In Action",500, LocalDate.now());
        Book book2 = new Book("1235","Mockito In Action",1000, LocalDate.now());

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);


        Mockito.when(bookRepository.findNewBooks(7)).thenReturn(books);

        List<Book> discountAppliedBooks = bookService.getNewBooksWithAppliedDiscount(10,7);

        //Validating no of books returned by the bookService.getNewBooksWithAppliedDiscount(10,7);
        Assertions.assertEquals(2,discountAppliedBooks.size());

        //Validating the discounted price for the first book
        Assertions.assertEquals(450,discountAppliedBooks.get(0).getPrice());

        //validating title of the book
        Assertions.assertEquals("Junit In Action",discountAppliedBooks.get(0).getTitle());

    }


}
