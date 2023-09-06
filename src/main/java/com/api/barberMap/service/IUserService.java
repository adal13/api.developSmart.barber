package com.api.barberMap.service;

import com.api.barberMap.model.dao.UserDao;
import com.api.barberMap.model.dto.UserDto;
import com.api.barberMap.model.entity.User;

import java.util.List;

public interface IUserService {
    List<User> listAll();
    User save(UserDto user);
    User findById(Integer id);
    void delete(User user);
    boolean existsById(Integer id);
}
