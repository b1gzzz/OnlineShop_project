package Service.implement;

import Dao.implement.ProductDaoImplement;
import Essences.Permanents;
import Essences.Product;
import Service.ProductService;

import java.util.Comparator;
import java.util.Scanner;

public class ProductServiceImplement implements ProductService {
    Scanner scanner = new Scanner(System.in);

    public ProductServiceImplement() {
    }

    @Override
    public void addProduct() {
        System.out.println("Enter game title");
        String inputName = scanner.next();
        System.out.println("Enter genre");
        String inputGenre = scanner.next();
        System.out.println("Enter price");
        int inpurPrice = scanner.nextInt();
        ProductDaoImplement.getInstance().games.add(new Product(inputName, inputGenre, inpurPrice));
        System.out.println("Select option");
    }

    @Override
    public void printAllProducts() {
        System.out.println("All games: ");
        ProductDaoImplement.getInstance().games.forEach(System.out::println);
        System.out.println("Select option");
    }

    @Override
    public void deleteProduct() {
        System.out.println("Enter game name");
        String nameRemove = scanner.nextLine();
        ProductDaoImplement.getInstance().games.remove(ProductDaoImplement.getInstance()
                .games.stream().filter(game -> game.getName().equals(nameRemove)).findAny().orElse(null));
        System.out.println("Game removed");
        System.out.println("Select option");
    }

    @Override
    public void sortProductsByPrice() {
        ProductDaoImplement.getInstance().games.sort(Comparator.comparing(Product::getPrice));
        ProductDaoImplement.getInstance().games.forEach(System.out::println);
    }

    public void sortGamesByName() {
        ProductDaoImplement.getInstance().games.sort(Comparator.comparing(Product::getName));
        ProductDaoImplement.getInstance().games.forEach(System.out::println);
    }

    public void sortGamesByGenre() {
        ProductDaoImplement.getInstance().games.sort(Comparator.comparing(Product::getGenre));
        ProductDaoImplement.getInstance().games.forEach(System.out::println);
    }

    public void editGameName() {
        scanner = new Scanner(System.in);
        System.out.println("Enter game title");
        String nameProductEdit = scanner.next();

        System.out.println("Enter new title");
        String inputName = scanner.next();
        ProductDaoImplement.getInstance().games.stream().filter(game -> game.getName().equals(nameProductEdit))
                .forEach(game -> game.setName(inputName));
        System.out.println("Nice. New title - " + inputName);
    }

    public void editGameGenre() {
        scanner = new Scanner(System.in);
        System.out.println("Enter game title");
        String nameProductEdit = scanner.next();

        System.out.println("Enter new genre");
        String inputGenre = scanner.next();
        ProductDaoImplement.getInstance().games.stream().filter(game -> game.getName().equals(nameProductEdit))
                .forEach(game -> game.setGenre(inputGenre));
        System.out.println("Nice. New genre - " + inputGenre);
    }

    public void editGamePrice() {
        scanner = new Scanner(System.in);
        System.out.println("Enter game title");
        String nameProductEdit = scanner.next();

        System.out.println("Enter new price");
        int inpurPrice = scanner.nextInt();
        ProductDaoImplement.getInstance().games.stream().filter(game -> game.getName().equals(nameProductEdit))
                .forEach(game -> game.setPrice(inpurPrice));
        System.out.println("Nice. New price - " + inpurPrice);
    }

    public void editProduct() {
        scanner = new Scanner(System.in);
        System.out.println("Enter game title");
        String nameProductEdit = scanner.next();

        if (ProductDaoImplement.getInstance().games.stream().filter(game -> game.getName().
                equals(nameProductEdit)).noneMatch(game -> game.getName().equals(nameProductEdit))) {
            System.out.println("Already exists");
        } else {
            System.out.println("1. Edit title. 2. Edit genre. 3. Edit price");
            scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            if (new Permanents().EDIT_GAME_NAME == choice) {
                editGameName();
            } else if (new Permanents().EDIT_GAME_GENRE == choice) {
                editGameGenre();
            } else if (new Permanents().EDIT_GAME_PRICE == choice) {
                editGamePrice();
            } else {
                System.out.println("Try again!");
            }
        }
    }

    public void searchByName() {
        System.out.println("Enter game title");
        scanner = new Scanner(System.in);
        String searchName = scanner.next();
        if (ProductDaoImplement.getInstance().games.stream().filter(game -> game.getName().equals(searchName))
                .noneMatch(game -> game.getName().equals(searchName))) {
            System.out.println("No such games");
        } else {
            ProductDaoImplement.getInstance().games.stream().filter(game -> game.getName().equals(searchName))
                    .forEach(System.out::println);
        }
    }

    public void searchByGenre() {
        System.out.println("Enter game genre");
        scanner = new Scanner(System.in);
        String searchGenre = scanner.next();
        if (ProductDaoImplement.getInstance().games.stream().filter(game -> game.getGenre().equals(searchGenre))
                .noneMatch(game -> game.getGenre().equals(searchGenre))) {
            System.out.println("No such games");
        } else {
            ProductDaoImplement.getInstance().games.stream().filter(game -> game.getGenre().equals(searchGenre))
                    .forEach(System.out::println);
        }
    }

    public void searchForSpecificProduct() {
        System.out.println("1. Search for title. 2.Search for genre");
        scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        if (new Permanents().SEARCH_BY_GAME_NAME == choice) {
            searchByName();
        } else if (new Permanents().SEARCH_BY_GAME_GENRE == choice) {
            searchByGenre();
        } else {
            System.out.println("Try again");
        }
        System.out.println("Select option");
    }
}
