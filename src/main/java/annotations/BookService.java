package annotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BookService {



	BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	//method to apply discounts on the books which are published on last 7 days

	public List<Book> getNewBooksWithAppliedDiscount(int discountRate, int days){
		//First fetch all the books published on last 7 days
		List<Book> newBooks = bookRepository.findNewBooks(days);

		// 500 apply 10% -> 10% of 500 -> 50 -> 500 - 50 -> 450
		for(Book book : newBooks){
			int price = book.getPrice();
			int newPrice = price - (discountRate * price / 100);
			book.setPrice(newPrice);
		}
		return newBooks;
	}



	public List<Book> fetchAllBooks(){

		// we are just creating and returning local data , Not engaged with any Data base.
		Book book1 = new Book("1234", "Mockito In Action", 500, LocalDate.now());
		Book book2 = new Book("1235", "JUnit 5 In Action", 400, LocalDate.now());

		List<Book> newBooks = new ArrayList<>();
		newBooks.add(book1);
		newBooks.add(book2);
		return bookRepository.getAllBooks();
	}
}
