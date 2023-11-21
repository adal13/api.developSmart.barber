package com.api.barberMap.service.impl;

import com.api.barberMap.model.dao.AttentionDao;
import com.api.barberMap.model.dto.AttentionDto;
import com.api.barberMap.model.entity.Attention;
import com.api.barberMap.model.entity.Local;
import com.api.barberMap.model.payload.MensajeResponse;
import com.api.barberMap.service.IAttentionService;
import com.api.barberMap.service.ILocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AttentionImplService implements IAttentionService {

    @Autowired
    private AttentionDao attentionDao;
    private ILocalService localService;


    @Override
    public List<Attention> listAll() {
        return (List<Attention>) attentionDao.findAll();
    }


    @Transactional
    @Override
    public Attention save(AttentionDto attentionDto) {
        Integer localId = attentionDto.getLocals_id();
        Local local = localService.findById(localId);

        if (local == null) {
            System.out.println(local);
        }

        Attention attention = Attention.builder()
                .idServices(attentionDto.getIdServices())
                .nombre(attentionDto.getNombre())
                .precio(attentionDto.getPrecio())
                .duracion(attentionDto.getDuracion())
                .imagen(attentionDto.getImagen())
                .locals_id(local)
//                .locals_id(attentionDto.getLocals_id())
                .created_at(attentionDto.getCreated_at())
                .update_at(attentionDto.getUpdate_at())
                .build();

        return attentionDao.save(attention);
    }

    @Transactional(readOnly = true)
    @Override
    public Attention findById(Integer id) {
        return attentionDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Attention attention) {
        attentionDao.delete(attention);
    }

    @Override
    public boolean existeById(Integer id) {
        return attentionDao.existsById(id);
    }
}
