package com.api.barberMap.model.dto;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

import com.api.barberMap.model.entity.Local;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class LocalDto implements Serializable {
    public Integer idLocal;
    public String nombre;
    public String estado;
    public String municipio;
    public String calle;
    public String ubicacion;
    public String logo;
    public Integer status;
    public Timestamp created_at;
    public Timestamp updated_at;

    public static LocalDto fromLocal(Local locals) {
        return LocalDto.builder()
                .idLocal(locals.getIdLocal())
                .nombre(locals.getNombre())
                .estado(locals.getEstado())
                .municipio(locals.getMunicipio())
                .calle(locals.getCalle())
                .ubicacion(locals.getUbicacion())
                .logo(locals.getLogo())
                .status(locals.getStatus())
                .created_at(locals.getCreated_at())
                .updated_at(locals.getUpdated_at())
                .build();
    }
}