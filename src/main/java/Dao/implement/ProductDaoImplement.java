package Dao.implement;

import Dao.ProductDao;
import Essences.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductDaoImplement implements ProductDao {

    private static ProductDaoImplement INSTANCE_DAO_PRODUCT;
    public List<Product> games = new ArrayList<>();

    private ProductDaoImplement() {
        init();
    }

    public static ProductDaoImplement getInstance() {
        if (INSTANCE_DAO_PRODUCT == null) {
            INSTANCE_DAO_PRODUCT = new ProductDaoImplement();
        }
        return INSTANCE_DAO_PRODUCT;
    }

    @Override
    public List<Product> init() {
        games.add(new Product("Bioshock", "FPS", 30));
        games.add(new Product("Anno 1800", "RTS", 130));
        games.add(new Product("Uncharted", "Adventure", 60));
        games.add(new Product("Divinity", "RPG", 60));
        games.add(new Product("Cyberpunk 2077", "FPS", 70));

        return games;
    }
}
