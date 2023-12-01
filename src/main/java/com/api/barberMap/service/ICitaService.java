package com.api.barberMap.service;

import com.api.barberMap.model.dto.CitaDto;
import com.api.barberMap.model.entity.Cita;

public interface ICitaService {

    Iterable<Cita> listAll();

    Cita save(CitaDto cita);

    Cita findById(Integer id);

    void delete(Cita cita);

    boolean existedById(Integer id);

}
