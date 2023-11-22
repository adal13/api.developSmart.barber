package com.api.barberMap.model.entity;

import java.io.Serializable;
import java.security.Timestamp;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "locals_user")
public class LocalUser implements Serializable{
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idLocalUser;

    //@Column(name = "user_id")
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User user_id;

    //@Column(name = "locals_id")
    @ManyToOne
    @JoinColumn(name = "locals_id", referencedColumnName = "id")
    public Local locals_id;

    //@Column(name = "id_user_register")
    @ManyToOne
    @JoinColumn(name = "id_user_register", referencedColumnName = "id")
    public User id_user_register;
    
    @Column(name = "created_at")
    public Timestamp created_at;

    @Column(name = "updated_at")
    public Timestamp updated_at;
}
