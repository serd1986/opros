package com.processdev.forms;

import com.processdev.model.*;

import java.util.Date;

public class OtvetForms {
    private Integer id;
    private Pol pol;
    private AgeD ageD;
    private Rayon rayon;
    private Vopros_4 vopros_4;
    private Vopros_5 vopros_5;
    private Vopros_6 vopros_6;
    private Date dt_otvet;
    private String ip;

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

    public AgeD getAgeD() {
        return ageD;
    }

    public void setAgeD(AgeD ageD) {
        this.ageD = ageD;
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
