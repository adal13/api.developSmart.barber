package com.api.barberMap.service.impl;

import com.api.barberMap.model.dao.CitaDao;
import com.api.barberMap.model.dto.CitaDto;
import com.api.barberMap.model.entity.Cita;
import com.api.barberMap.service.ICitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CitaImplService implements ICitaService {

    @Autowired
    private CitaDao citaDao;

    @Override
    public List<Cita> listAll() {
        return (List<Cita>) citaDao.findAll();}

    @Transactional
    @Override
    public Cita save(CitaDto cita) {
        Integer citaid = cita.getIdCitas();

        Cita citas = Cita.builder()
                .idCitas(citaid)
                .hora(cita.getHora())
                .fecha(cita.getFecha())
                .barber_id(cita.getBarber_id())
                .service_id(cita.getService_id())
                .user_id(cita.getUser_id())
                .status(cita.getStatus())
                .created_at(cita.getCreated_at())
                .updated_at(cita.getUpdated_at())
                .build();

        return citaDao.save(citas);
    }

    @Transactional(readOnly = true)
    @Override
    public Cita findById(Integer id) {
        return citaDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Cita cita) {
        citaDao.delete(cita);
    }

    @Override
    public boolean existedById(Integer id) {
        return citaDao.existsById(id);
    }
}
