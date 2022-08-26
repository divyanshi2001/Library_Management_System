package com.sopra.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sopra.Book;
import com.sopra.BookService;
import com.sopra.repo.BookRepository;

@Controller
@RequestMapping("/library")
public class BookController {

	@Autowired
	private BookRepository bookRepo;
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping("/home")
	public String home(Model model) {
		model.addAttribute("appName", "Java Training School Library");
		return "home";
	}

	@RequestMapping("/display")
	public String displayBookInfo(Model model) {

		List<Book> allBooks = (List<Book>) bookService.findAll();
		model.addAttribute("books", allBooks);
		
		if(allBooks.isEmpty())
			model.addAttribute("msg", "Unfortunately, the library is empty now. Let's"
					+ "contribute by adding some books");
		else {
			if(model.getAttribute("msg") == null)
				model.addAttribute("msg", "Welcome to Java Traning School Library");
		}

		return "displayBook";
	}

	@GetMapping("/borrowForm/{id}")
	public String borrowForm(@PathVariable String id, Model model) {

		Book book = bookRepo.findById(Integer.parseInt(id)).get();

		model.addAttribute("book", book);

		return "borrowBook";
	}

	@PostMapping("/borrow")
	public String borrow(@RequestParam int id, Model model) {

		Book book = bookRepo.findById(id).get();
		book.setStatus("Borrowed");

		bookRepo.save(book);

		model.addAttribute("msg", "Book borrowed successfuly. Please return within a month's time");

		return displayBookInfo(model);
	}

	@GetMapping("/addBookForm")
	public String addBookForm(Model model) {
		
		model.addAttribute("book", new Book());

		return "addBook";
	}

	@PostMapping("/addBook")
	public String addBook(@ModelAttribute("book") Book book, Model model) {

		book.setStatus("available");
		bookRepo.save(book);
		
		model.addAttribute("msg", "Book added successfully. Thanks");

		return displayBookInfo(model);
	}

}
