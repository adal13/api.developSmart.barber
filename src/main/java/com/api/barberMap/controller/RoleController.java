package com.api.barberMap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.barberMap.model.entity.Model_has_Role;
import com.api.barberMap.model.entity.User;
import com.api.barberMap.model.payload.MensajeResponse;
import com.api.barberMap.service.IRolesService;

@RestController
@RequestMapping("/api/v1")
public class RoleController {
    @Autowired
    private IRolesService iRoleService;

    @GetMapping("roles")
    public ResponseEntity<?> showAll(){
        List<Model_has_Role> getList = (List<Model_has_Role>) iRoleService.listAll();
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
}
