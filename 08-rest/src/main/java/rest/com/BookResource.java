package rest.com;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {
    private static List<Book> books = new ArrayList<>();
    private static AtomicInteger idCounter = new AtomicInteger();

    public static void initBooks() {
        // Initialize the book list with some sample books
        addBook(new Book("1984", "George Orwell", "Dystopian novel"));
        addBook(new Book("Brave New World", "Aldous Huxley", "Science fiction and dystopian novel"));
    }

    @GET
    public List<Book> getBooks() {
        return books;
    }

    @POST
    public static Book addBook(Book book) {
        book.setId(idCounter.incrementAndGet());
        books.add(book);
        return book;
    }

    @GET
    @Path("/{id}")
    public Book getBook(@PathParam("id") int id) {
        return books.stream()
                    .filter(book -> book.getId() == id)
                    .findFirst()
                    .orElseThrow(NotFoundException::new);
    }

    @PUT
    @Path("/{id}")
    public Book updateBook(@PathParam("id") int id, Book book) {
        for (Book b : books) {
            if (b.getId() == id) {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
                b.setDescription(book.getDescription());
                return b;
            }
        }
        throw new NotFoundException();
    }

    @DELETE
    @Path("/{id}")
    public void deleteBook(@PathParam("id") int id) {
        books.removeIf(b -> b.getId() == id);
    }
}
