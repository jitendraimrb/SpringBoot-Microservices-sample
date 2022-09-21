package com.graphql.learn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.graphql.learn.entities.Book;
import com.graphql.learn.services.BookService;

import lombok.Getter;
import lombok.Setter;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;


    //create

    
    
	/*
	 * PostMan Query:- mutation{ createBook(book:{
	 * title:"Sampitaaa Nerugulla first", desc:"Nerugulla", price:8889, pages:600,
	 * author:"ABC" }){ id title }
	 * 
	 * }
	 */
    @MutationMapping("createBook")
    public Book create(@Argument BookInput book) {
        Book b=new Book();
        b.setTitle(book.getTitle());
        b.setDesc(book.getDesc());
        b.setPrice(book.getPrice());
        b.setAuthor(book.getAuthor());
        b.setPages(book.getPages());
        return this.bookService.create(b);
    }

	/*
	 * PostMan Query:- query{ allBooks{
	 * 
	 * id title } }
	 */
    @QueryMapping("allBooks")
    public List<Book> getAll() {
        return this.bookService.getAll();
    }

	/*
	 * PostMan Query:- query{ getBook(bookId:4){
	 * 
	 * id title } }
	 */
    @QueryMapping("getBook")
    public Book get(@Argument int bookId) {
        return this.bookService.get(bookId);
    }

}

@Getter
@Setter
class BookInput{
    private String title;
    private String desc;
    private String author;
    private double price;
    private int pages;
}
