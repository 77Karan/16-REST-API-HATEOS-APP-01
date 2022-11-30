package in.ashokit.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import in.ashokit.binding.Book;

@RestController
public class BookController 
{
	@GetMapping(value="getBook",produces= {"application/json"})
	public List<Book> getAllBooks()
	{
		Book b1 = new Book("isb01","SpringBook",29,"Ashok");
		Book b2 = new Book("isb02","SpringColud",22,"ROD");
		Book b3 = new Book("isb03","SpringSecurity",25,"SHAUN");
		Book b4 = new Book("isb04","SpringIOC",22,"KIRAN");
		
		List<Book> books = Arrays.asList(b1,b2,b3,b4);
		return books;
	}
	
	@GetMapping(value="getBooks/{isbn}",produces= {"application/json"})
	public Book getBook(@PathVariable String isbn)
	{
		Book b1 = new Book(isbn,"Autography",13,"Sachin");
		Link withRel = WebMvcLinkBuilder.linkTo(
				WebMvcLinkBuilder.methodOn(
						BookController.class).getAllBooks()).withRel("All-Books");
		b1.add(withRel);
		return b1;
	}

}
