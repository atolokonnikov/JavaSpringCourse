package com.example.MyBookShopApp.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Query(value = "select * from Book where is_bestseller = 1 order by id", nativeQuery = true)
    Page<Book> findBookPopular(Pageable pageable);

    @Query(value="select * from book where discount = (select max(discount) from book)", nativeQuery=true)
    List<Book> getBookWithMaxDiscount();

    @Query(value = "select * from book where pub_date > current_date - interval '2 year'  order by id", nativeQuery = true)
    Page<Book> findBookByPubDate(Pageable pageable);

    Page<Book> findBookByTitleContaining(String bookTitle, Pageable nextPage);
}
