package io.swagger.service;

import io.swagger.model.Order;
import io.swagger.repository.OrderRepository;
import io.swagger.model.User;
import io.swagger.repository.UserRepository;
import io.swagger.model.Vendor;
import io.swagger.repository.VendorRepository;
import io.swagger.model.Food;
import io.swagger.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    public ResourceServiceImpl(
      OrderRepository orderRepository, UserRepository userRepository, VendorRepository vendorRepository, FoodRepository foodRepository){
            this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.vendorRepository = vendorRepository;
        this.foodRepository = foodRepository;
    }

    private OrderRepository orderRepository;

    @Override
    public Order findOrderById(int id) throws DataAccessException {
        Order order= orderRepository.findById(id);
        return order;
    }

    @Override
    public Collection<Order> findAllOrders() throws DataAccessException {
        return orderRepository.findAll();
    }

    @Override
    public void saveOrder(Order order) throws DataAccessException {
        orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Order order) throws DataAccessException {
        orderRepository.delete(order);
    }

private UserRepository userRepository;

    @Override
    public User findUserById(int id) throws DataAccessException {
        User user= userRepository.findById(id);
        return user;
    }

    @Override
    public Collection<User> findAllUsers() throws DataAccessException {
        return userRepository.findAll();
    }

    @Override
    public void saveUser(User user) throws DataAccessException {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) throws DataAccessException {
        userRepository.delete(user);
    }

private VendorRepository vendorRepository;

    @Override
    public Vendor findVendorById(int id) throws DataAccessException {
        Vendor vendor= vendorRepository.findById(id);
        return vendor;
    }

    @Override
    public Collection<Vendor> findAllVendors() throws DataAccessException {
        return vendorRepository.findAll();
    }

    @Override
    public void saveVendor(Vendor vendor) throws DataAccessException {
        vendorRepository.save(vendor);
    }

    @Override
    public void deleteVendor(Vendor vendor) throws DataAccessException {
        vendorRepository.delete(vendor);
    }

private FoodRepository foodRepository;

    @Override
    public Food findFoodById(int id) throws DataAccessException {
        Food food= foodRepository.findById(id);
        return food;
    }

    @Override
    public Collection<Food> findAllFoods() throws DataAccessException {
        return foodRepository.findAll();
    }

    @Override
    public void saveFood(Food food) throws DataAccessException {
        foodRepository.save(food);
    }

    @Override
    public void deleteFood(Food food) throws DataAccessException {
        foodRepository.delete(food);
    }





}
