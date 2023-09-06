package com.api.barberMap.model.dto;
import jakarta.persistence.Column;
import lombok.*;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class UserDto implements Serializable {
    private Integer idUser;
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private String nombreUsuario;
    private String contrasena;
    private Timestamp emailVerified;
    private String rememberToken;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}
