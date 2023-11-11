package com.api.barberMap.service;

import java.util.List;

import com.api.barberMap.model.dto.LocalUserDto;
import com.api.barberMap.model.entity.LocalUser;

public interface ILocalUserService {
    List<LocalUser> listAll();
    LocalUser save(LocalUserDto localUser);
    LocalUser findById(Integer id);
    void delete(LocalUser localUser);
    boolean existeById(Integer id);
    
}
