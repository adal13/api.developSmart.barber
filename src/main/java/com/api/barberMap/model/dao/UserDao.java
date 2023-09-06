package com.api.barberMap.model.dao;

import org.springframework.data.repository.CrudRepository;
import com.api.barberMap.model.entity.User;

public interface UserDao extends CrudRepository<User, Integer> {
}
