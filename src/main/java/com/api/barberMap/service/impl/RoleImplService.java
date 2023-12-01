package com.api.barberMap.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.barberMap.model.dao.ModelHasRoleDao;
import com.api.barberMap.model.dto.Model_has_RoleDto;
import com.api.barberMap.model.entity.Model_has_Role;
import com.api.barberMap.service.IRolesService;

import java.util.List;

@Service
public class RoleImplService implements IRolesService{

    @Autowired
    private ModelHasRoleDao roleDao;

    @Override
    public List<Model_has_Role> listAll() {
        return (List) roleDao.findAll();
    }

    @Override
    public Model_has_Role save(Model_has_RoleDto role) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Model_has_Role findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void delete(Model_has_Role role) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public boolean existeById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existeById'");
    }
    
}
