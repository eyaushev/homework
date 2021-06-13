package main.hw1;

public class Book {
    public String title;
    public int pageCount;
    public static double price;
    private boolean isOpened;

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

    public static void setDiscount(int percent){
        if (percent > 100 || percent < 0)
            System.out.println("Недопустимый размер скидки");
        else {
            price = price - (price * percent / 100);
            System.out.println("Скидка применена");
        }
    }

    public void printInfo(){
        System.out.println("Название: " + title + ", кол-во страниц: " + pageCount + ", цена: " + price + "руб.");
    }

}