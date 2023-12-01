package com.api.barberMap.model.entity;

import jakarta.persistence.*;
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
@Entity
@Table(name = "citas")
public class Cita implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCitas;

    @Column(name = "hora")
    private Time hora;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "barber_id")  // Cambiado a aceptar directamente el ID
    private Integer barber_id;

    @Column(name = "service_id")  // Cambiado a aceptar directamente el ID
    private Integer service_id;

    @Column(name = "user_id")  // Cambiado a aceptar directamente el ID
    private Integer user_id;

    @Column(name = "status")
    private Integer status;

    @Column(name = "created_at")
    private Timestamp created_at;

    @Column(name = "updated_at")
    private Timestamp updated_at;

}
