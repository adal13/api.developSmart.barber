package com.api.barberMap.model.dto;

import java.io.Serializable;
import java.security.Timestamp;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class LocalUserDto implements Serializable{
    

    public Integer idLocalUser;

    private UserDto user_id = new UserDto();
    private LocalDto locals_id = new LocalDto();
    private UserDto id_user_register = new UserDto();

    //public Integer user_id;
    //public Integer locals_id;
    //public Integer id_user_register;
    public Timestamp created_at;
    public Timestamp updated_at;
}
