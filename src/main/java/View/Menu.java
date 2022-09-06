package View;

public interface Menu {
    void showMenu();
    void exit();

    default void showItems(String[] items) {
        for (String item : items) {
            System.out.println(item.toUpperCase());
        }
    }
}
