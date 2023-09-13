package com.api.barberMap.service;

import com.api.barberMap.model.dto.AttentionDto;
import com.api.barberMap.model.entity.Attention;

public interface IAttentionService {
    Iterable<Attention> listAll();
    Attention save(AttentionDto attention);
    Attention findById(Integer id);
    void delete(Attention attention);
    boolean existeById(Integer id);
}
