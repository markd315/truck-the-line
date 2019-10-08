package io.swagger.service;

import io.swagger.model.Order;
import io.swagger.model.User;
import io.swagger.model.Vendor;
import io.swagger.model.Food;
import java.util.Collection;

public interface ResourceService {

    void saveOrder(Order order);
    Order findOrderById(int Id);
    void deleteOrder(Order order);
    Collection<Order> findAllOrders();void saveUser(User user);
    User findUserById(int Id);
    void deleteUser(User user);
    Collection<User> findAllUsers();void saveVendor(Vendor vendor);
    Vendor findVendorById(int Id);
    void deleteVendor(Vendor vendor);
    Collection<Vendor> findAllVendors();void saveFood(Food food);
    Food findFoodById(int Id);
    void deleteFood(Food food);
    Collection<Food> findAllFoods();



}
