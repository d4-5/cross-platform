package data;

public class Book extends Media {
    private String author;
    private int pages;
    public Book(String title, String author, int pages){
        super(title, true);
        this.author = author;
        this.pages = pages;
    }
}
