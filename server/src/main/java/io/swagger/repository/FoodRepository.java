package io.swagger.repository;

import io.swagger.model.Food;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface FoodRepository extends MongoRepository<Food, Integer> {
    List<Food> findAll() throws DataAccessException;

    Food findById(UUID id) throws DataAccessException;

    Food save(Food food) throws DataAccessException;

    void delete(Food food) throws DataAccessException;
}
