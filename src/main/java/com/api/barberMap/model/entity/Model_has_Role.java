package com.api.barberMap.model.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "model_has_roles")
public class Model_has_Role implements Serializable {

    
    @Column(name = "role_id")
    private Integer role_id;

    @Column(name = "model_type")
    private String model_type;

    @Id
    @Column(name = "model_id")
    private Integer model_id;
}
