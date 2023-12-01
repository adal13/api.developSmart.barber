package com.api.barberMap.model.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Model_has_RoleDto implements Serializable{
    private Integer role_id;
    private String model_type;
    private Integer model_id;
}
