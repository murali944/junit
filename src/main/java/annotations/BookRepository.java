package annotations;

import java.util.List;

public interface BookRepository {
	List<Book> findNewBooks(int days);
	List<Book> getAllBooks();
}
