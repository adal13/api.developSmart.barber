package com.api.barberMap.controller;

import com.api.barberMap.model.dto.UserDto;
import com.api.barberMap.model.entity.User;
import com.api.barberMap.model.payload.MensajeResponse;
import com.api.barberMap.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("usuarios")
    public ResponseEntity<?> showAll(){
        List<User> getList = userService.listAll();
        if (getList == null){
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("No hay registro")
                    .object(null)
                    .build()
                    , HttpStatus.OK);
        }
        return new ResponseEntity<>(MensajeResponse.builder()
                .mensaje("")
                .object(getList)
                .build()
                , HttpStatus.OK);
    }

    @PostMapping("user")
    public ResponseEntity<?> create(@RequestBody UserDto userDto){
        User userSave = null;
        try {
            userSave = userService.save(userDto);
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Guardado Correctamente")
                    .object(UserDto.builder()
                            .idUser(userSave.getIdUser())
                            .nombre(userSave.getNombre())
                            .apellido(userSave.getApellido())
                            .telefono(userSave.getTelefono())
                            .correo(userSave.getCorreo())
                            .nombreUsuario(userSave.getNombreUsuario())
                            .contrasena(userSave.getContrasena())
                            .avatar(userSave.getAvatar())
                            .emailVerified(userSave.getEmailVerified())
                            .rememberToken(userSave.getRememberToken())
                            .createdAt(userSave.getCreatedAt())
                            .updatedAt(userSave.getUpdatedAt())
                            .build())
                    .build(), HttpStatus.CREATED);
        }catch (DataAccessException exDt){
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje(exDt.getMessage())
                    .object(null)
                    .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @PutMapping("user/{id}")
    public ResponseEntity<?> update(@RequestBody UserDto userDto, @PathVariable Integer id){

        User userUpdate = null;
        try {
            if (userService.existsById(id)){
                userDto.setIdUser(id);
                userUpdate = userService.save(userDto);
                return new ResponseEntity<>(MensajeResponse.builder()
                        .mensaje("Guardado Correctamente")
                        .object(UserDto.builder()
                                .idUser(userUpdate.getIdUser())
                                .nombre(userUpdate.getNombre())
                                .apellido(userUpdate.getApellido())
                                .telefono(userUpdate.getTelefono())
                                .correo(userUpdate.getCorreo())
                                .nombreUsuario(userUpdate.getNombreUsuario())
                                .contrasena(userUpdate.getContrasena())
                                .avatar(userUpdate.getAvatar())
                                .emailVerified(userUpdate.getEmailVerified())
                                .rememberToken(userUpdate.getRememberToken())
                                .createdAt(userUpdate.getCreatedAt())
                                .updatedAt(userUpdate.getUpdatedAt())
                                .build())
                        .build(), HttpStatus.CREATED);
            }else{
                return new ResponseEntity<>(MensajeResponse.builder()
                        .mensaje("El registro que intenta actualizar no se encuentra en la Base de Datos")
                        .object(null)
                        .build()
                        , HttpStatus.NOT_FOUND);
            }
        }catch (DataAccessException exDt){
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje(exDt.getMessage())
                    .object(null)
                    .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }

    }

    @DeleteMapping("user/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            User userDelete = userService.findById(id);
            userService.delete(userDelete);
            return new ResponseEntity<>(userDelete, HttpStatus.NO_CONTENT);
        }catch (DataAccessException exDt){
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje(exDt.getMessage())
                    .object(null)
                    .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }
    @GetMapping("user/{id}")
    public ResponseEntity<?> showById(@PathVariable Integer id){
        User user = userService.findById(id);

        if(user == null){
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("El registro que intenta buscar no existe!!")
                    .object(null)
                    .build()
                    , HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(MensajeResponse.builder()
                .mensaje("")
                .object(UserDto.builder()
                        .idUser(user.getIdUser())
                        .nombre(user.getNombre())
                        .apellido(user.getApellido())
                        .telefono(user.getTelefono())
                        .correo(user.getCorreo())
                        .nombreUsuario(user.getNombreUsuario())
                        .contrasena(user.getContrasena())
                        .avatar(user.getAvatar())
                        .emailVerified(user.getEmailVerified())
                        .rememberToken(user.getRememberToken())
                        .createdAt(user.getCreatedAt())
                        .updatedAt(user.getUpdatedAt())
                        .build()
                )
                .build()
                ,HttpStatus.OK);
    }

}
