package com.finalProject.booklub.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

//@RestController
@Controller
@RequestMapping(path = "/books")
public class BookController {

    private final BookService bookService;
    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookService bookService, BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.bookService = bookService;
    }

    @GetMapping(value = "/all")
    public String showAll(Model model) {
        model.addAttribute("books", bookService.getBooks());

        return "/Book/allBooks";
    }

    @GetMapping("/add")
    public String insertNewBookForm(Model model) {
        model.addAttribute("book", new Book());

        return "/Book/createBooksForm";
    }

    @PostMapping ("/all")
    public String insertNewBook( @ModelAttribute Book book,Model model ) {
        bookService.addNewBook(book);

        return "redirect:/books/all";
    }

    @GetMapping("books/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        bookService.deleteBook(book);
        return "redirect:/books/all";
    }



    @GetMapping("books/update/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {

        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));

        model.addAttribute("oldBook", book);
        return "/Book/editBooksForm";
    }



    @PostMapping("/update/{id}")
    public String updateUser(@PathVariable("id") long id, Book book, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            book.setId(id);
//            return "/Book/editBooksForm";}

        bookService.updateBook(id, book);
        return "redirect:/books/all";
    }





//    @GetMapping
//    public List<Book> getBooks() {
//        return bookService.getBooks();
//    }

//    @PostMapping(path = "/save", consumes = {"application/json"})
//    public void insertNewBook(@RequestBody Book book) {
//        bookService.addNewBook(book);
//    }

//    @DeleteMapping(path = "{bookTitle}")
//    public void deleteBook(@PathVariable("bookTitle") Book bookTitle) {
//        bookService.deleteBook(bookTitle);
//    }


//    @PutMapping(path = "{bookId}")
//    public void updateBook(
//            @PathVariable("bookId") long bookId,
//            @RequestParam(required = false) String title,
//            @RequestParam(required = false) String publisher) {
//        bookService.updateBook(bookId, title, publisher);
//    }

//    @GetMapping(value = "search")
//    public Optional<Book> findBook(
//            @Or({
//                    @Spec(params = "title", path = "title", spec = LikeIgnoreCase.class),
//                    @Spec(params = "authorFirstName", path = "authorFirstName", spec = LikeIgnoreCase.class),
//                    @Spec(params = "authorLastName", path = "authorLastName", spec = LikeIgnoreCase.class),
//                    @Spec(params = "yearOfPublish", path = "yearOfPublish", spec = LikeIgnoreCase.class),
//                    @Spec(params = "publisherName", path = "publisherName", spec = LikeIgnoreCase.class)
//            })
//            Specification<Book> bookSpec) {
//
//        return bookService.searchBook(bookSpec);
//    }

//    @GetMapping("/bookTitleAutocomplete")
//    @ResponseBody
//    public List<String> bookTitleAutocomplete(@RequestParam(value = "term", required = false, defaultValue = "") String term) {
//        return bookService.bookTitleAutocomplete(term);
//    }

}