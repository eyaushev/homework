package main.hw1;

public class Book {
    public String title;
    public int pageCount;
    public double price;
    public boolean isOpened;

    public void open(){
        if (isOpened)
            System.out.println("Книга уже открыта");
        else {
            isOpened = true;
            System.out.println("Вы открыли книгу");
        }

    }

    public void close(){
        if (!isOpened)
            System.out.println("Книга уже закрыта");
        else {
            isOpened = false;
            System.out.println("Вы закрыли книгу");
        }
    }
}