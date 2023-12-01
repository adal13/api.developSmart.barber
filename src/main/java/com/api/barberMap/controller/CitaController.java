package com.api.barberMap.controller;
import com.api.barberMap.model.dto.CitaDto;
import com.api.barberMap.model.entity.Cita;
import com.api.barberMap.model.payload.MensajeResponse;
import com.api.barberMap.service.IAttentionService;
import com.api.barberMap.service.ICitaService;
import com.api.barberMap.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CitaController {

    @Autowired
    private ICitaService citaService;
    @Autowired
    private IUserService userService;
    @Autowired
    private IAttentionService attentionService;


    @GetMapping("cita")
    public ResponseEntity<?> showAll(){
        List<Cita> getList = (List<Cita>) citaService.listAll();
        if (getList == null){
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("No hay registro")
                    .object(null)
                    .build()
                    , HttpStatus.OK

            );
        }

        return new ResponseEntity<>(MensajeResponse.builder()
                .mensaje("")
                .object(getList)
                .build()
                , HttpStatus.OK);
    }

    @PostMapping("insertCita")
    public ResponseEntity<?> create(@RequestBody CitaDto citaDto){
        Cita citaSave = null;

        try {
            citaSave = citaService.save(citaDto);
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mensaje("Guardado Correctamente")
                    .object(CitaDto.builder()
                            .idCitas(citaSave.getIdCitas())
                            .hora(citaSave.getHora())
                            .fecha(citaSave.getFecha())
                            .barber_id(citaSave.getBarber_id())
                            .service_id(citaSave.getService_id())
                            .user_id(citaSave.getUser_id())
                            .status(citaSave.getStatus())
                            .created_at(citaSave.getCreated_at())
                            .updated_at(citaSave.getUpdated_at())
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

    @PutMapping("updateCita/{id}")
    public ResponseEntity<?> update(@RequestBody CitaDto citaDto, @PathVariable Integer id){
        Cita citaUpdate = null;
        try {
            if (citaService.existedById(id)){
                citaDto.setIdCitas(id);
                citaUpdate = citaService.save(citaDto);
                return new ResponseEntity<>(MensajeResponse.builder()
                        .mensaje("Guardado Correctamente")
                        .object(CitaDto.builder()
                            .idCitas(citaUpdate.getIdCitas())
                            .hora(citaUpdate.getHora())
                            .fecha(citaUpdate.getFecha())
                            .barber_id(citaUpdate.getBarber_id())
                            .service_id(citaUpdate.getService_id())
                            .user_id(citaUpdate.getUser_id())
                            .status(citaUpdate.getStatus())
                            .created_at(citaUpdate.getCreated_at())
                            .updated_at(citaUpdate.getUpdated_at())
                            .build())
                        .build(), HttpStatus.CREATED);
            }else {
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

}
