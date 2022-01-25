package com.galvanize.tmo.paspringstarter;


import com.galvanize.tmo.paspringstarter.dao.BookRepository;
import com.galvanize.tmo.paspringstarter.model.BookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import com.galvanize.tmo.paspringstarter.model.Book;

import java.util.*;


@RestController
@RequestMapping
public class LibraryController {



    @Autowired
    private BookRepository repository;
    ArrayList<Book> library = new ArrayList<Book>();

    @PostMapping("/api/books")
    @ResponseStatus(HttpStatus.CREATED )
    public Book saveBook(@RequestBody Book book){

        library.add(book);
        repository.save(book);
        
        return library.get(library.size()-1);
    }

    @GetMapping("/api/books")
    @ResponseStatus(HttpStatus.OK )
    public BookResponse getAll(){
        Collections.sort(library, Comparator.comparing(Book::getTitle));
        BookResponse books = new BookResponse(library);

        return  books;
        }

    @DeleteMapping("api/books")
    @ResponseStatus(HttpStatus.NO_CONTENT )
    public void deleteAll(){
      //  repository.deleteAll();
        library.removeAll(library);
    }


    @GetMapping("/health")
    public void health() {

    }



}



