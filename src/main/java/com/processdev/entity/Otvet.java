package com.processdev.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.processdev.model.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "OTVET")
public class Otvet {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private Pol pol;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private AgeD aged;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private Rayon rayon;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private Vopros_4 vopros_4;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private Vopros_5 vopros_5;

    @NotNull
    @Enumerated(EnumType.ORDINAL)
    private Vopros_6 vopros_6;

    @Column(name = "DT_OTVET")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd",timezone = "Asia/Calcutta")
    private Date dt_otvet;

    @Column(name = "IP")
    private String ip;

    public Otvet() {
    }

    public Otvet(Pol pol, AgeD aged, Rayon rayon, Vopros_4 vopros_4, Vopros_5 vopros_5, Vopros_6 vopros_6) {
        this.pol = pol;
        this.aged = aged;
        this.rayon = rayon;
        this.vopros_4 = vopros_4;
        this.vopros_5 = vopros_5;
        this.vopros_6 = vopros_6;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pol getPol() {
        return pol;
    }

    public void setPol(Pol pol) {
        this.pol = pol;
    }

    public AgeD getAged() {
        return aged;
    }

    public void setAged(AgeD aged) {
        this.aged = aged;
    }

    public Rayon getRayon() {
        return rayon;
    }

    public void setRayon(Rayon rayon) {
        this.rayon = rayon;
    }

    public Vopros_4 getVopros_4() {
        return vopros_4;
    }

    public void setVopros_4(Vopros_4 vopros_4) {
        this.vopros_4 = vopros_4;
    }

    public Vopros_5 getVopros_5() {
        return vopros_5;
    }

    public void setVopros_5(Vopros_5 vopros_5) {
        this.vopros_5 = vopros_5;
    }

    public Vopros_6 getVopros_6() {
        return vopros_6;
    }

    public void setVopros_6(Vopros_6 vopros_6) {
        this.vopros_6 = vopros_6;
    }

    public Date getDt_otvet() {
        return dt_otvet;
    }

    public void setDt_otvet(Date dt_otvet) {
        this.dt_otvet = dt_otvet;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
