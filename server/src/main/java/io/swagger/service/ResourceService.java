package io.swagger.service;

import io.swagger.model.Order;
import io.swagger.model.User;
import io.swagger.model.Vendor;
import io.swagger.model.Food;
import java.util.Collection;
import java.util.UUID;

public interface ResourceService {

    Order saveOrder(Order order);
    Order findOrderById(UUID id);
    void deleteOrder(Order order);
    Collection<Order> findAllOrders();

    User saveUser(User user);
    User findUserById(String email);
    void deleteUser(User user);
    Collection<User> findAllUsers();

    Vendor saveVendor(Vendor vendor);
    Vendor findVendorById(UUID id);
    void deleteVendor(Vendor vendor);
    Collection<Vendor> findAllVendors();

    Food saveFood(Food food);
    Food findFoodById(UUID id);
    void deleteFood(Food food);
    Collection<Food> findAllFoods();



}
