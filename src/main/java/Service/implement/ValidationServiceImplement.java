package Service.implement;

import Dao.implement.UserDaoImplement;
import Essences.Admin;
import Essences.User;
import Service.ValidationService;
import View.AdminMenu;
import View.ProductMenu;

import java.util.Scanner;

public class ValidationServiceImplement implements ValidationService {

    Scanner scanner = new Scanner(System.in);
    Admin admin = new Admin();
    UserDaoImplement userDaoImplementation = UserDaoImplement.getInstance();

    @Override
    public void registerUser() {

        System.out.println("Enter user ID, greater than 4");
        long inputIdUser = scanner.nextLong();

        if (UserDaoImplement.getInstance().users.stream().filter(user -> user.getId() == inputIdUser)
                .anyMatch(user -> user.getId() == inputIdUser)) {
            System.out.println("Get another user ID");
            registerUser();
        } else {
            System.out.println("Enter your name");
            String inputUserName = scanner.next();
            System.out.println("Enter your password");
            String inputUserPassword = scanner.next();
            UserDaoImplement.getInstance().users.add(new User(inputIdUser, inputUserName, inputUserPassword, true));
            System.out.println("Account created");
            System.out.println("Select option from menu above");
        }

    }

    @Override
    public void loginUser() {
        scanner = new Scanner(System.in);
        System.out.println("Enter your ID. We promise that soon we are going to do login by email as well :)");
        long userId = this.scanner.nextLong();

        System.out.println("Enter your password");
        String password = this.scanner.next();

        if (!(userDaoImplementation.users.stream().filter(user -> user.getId() == userId).filter(user -> user.getPassword().equals(password))
                .allMatch(user -> user.getId() == userId && user.getPassword() == password))) {
            new ProductMenu().showMenu();
        } else {
            System.out.println("Wrong data. Try again");
        }

    }

    @Override
    public void loginAdmin() {
        scanner = new Scanner(System.in);

        System.out.println("Enter your name".toUpperCase());
        String nameAdmin = scanner.nextLine();
        System.out.println("Enter your password");
        long password = scanner.nextLong();

        if (nameAdmin.equals(admin.getName()) && password == admin.getPassword()) {
            System.out.println("Success");
            new AdminMenu().showMenu();
        } else {
            System.out.println("Try again".toUpperCase());
        }

    }
}
