package exceptions;

import java.sql.SQLException;
import java.util.List;

public interface BookRepository {
	List<Book> findAllBooks() throws SQLException;

}
