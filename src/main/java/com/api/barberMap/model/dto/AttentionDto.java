package com.api.barberMap.model.dto;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class AttentionDto implements Serializable {
    private Integer idServices;
    private String nombre;
    private Double precio;
    private Double duracion;
    private String imagen;
    private Integer locals_id;
    private Timestamp created_at;
    private Timestamp update_at;
}
