package com.example.repository;

import com.example.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepo implements IProductRepo {
    private static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "iphone 14", 20000, "Apple product", "Apple"));
        productList.add(new Product(2, "Samsung 14", 220000, "Samsung product", "Samsung"));
        productList.add(new Product(3, "Viphone 14", 10000, "Viphone product", "Viphone"));
        productList.add(new Product(4, "Macbook 14", 400000, "Apple product", "Apple"));
        productList.add(new Product(5, "Redmi 14", 240000, "Xiaomi product", "Xiaomi"));
    }

    @Override
    public List<Product> display() {
        return productList;
    }

    @Override
    public boolean create(Product product) {
        for (Product p : productList) {
            if (product.getId() == p.getId()) {
                return false;
            }
        }
        productList.add(product);
        return true;
    }

    @Override
    public boolean delete(int id) {
        for (Product p : productList) {
            if (p.getId() == id) {
                productList.remove(p);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean edit(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if (product.getId() == productList.get(i).getId()) {
                productList.set(i, product);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productListFind = new ArrayList<>();
        for (Product p : productList) {
            if (p.getName().contains(name)) {
                productListFind.add(p);
            }
        }
        return productListFind;
    }

    @Override
    public Product getDetailProduct(int id) {
        for (Product p : productList) {
            if (id == p.getId()) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Product findById(int id) {
        for (Product p : productList) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
