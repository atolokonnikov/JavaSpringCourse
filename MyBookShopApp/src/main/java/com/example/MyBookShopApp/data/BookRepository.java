package com.example.MyBookShopApp.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    @Query("from Book")
    List<Book> customFindAllBooks();

    //NEW BOOK REST REPOSITORY COMMANDS

//    List<Book> findBookByNameContaining(String authorName);

    List<Book> findBooksByTitleContaining(String bookTitle);

    List<Book> findBookByPriceOldBetween(Integer min, Integer max);

    List<Book> findBookByPriceOldIs(Integer priceOld);

    @Query("from Book where isBestseller = 1")
    List<Book> getBestsellers();

    @Query(value="select * from book where discount = (select max(discount) from book)", nativeQuery=true)
    List<Book> getBookWithMaxDiscount();
}
