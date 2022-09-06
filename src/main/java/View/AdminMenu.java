package View;

import Essences.Permanents;
import Service.implement.OrderServiceImplement;
import Service.implement.ProductServiceImplement;
import Service.implement.UserServiceImplement;

import java.util.Scanner;

public class AdminMenu implements Menu {
    boolean isRunning = true;
    private String [] items = {"1. Show all users", "2. Show all games", "3. Add new game", "4. Block unblock user",
            "5. Confirm/Unconfirm orders", "6. Delete product", "7. Delete user", "8. Edit product", "9. Back", "0. Exit"};

    private Scanner scanner;

    @Override
    public void showMenu() {
        System.out.println("Logged as admin");
        showItems(items);
        scanner = new Scanner(System.in);
        System.out.println("Choose section");

        while (isRunning) {
            int choice = scanner.nextInt();

            if (new Permanents().ALL_USERS == choice) {
                new UserServiceImplement().printAllUsers();
            } else if (new Permanents().ALL_GAMES == choice) {
                new ProductServiceImplement().printAllProducts();
            } else if (new Permanents().ADD_NEW_GAMES == choice) {
                new ProductServiceImplement().addProduct();
            } else if (new Permanents().BLOCK_UNBLOCK_USERS == choice) {
                new UserServiceImplement().blockUnblockUser();
            } else if (new Permanents().CONFIRM_UNCONFIRM_ORDERS == choice) {
                new OrderServiceImplement().confirmUnconfirm();
            } else if (new Permanents().DELETE_PRODUCT == choice) {
                new ProductServiceImplement().deleteProduct();
            } else if (new Permanents().DELETE_USER == choice) {
                new UserServiceImplement().deleteUser();
            } else if (new Permanents().EDIT_PRODUCT == choice) {
                new ProductServiceImplement().editProduct();
            } else if (new Permanents().BACK == choice) {
                new LoginMenu().showMenu();
            } else if (new Permanents().EXIT == choice) {
                exit();
            }
        }
        System.out.println("Chose option");
    }

    @Override
    public void exit() {
        System.out.println("Exit from admin menu");
        System.exit(0);
    }
}
