package com.api.barberMap.controller;

import java.util.List;

import com.api.barberMap.model.entity.LocalUser;
import com.api.barberMap.service.ILocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.barberMap.model.payload.MensajeResponse;
import com.api.barberMap.service.ILocalUserService;

@RestController
@RequestMapping("api/v1")
public class LocalUserController {
    @Autowired
    private ILocalUserService localUserService;
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
}
