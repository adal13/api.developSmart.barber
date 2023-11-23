package com.api.barberMap.model.dto;
import lombok.*;

import java.io.Serializable;
import java.sql.Timestamp;

import com.api.barberMap.model.entity.User;
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
    private String avatar;
    private Timestamp emailVerified;
    private String rememberToken;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public static UserDto fromUser (User user) {
        if (user == null) {
            throw new IllegalArgumentException("Local cannot be null");
        }

        return UserDto.builder()
                .idUser(user.getIdUser())
                .nombre(user.getNombre())
                .apellido(user.getApellido())
                .telefono(user.getTelefono())
                .correo(user.getCorreo())
                .nombreUsuario(user.getNombreUsuario())
                .contrasena(user.getContrasena())
                .avatar(user.getAvatar())
                .emailVerified(user.getEmailVerified())
                .rememberToken(user.getRememberToken())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                // Agrega otros campos según sea necesario
                .build();
    }
}
