package com.api.barberMap.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "users")
public class User implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUser;

    @Column(name = "name")
    private String nombre;

    @Column(name = "last_name")
    private String apellido;

    @Column(name = "phone")
    private String telefono;

    @Column(name = "email")
    private String correo;

    @Column(name = "user_name")
    private String nombreUsuario;

    @Column(name = "password")
    private String contrasena;

    @Column(name = "email_verified_at")
    private Timestamp emailVerified;

    @Column(name = "remember_token")
    private String rememberToken;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "updated_at")
    private Timestamp updatedAt;
}
