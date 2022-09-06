package View;

import Essences.Permanents;
import Service.implement.ProductServiceImplement;

import java.util.Scanner;

public class ProductMenu implements Menu {

    boolean isRunning = true;

    private String[] options = {"1.Order menu", "2.Show all games", "3.Sort by genre", "4.Sort by price", "5.Sort by title",
            "6.Search fo specific game", "9.Back", "0.Exit"};
    private Scanner scanner;

    @Override
    public void showMenu() {
        System.out.println("Product menu");
        showItems(options);
        scanner = new Scanner(System.in);
        System.out.println("Choose the option");

        while (isRunning) {
            int choice = scanner.nextInt();

            if (new Permanents().CREATE_ORDER == choice) {
                new OrderMenu().showMenu();
            } else if (new Permanents().ALL_GAMES == choice) {
                new ProductServiceImplement().printAllProducts();
            } else if (new Permanents().SORT_BY_GENRE == choice) {
                new ProductServiceImplement().sortGamesByGenre();
            } else if (new Permanents().SORT_BY_PRICE == choice) {
                new ProductServiceImplement().sortProductsByPrice();
            } else if (new Permanents().SORT_BY_NAME == choice) {
                new ProductServiceImplement().sortGamesByName();
            } else if (new Permanents().SEARCH_SPECIFIC_PRODUCT == choice) {
                new ProductServiceImplement().searchForSpecificProduct();
            } else if (new Permanents().BACK == choice) {
                new LoginMenu().showMenu();
            } else if (new Permanents().EXIT == choice) {
                exit();
            }
        }
        System.out.println("Choose option");
    }

    @Override
    public void exit() {
        System.out.println("Exit from product menu");
        System.exit(0);
    }
}
