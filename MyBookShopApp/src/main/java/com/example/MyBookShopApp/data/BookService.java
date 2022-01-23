package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBookData() {
        return bookRepository.findAll();
    }

    //NEW BOOK SERVICE METHODS

//    public List<Book> getBookByAuthor(String authorName) {
//        return bookRepository.findBookByNameContaining(authorName);
//    }

    public List<Book> getBooksByTitle(String title){
        return bookRepository.findBooksByTitleContaining(title);
    }

    public List<Book> getBookWithPriceBetween(Integer min, Integer max){
        return bookRepository.findBookByPriceOldBetween(min, max);
    }

    public List<Book> getBookWithPrice(Integer price) {
        return bookRepository.findBookByPriceOldIs(price);
    }

    public List<Book> getBookWithMaxPrice(){
        return bookRepository.getBookWithMaxDiscount();
    }

    public List<Book> getBestsellers(){
        return bookRepository.getBestsellers();
    }
}
