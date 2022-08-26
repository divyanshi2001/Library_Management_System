package com.sopra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.repo.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository repo;
	
	public Iterable<Book> findAll(){
		return repo.findAll();
	}

}
