package com.api.barberMap.controller;

import com.api.barberMap.model.dto.LocalDto;
import com.api.barberMap.model.entity.Local;
import com.api.barberMap.model.payload.MensajeResponse;
import com.api.barberMap.service.ILocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LocalController {
    @Autowired
    private ILocalService localService;
    @GetMapping("locales")
    public ResponseEntity<?> showAll(){
        List<Local> getList = localService.listAll();
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

    @PostMapping("local")
    public ResponseEntity<?> create(@RequestBody LocalDto localDto){
        Local localSave = null;
        try {
            localSave = localService.save(localDto);
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Guardado correctamente")
                    .object(LocalDto.builder()
                            .idLocal(localSave.getIdLocal())
                            .nombre(localSave.getNombre())
                            .direccion(localSave.getDireccion())
                            .ubicacion(localSave.getUbicacion())
                            .logo(localSave.getLogo())
                            .created_at(localSave.getCreated_at())
                            .updated_at(localSave.getUpdated_at())
                            .build())
                    .build(), HttpStatus.CREATED);
        }catch(DataAccessException exDt){
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje(exDt.getMessage())
                    .object(null)
                    .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }
}
