package com.api.barberMap.controller;

import com.api.barberMap.model.dto.AttentionDto;
import com.api.barberMap.model.entity.Attention;
import com.api.barberMap.model.entity.Local;
import com.api.barberMap.model.payload.MensajeResponse;
import com.api.barberMap.service.IAttentionService;
import com.api.barberMap.service.ILocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class AttentionController {

    @Autowired
    private IAttentionService attentionService;
    private ILocalService localService;

    @GetMapping("attentions")
    public ResponseEntity<?> showAll(){
        List<Attention> getList = (List<Attention>) attentionService.listAll();
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



    @PostMapping("attention")
    public ResponseEntity<?> create(@RequestBody AttentionDto attentionDto){
        Attention attentionSave = null;
        Integer localId = attentionDto.getLocals_id();
        Local local = localService.findById(localId);

        if (local == null) {
            System.out.println(local);
        }
        try {
            attentionSave = attentionService.save(attentionDto);
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Guardado Correctamente")
                    .object(AttentionDto.builder()
                            .idServices(attentionSave.getIdServices())
                            .nombre(attentionSave.getNombre())
                            .precio(attentionSave.getPrecio())
                            .duracion(attentionSave.getDuracion())
//                            .local(local)
                            .locals_id(attentionSave.getLocals_id().getIdLocal())
                            .created_at(attentionSave.getCreated_at())
                            .update_at(attentionSave.getUpdate_at())
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



}
