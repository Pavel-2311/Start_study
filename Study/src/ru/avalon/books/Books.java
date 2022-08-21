
package ru.avalon.books;


public class Books {
    
    private String bookName; // название книги
    private int year; // год издания
    private String autors;// авторы книг
    String publishingName;
    

    public Books(String bookName, int year, String publishingName) {
        this(bookName,null, year, publishingName);
       
    }
    
    
    public Books(String bookName, String autors,int year, String publishingName) {
        setBookName(bookName);
        setYear(year);
        setAutors(autors);
        setPublishingName(publishingName);
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
         if(bookName == null)
            throw new IllegalArgumentException("book name can't be null.");
        this.bookName = bookName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
         if(year == 0)
            throw new IllegalArgumentException("year of publishing can't be zero.");
        this.year = year;
    }

    public String getAutors() {
        if(autors == null)
            throw new IllegalArgumentException("autors can't be null.");
        return autors;
    }

    public void setAutors(String autors) {
        this.autors = autors;
    }

    public String getPublishingName() {
        return publishingName;
    }

    public void setPublishingName(String publishingName) {
        if(publishingName == null)
            throw new IllegalArgumentException("publishing  name can't be null.");
        
        this.publishingName = publishingName;
    }
    
    public void print() {
        System.out.println("Book name is: "+ bookName + " autors " + autors + " in:"
            + year + "; publishing is: " + publishingName);
    }

    public static void printAll(Books[] books) {
        for(Books b: books) {
            b.print();
            System.out.println();
        }
    
}
}