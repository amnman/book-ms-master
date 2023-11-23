package com.edureka.bookms;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public void saveBook(Book book){
        bookRepository.save(book);
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public void deleteBook(Integer id){
        bookRepository.deleteById(id);
    }

    public Optional<Book> getBookId(Integer id){
        return bookRepository.findById(id);
    }

    public ResponseEntity<Book> updateBoook(Book book){
        Optional<Book> BookDb = bookRepository.findById(book.getIsbn());
        if (BookDb.isPresent()){
            Book bookUpdate = BookDb.get();
            bookUpdate.setAuthor(book.getAuthor());
            bookUpdate.setIssuedCopies(book.getIssuedCopies());
            bookUpdate.setPublishedDate(book.getPublishedDate());
            bookUpdate.setTitle(book.getTitle());
            bookUpdate.setPublishedDate(book.getPublishedDate());
            bookRepository.save(bookUpdate);

            return ResponseEntity.ok().body(bookUpdate);
        }
        else{
            return (ResponseEntity<Book>) ResponseEntity.badRequest();
        }

    }

    public void Println(){
        System.out.println("Shared");
    }
}
