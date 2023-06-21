package com.example.repository;

import com.example.model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepo implements IProductRepo {
    private static final String SELECT_ALL_PRODUCT_QUERY = "SELECT p FROM Product as p";

    @Override
    public List<Product> display() {
        return ConnectionUtils.getEntityManager().createQuery(SELECT_ALL_PRODUCT_QUERY).getResultList();
    }

    @Override
    public boolean create(Product product) {
        for (Product p : display()) {
            if (product.getId() == p.getId()) {
                return false;
            }
        }
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        for (Product p : display()) {
            if (p.getId() == id) {
                Session session = null;
                Transaction transaction = null;
                try {
                    session = ConnectionUtils.getSessionFactory().openSession();
                    transaction = session.beginTransaction();
                    session.delete(p);
                    transaction.commit();
                } catch (Exception e) {
                    e.printStackTrace();
                    if (transaction != null) {
                        transaction.rollback();
                    }
                    return false;
                } finally {
                    if (session != null) {
                        session.close();
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean edit(Product product) {
        Session session = null;
        Transaction transaction = null;

        Product oldProduct = this.findById(product.getId());
        try {
            session = ConnectionUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            BeanUtils.copyProperties(product, oldProduct);
            session.update(oldProduct);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return true;
    }

    @Override
    public List<Product> findByName(String name) {
        String queryStr = "SELECT c FROM Product AS c WHERE c.name like concat('%', :name, '%')";
        List<Product> productList = ConnectionUtils.getEntityManager().createQuery(queryStr).setParameter("name", name).getResultList();
        return productList;
    }

    @Override
    public Product getDetailProduct(int id) {
        for (Product p : display()) {
            if (id == p.getId()) {
                return p;
            }
        }
        return null;
    }

    @Override
    public Product findById(int id) {
        try {
            return (Product) ConnectionUtils.getEntityManager().createQuery("select p from Product as p where p.id =" + id).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
