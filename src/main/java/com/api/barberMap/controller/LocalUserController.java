package com.api.barberMap.controller;

import java.util.List;

import com.api.barberMap.model.dto.LocalDto;
import com.api.barberMap.model.dto.LocalUserDto;
import com.api.barberMap.model.dto.UserDto;
import com.api.barberMap.model.entity.Local;
import com.api.barberMap.model.entity.LocalUser;
import com.api.barberMap.model.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.barberMap.model.payload.MensajeResponse;
import com.api.barberMap.service.ILocalService;
import com.api.barberMap.service.ILocalUserService;
import com.api.barberMap.service.IUserService;

@RestController
@RequestMapping("/api/v1")
public class LocalUserController {

    @Autowired
    private ILocalUserService localUserService;
    @Autowired
    private ILocalService localService;
    @Autowired
    private IUserService userService;

    @GetMapping("localUser")
    public ResponseEntity<?> showAll(){
        List<LocalUser> getList = localUserService.listAll();
        if(getList == null){
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("No hay registros")
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



    @GetMapping("localUser/{id}")
    public ResponseEntity<?> showById(@PathVariable Integer id){
        LocalUser local_user = localUserService.findById(id);

        if(local_user == null){
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("El registro que intenta buscar no existe")
                    .object(null)
                    .build()
                    , HttpStatus.NOT_FOUND);
        }

        // Local local = local_user.getLocals_id();
        // User user = local_user.getId_user_register();
        // User userId = local_user.getUser_id();

        User user = userService.findById(local_user.getUser_id().getIdUser());
        Local local = localService.findById(local_user.getLocals_id().getIdLocal());
        User idUserRegister = userService.findById(local_user.getId_user_register().getIdUser());

        if (local == null || user == null || idUserRegister == null) {
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Alguna de las entidades relacionadas es nula")
                    .object(null)
                    .build(),
                    HttpStatus.NOT_FOUND);
        }

        LocalUserDto localUserDto = LocalUserDto.builder()
                .idLocalUser(local_user.getIdLocalUser())
                .user_id(UserDto.fromUser(user))
                .locals_id(LocalDto.fromLocal(local))
                .id_user_register(UserDto.fromUser(idUserRegister))
                .created_at(local_user.getCreated_at())
                .updated_at(local_user.getUpdated_at())
                .build();

        return new ResponseEntity<>(MensajeResponse.builder()
                .mensaje("")
                .object(localUserDto)
                .build(),
                HttpStatus.OK);        
    }

}
