package io.swagger.repository;

import io.swagger.model.Vendor;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VendorRepository extends MongoRepository<Vendor, Integer> {
    List<Vendor> findAll() throws DataAccessException;

    Vendor findById(int id) throws DataAccessException;

    Vendor save(Vendor vendor) throws DataAccessException;

    void delete(Vendor vendor) throws DataAccessException;
}
