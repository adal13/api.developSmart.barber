package com.api.barberMap.model.dto;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CitaDto implements Serializable{

        private Integer idCitas;
        
        //@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
        private String hora;
        
        private String fecha;
        public Integer barber_id;
        public Integer service_id;
        public Integer user_id;
        private Integer status;
        private Timestamp created_at;
        private Timestamp updated_at;
}
