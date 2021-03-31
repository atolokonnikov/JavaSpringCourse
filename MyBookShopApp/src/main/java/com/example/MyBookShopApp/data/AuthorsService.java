package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class AuthorsService {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthorsService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> getAuthorsLinks() {
        List<String> authorsLinks = jdbcTemplate.query("SELECT distinct substring(upper(author),1,1) authorsLinks FROM AUTHORS order by authorsLinks", (ResultSet rs, int rowNum) -> {
            String authorsLink;
            authorsLink = rs.getString("authorsLinks");
            return authorsLink;
        });
        return new ArrayList<String>(authorsLinks);
    }

    public HashMap<String, Authors> getAuthorsData() {
        String mapKey;
        HashMap<String, Authors> authorsMap = new HashMap();
        ArrayList<Author> authorsList = (ArrayList<Author>) jdbcTemplate.query("SELECT * FROM authors order by author", (ResultSet rs, int rowNum) -> {
            Author author = new Author();
            author.setAuthor(rs.getString("author"));
            return author;
        });

        Authors authors = null;

//        authorsMap = authorsList.stream().collect(Collectors.groupingBy(author -> author.getAuthor().substring(0, 1).toUpperCase()));
        for (Author author : authorsList) {
            mapKey = author.getAuthor().substring(0, 1).toUpperCase();
            if (authorsMap.containsKey(mapKey)) {
                authorsMap.get(mapKey).add(author);
            } else {
                Logger.getLogger(AuthorsService.class.getName()).info("else author = " + author);
                authors = new Authors();
                authors.add(author);
                authorsMap.put(mapKey, authors);
            }

            Logger.getLogger(AuthorsService.class.getName()).info("mapKey = " + mapKey);
            Logger.getLogger(AuthorsService.class.getName()).info("author: " + author.getAuthor());
        }
        Logger.getLogger(AuthorsService.class.getName()).info("authorsMap.keySet(): " + authorsMap.keySet());
        Logger.getLogger(AuthorsService.class.getName()).info("authorsMap.entrySet(): " + authorsMap.entrySet());
        Logger.getLogger(AuthorsService.class.getName()).info("authorsMap: " + authorsMap);
        Logger.getLogger(AuthorsService.class.getName()).info("authorsMap.authorsMap.get(\"T\").getAuthors(): " + authorsMap.get("T").getAuthors());
        return new HashMap(authorsMap);
    }
}
