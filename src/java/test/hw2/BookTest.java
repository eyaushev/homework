package test.hw2;

import main.hw2.Book;
import main.hw2.extra.Animals;
import main.hw2.extra.Cat;

public class BookTest {
    public static void main(String[] args) {

        Book.price = 3000;
        Book.setDiscount(10);

        Book book1 = new Book("Java. Полное руководство",1488, "Шилдт.Г." );
        Book book2 = new Book("Java. Эффективное программирование", 452, "Блох Д.");
        Book book3 = new Book("Философия Java", 1168, "Эккель Б.");
        Book book4 = new Book("Философия Java", 1168, "Эккель Б.");


        System.out.println("Строковое представление класса:");
        System.out.println(Book.class.toString());

        System.out.println("Сравнения классов:");
        System.out.println(book1.equals(book3));

        Animals cat = new Cat("Гав", "рыжий", 2);

        System.out.println(book2.equals(cat));

        System.out.println("HashCode класса:");
        System.out.println(Book.class.hashCode());
    }
}
