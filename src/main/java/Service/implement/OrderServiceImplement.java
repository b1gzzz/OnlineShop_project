package Service.implement;

import Dao.implement.ProductDaoImplement;
import Essences.Order;
import Essences.Permanents;
import Essences.Product;
import Service.OrderService;
import View.OrderMenu;
import View.ProductMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OrderServiceImplement implements OrderService {

    Scanner scanner = new Scanner(System.in);
    public static List<Order> order = new ArrayList<>();

    public OrderServiceImplement() {

    }

    @Override
    public void addProduct() {
        System.out.println("Make new order");
        List<Product> orderProduct;

        int count = 1;
        System.out.println("Type game title".toUpperCase());
        String nameProduct = scanner.nextLine();

        if (!ProductDaoImplement.getInstance().games.stream().filter(game -> game.getName()
                .equals(nameProduct)).anyMatch(game -> game.getName().equals(nameProduct))) {
            System.out.println("You can buy it");
            new ProductMenu().showMenu();
        } else {
            orderProduct = ProductDaoImplement.getInstance().games.stream().filter(game -> game.getName()
                    .equals(nameProduct)).collect(Collectors.toList());
            order.add(new Order(count++, false,orderProduct));
            System.out.println("Order created");
            order.forEach(System.out::println);
            new OrderMenu().showMenu();
        }

    }

    @Override
    public void confirmUnconfirm() {

        System.out.println("Orders: " + OrderServiceImplement.order);

        System.out.println("1. Confirm order; 2. Unconfirm Order");
        int choice = scanner.nextInt();

        if (new Permanents().CONFIRM_ORDER == choice) {
            OrderServiceImplement.order.stream().filter(order -> !order.isStatus())
                    .forEach(order -> order.setStatus(true));
            System.out.println(OrderServiceImplement.order);
            System.out.println("Confirmed");
        } else if (new Permanents().UNCONFIRM_ORDER == choice) {
            OrderServiceImplement.order.stream().filter(Order::isStatus)
                    .forEach(order -> order.setStatus(false));
            System.out.println(OrderServiceImplement.order);
            System.out.println("Unconfirmed");
        } else {
            System.out.println("JUST 1 OR 2, PLEASE!");
        }

    }

    @Override
    public void showOrder() {
        System.out.println(order);
    }

    public void orderCheckoutStatus() {

        if (order.stream().filter(order1 -> !order1.isStatus())
                .anyMatch(order1 -> !order1.isStatus())) {
            System.out.println("Wait for confirmation");
        } else {
            System.out.println("Confirmed order");
        }
        new OrderMenu().showMenu();
    }
}
