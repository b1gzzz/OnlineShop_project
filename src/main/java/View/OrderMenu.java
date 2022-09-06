package View;

import Essences.Permanents;
import Service.implement.OrderServiceImplement;

import java.util.Scanner;

public class OrderMenu implements Menu {

    boolean isRunning = true;
    private String[] options = {"1.Add product to order list", "2.Checkout status", "3.Show order", "9.Back", "0.Exit"};
    private Scanner scanner;
    @Override
    public void showMenu() {
        System.out.println("Order menu");
        showItems(options);
        scanner = new Scanner(System.in);

        while (isRunning) {
            int choice = scanner.nextInt();

            if (new Permanents().ADD_PRODUCT_TO_ORDER == choice) {
                new OrderServiceImplement().addProduct();
            } else if (new Permanents().ORDER_CHECKOUT == choice) {
                new OrderServiceImplement().orderCheckoutStatus();
            } else if (new Permanents().SHOW_MY_ORDER == choice) {
                new OrderServiceImplement().showOrder();
            } else if (new Permanents().BACK == choice) {
                new ProductMenu().showMenu();
            } else if (new Permanents().EXIT == choice) {
                exit();
            }
        }
        System.out.println("Choose option");
    }

    @Override
    public void exit() {
        System.out.println("Exit from order menu");
        System.exit(0);
    }
}
