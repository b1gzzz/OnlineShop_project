package Service.implement;

import Dao.implement.UserDaoImplement;
import Essences.Permanents;
import Service.UserService;

import java.util.Scanner;

public class UserServiceImplement implements UserService {
    Scanner scanner = new Scanner(System.in);

    public void blockUser() {
        System.out.println("Enter user ID.");
        scanner = new Scanner(System.in);
        long blockID = scanner.nextInt();

        if (UserDaoImplement.getInstance().users.stream().filter(user -> user.getId() == blockID)
                .noneMatch(user -> user.getId() == blockID)) {
            System.out.println("No such user");
        } else {
            UserDaoImplement.getInstance().users.stream().filter(user -> user.getId() == blockID)
                    .forEach(user -> user.setStatus(false));
            System.out.println("User blocked");
        }
    }

    public void unblockUser() {
        System.out.println("Enter user ID");
        scanner = new Scanner(System.in);
        long unblocked = scanner.nextLong();

        if (UserDaoImplement.getInstance().users.stream().filter(user -> user.getId() == unblocked)
                .noneMatch(user -> user.getId() == unblocked)) {
            System.out.println("No such user");
        } else {
            UserDaoImplement.getInstance().users.stream().filter(user -> user.getId() == unblocked)
                    .forEach(user -> user.setStatus(true));
            System.out.println("User blocked");
        }
    }

    @Override
    public void deleteUser() {
        System.out.println("Enter user name");
        String nameRemove = scanner.nextLine();
        UserDaoImplement.getInstance().users.remove(UserDaoImplement.getInstance()
                .users.stream().filter(user -> user.getName().equals(nameRemove)).findAny().orElse(null));
        System.out.println("User removed");
        System.out.println("Select option");
    }

    @Override
    public void printAllUsers() {
        System.out.println("All users: ");
        UserDaoImplement.getInstance().users.forEach(System.out::println);
        System.out.println("Select option");
    }

    @Override
    public void blockUnblockUser() {
        System.out.println("1. Block user. 2. Unblock user.");

        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        if (new Permanents().BLOCK_USER == choice) {
            blockUser();
        } else if (new Permanents().UNBLOCK_USER == choice) {
            unblockUser();
        } else {
            System.out.println("Try again");
        }
    }
}
