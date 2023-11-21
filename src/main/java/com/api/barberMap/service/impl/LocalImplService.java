package com.api.barberMap.service.impl;

import com.api.barberMap.model.dao.LocalDao;
import com.api.barberMap.model.dto.LocalDto;
import com.api.barberMap.model.entity.Local;
import com.api.barberMap.service.ILocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LocalImplService implements ILocalService {

    @Autowired
    private LocalDao localDao;

    @Override
    public List<Local> listAll() { return (List) localDao.findAll();}

    @Transactional
    @Override
    public Local save(LocalDto localDto) {
        Local local = Local.builder()
                .idLocal(localDto.getIdLocal())
                .nombre(localDto.getNombre())
                .estado(localDto.getEstado())
                .municipio(localDto.getMunicipio())
                .calle(localDto.getCalle())
                .ubicacion(localDto.getUbicacion())
                .logo(localDto.getLogo())
                .status(localDto.getStatus())
                .created_at(localDto.getCreated_at())
                .updated_at(localDto.getUpdated_at())
                .build();
        return localDao.save(local);
    }

    @Transactional(readOnly = true)
    @Override
    public Local findById(Integer id) {
        return localDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Local local) {
        localDao.delete(local);
    }

    @Override
    public boolean existsById(Integer id) {

        return localDao.existsById(id);
    }
}
