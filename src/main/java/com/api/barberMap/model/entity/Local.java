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
@Table(name = "locals")
public class Local implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer idLocal;

    @Column(name = "nombre")
    public String nombre;

    @Column(name = "estado")
    public String estado;

    @Column(name = "municipio")
    public String municipio;

    @Column(name = "calle")
    public String calle;

    @Column(name = "ubicacion")
    public String ubicacion;

    @Column(name = "logo")
    public String logo;

    @Column(name = "status")
    public Integer status;

    @Column(name = "created_at")
    public Timestamp created_at;

    @Column(name = "updated_at")
    public Timestamp updated_at;

//    @OneToMany(mappedBy = "locals", fetch = FetchType.LAZY)
//    private List<Attention> atenciones;

//    @OneToMany(mappedBy = "locals", cascade = CascadeType.ALL)
//    private Set<Attention> attentions = new HashSet<>();
//
//    public void setAttention(Set<Attention> attentions){
//        this.attentions = attentions;
//        for(Attention attention : attentions){
//            attention.setLocal(this);
//        }
//    }

}
