package com.api.barberMap.service.impl;

import com.api.barberMap.model.dao.UserDao;
import com.api.barberMap.model.dto.UserDto;
import com.api.barberMap.model.entity.User;
import com.api.barberMap.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserImplService implements IUserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> listAll() { return (List) userDao.findAll();}

    @Transactional
    @Override
    public User save(UserDto userDto) {
        User user = User.builder()
                .idUser(userDto.getIdUser())
                .nombre(userDto.getNombre())
                .apellido(userDto.getApellido())
                .telefono(userDto.getTelefono())
                .correo(userDto.getCorreo())
                .nombreUsuario(userDto.getNombreUsuario())
                .contrasena(userDto.getContrasena())
                .emailVerified(userDto.getEmailVerified())
                .rememberToken(userDto.getRememberToken())
                .createdAt(userDto.getCreatedAt())
                .updatedAt(userDto.getUpdatedAt())
                .build();
        return userDao.save(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User findById(Integer id) {

        return userDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public boolean existsById(Integer id) {
        return userDao.existsById(id);
    }
}
