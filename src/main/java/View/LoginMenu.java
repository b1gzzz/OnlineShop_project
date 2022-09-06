package View;

import Essences.Permanents;
import Service.implement.ValidationServiceImplement;

import java.util.Scanner;

public class LoginMenu implements Menu{

    boolean isRunning = true;
    private final String[] options = {"1.Login", "2.Register", "3.As admin", "4.Show product menu", "0.Exit"};

    @Override
    public void showMenu() {
        System.out.println("Welcome to game shop! \nChoose any option below.");
        showItems(options);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose the option");

        while (isRunning) {
            int choice = scanner.nextInt();

            if (new Permanents().LOGIN_USER == choice) {
                new ValidationServiceImplement().loginUser();
            } else if (new Permanents().REGISTER_USER == choice) {
                new ValidationServiceImplement().registerUser();
            } else if (new Permanents().ADMIN_LOGIN == choice) {
                new ValidationServiceImplement().loginAdmin();
            } else if (new Permanents().SHOW_PRODUCT_MENU == choice) {
                new ProductMenu().showMenu();
            } else if (new Permanents().EXIT == choice) {
                exit();
            }
        }
        System.out.println("Choose the option");
    }

    @Override
    public void exit() {
        System.out.println("You left the shop");
        System.exit(0);
    }
}
