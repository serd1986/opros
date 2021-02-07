package com.processdev.service.api;

import com.processdev.entity.Otvet;
import com.processdev.model.*;

import java.util.HashMap;
import java.util.List;

public  interface OtvetService {
    Otvet getOtvetById(Integer id);
    Otvet addOtvet(Otvet otvet);
    Otvet updateOtvet(Otvet otvet);

    void deleteOtvetById(Integer id);
    void deleteOtvet(Otvet otvet);
    List<Otvet> getAllOtvet();
    List<Otvet> getRayonOtvet(Rayon rayon);

    void addZnHash(Rayon rayon);

    HashMap<AgeD, Integer>     hashSumAge();
    HashMap<Pol, Integer>      hashSumPol();
    HashMap<Vopros_4, Integer> hashSumVopros4();
    HashMap<Vopros_5, Integer> hashSumVopros5();
    HashMap<Vopros_6, Integer> hashSumVopros6();

    HashMap<AgeD, Integer>     hashProcAge();
    HashMap<Pol, Integer>      hashProcPol();
    HashMap<Vopros_4, Integer> hashProcVopros4();
    HashMap<Vopros_5, Integer> hashProcVopros5();
    HashMap<Vopros_6, Integer> hashProcVopros6();
}