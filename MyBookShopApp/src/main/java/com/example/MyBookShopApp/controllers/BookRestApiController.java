package com.example.MyBookShopApp.controllers;

import com.example.MyBookShopApp.data.Book;
import com.example.MyBookShopApp.data.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@Api(description = "Book data API")
public class BookRestApiController {

    private final BookService bookService;

    @Autowired
    public BookRestApiController(BookService bookService) {
        this.bookService = bookService;
    }

//    @GetMapping("/books/by-author")
//    @ApiOperation("operation to get book list og bookshop by passed author first name")
//    public ResponseEntity<List<Book>> booksByAuthor(@RequestParam("author") String authorName){
//        return ResponseEntity.ok(bookService.getBookByAuthor(authorName));
//    }

    @GetMapping("/books/by-title")
    @ApiOperation("get books by book title")
    public ResponseEntity<List<Book>> booksByTitle(@RequestParam("title") String title){
        return ResponseEntity.ok(bookService.getBooksByTitle(title));
    }

    @GetMapping("/books/by-price-range")
    @ApiOperation("get books by price range from min price to max price")
    public ResponseEntity<List<Book>> priceRangeBooks(@RequestParam("min") Integer min, @RequestParam("max") Integer max){
        return ResponseEntity.ok(bookService.getBookWithPriceBetween(min, max));
    }

    @GetMapping("/books/with-max-price")
    @ApiOperation("get books with max price")
    public ResponseEntity<List<Book>> maxPriceBooks(){
        return  ResponseEntity.ok(bookService.getBookWithMaxPrice());
    }

    @GetMapping("/books/bestsellers")
    @ApiOperation("get bestseller books (with is_bestseller = 1)")
    public ResponseEntity<List<Book>> bestsellerBooks(){
        return ResponseEntity.ok(bookService.getBestsellers());
    }
}
