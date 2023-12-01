package com.api.barberMap.model.dto;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class CitaDto implements Serializable{

        private Integer idCitas;
        private Time hora;
        private Date fecha;
        public Integer barber_id;
        public Integer service_id;
        public Integer user_id;
        private Integer status;
        private Timestamp created_at;
        private Timestamp updated_at;
}
