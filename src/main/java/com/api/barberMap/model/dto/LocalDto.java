package com.api.barberMap.model.dto;

import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

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
}
