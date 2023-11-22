package com.api.barberMap.service.impl;

import java.util.List;

import com.api.barberMap.model.entity.LocalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.barberMap.model.dao.LocalUserDao;
import com.api.barberMap.model.dto.LocalUserDto;
import com.api.barberMap.service.ILocalService;
import com.api.barberMap.service.ILocalUserService;
import com.api.barberMap.service.IUserService;

import com.api.barberMap.model.entity.Local;
import com.api.barberMap.model.entity.User;

@Service
public class LocalUserImplService implements ILocalUserService{
    
    @Autowired
    private LocalUserDao localUserDao;
    private ILocalService localService;
    private IUserService userService;

    @Override
    public List<LocalUser> listAll(){
        return (List<LocalUser>) localUserDao.findAll();
    }

    @Transactional
    @Override
    public LocalUser save(LocalUserDto localUserDto) {
        Integer localUserId = localUserDto.getIdLocalUser();
        Integer userId = localUserDto.getUser_id();
        Integer localId = localUserDto.getLocals_id();
        Local local = localService.findById(localId);
        User user = userService.findById(userId);



        if(local == null){
            if(user == null){
                System.out.println(user);
                System.out.println(local);
            }
        }

        LocalUser localUser = LocalUser.builder()
                .idLocalUser(localUserId)
                .user_id(user)
                .locals_id(local)
                .id_user_register(user)
                .created_at(localUserDto.getCreated_at())
                .updated_at(localUserDto.getUpdated_at())
                .build();
        
        return localUserDao.save(localUser);
    }

    @Override
    public LocalUser findById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void delete(LocalUser localUser) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public boolean existeById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existeById'");
    }
}
