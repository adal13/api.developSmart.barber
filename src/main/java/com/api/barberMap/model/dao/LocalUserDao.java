package com.api.barberMap.model.dao;

import com.api.barberMap.model.entity.LocalUser;
import org.springframework.data.repository.CrudRepository;

public interface LocalUserDao extends CrudRepository<LocalUser, Integer>{
}
