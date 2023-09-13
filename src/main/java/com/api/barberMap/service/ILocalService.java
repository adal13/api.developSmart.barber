package com.api.barberMap.service;

import com.api.barberMap.model.dto.LocalDto;
import com.api.barberMap.model.dto.UserDto;
import com.api.barberMap.model.entity.Local;
import com.api.barberMap.model.entity.User;

import java.util.List;

public interface ILocalService {
    List<Local> listAll();
    Local save(LocalDto local);
    Local findById(Integer id);
    void delete(Local local);
    boolean existsById(Integer id);
}