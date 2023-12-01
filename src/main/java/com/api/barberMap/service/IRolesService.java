package com.api.barberMap.service;
import com.api.barberMap.model.dto.Model_has_RoleDto;
import com.api.barberMap.model.entity.Model_has_Role;

public interface IRolesService {

    Iterable<Model_has_Role> listAll();
    Model_has_Role save(Model_has_RoleDto role);
    Model_has_Role findById(Integer id);
    void delete(Model_has_Role role);
    boolean existeById(Integer id);
    
} 
