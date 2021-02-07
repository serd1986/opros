package com.processdev.service.impl;

import com.processdev.entity.Otvet;
import com.processdev.model.*;
import com.processdev.repository.OtvetRepositoryJpa;
import com.processdev.service.api.OtvetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class OtvetServiceImpl implements OtvetService {
    /**инжектим
     * */
    @Autowired
    private OtvetRepositoryJpa otvetRepositoryJpa;

    HashMap<AgeD, Integer> hashSumAge;
    HashMap<Pol, Integer> hashSumPol;
    HashMap<Vopros_4, Integer> hashSumVopros4;
    HashMap<Vopros_5, Integer> hashSumVopros5;
    HashMap<Vopros_6, Integer> hashSumVopros6;

    HashMap<AgeD, Integer> hashProcAge;
    HashMap<Pol, Integer> hashProcPol;
    HashMap<Vopros_4, Integer> hashProcVopros4;
    HashMap<Vopros_5, Integer> hashProcVopros5;
    HashMap<Vopros_6, Integer> hashProcVopros6;

    public OtvetServiceImpl(OtvetRepositoryJpa otvetRepositoryJpa) {
        this.otvetRepositoryJpa = this.otvetRepositoryJpa;
    }

    @Override
    public Otvet getOtvetById(Integer id) {
        return otvetRepositoryJpa.getById(id);
    }

    @Override
    public List<Otvet> getRayonOtvet(Rayon rayon) {
        return  otvetRepositoryJpa.getByRayon(rayon);
    }

    @Override
    public Otvet addOtvet(Otvet otvet) {
        return otvetRepositoryJpa.save(otvet);
    }

    @Override
    public Otvet updateOtvet(Otvet otvet) {
        return otvetRepositoryJpa.save(otvet);
    }

    @Override
    public void deleteOtvetById(Integer id) {
        otvetRepositoryJpa.delete(id);
    }

    @Override
    public void deleteOtvet(Otvet otvet) { otvetRepositoryJpa.delete(otvet); }

    @Override
    public List<Otvet> getAllOtvet() {
        return otvetRepositoryJpa.findAll();
    }

    @Override
    public HashMap<AgeD, Integer> hashSumAge() {
        return hashSumAge;
    }

    @Override
    public HashMap<Pol, Integer> hashSumPol() {
        return hashSumPol;
    }

    @Override
    public HashMap<Vopros_4, Integer> hashSumVopros4() {
        return hashSumVopros4;
    }

    @Override
    public HashMap<Vopros_5, Integer> hashSumVopros5() {
        return hashSumVopros5;
    }

    @Override
    public HashMap<Vopros_6, Integer> hashSumVopros6() {
        return hashSumVopros6;
    }

    @Override
    public HashMap<AgeD, Integer> hashProcAge() {
        return hashProcAge;
    }

    @Override
    public HashMap<Pol, Integer> hashProcPol() {
        return hashProcPol;
    }

    @Override
    public HashMap<Vopros_4, Integer> hashProcVopros4() {
        return hashProcVopros4;
    }

    @Override
    public HashMap<Vopros_5, Integer> hashProcVopros5() {
        return hashProcVopros5;
    }

    @Override
    public HashMap<Vopros_6, Integer> hashProcVopros6() {
        return hashProcVopros6;
    }

    @Override
    public void addZnHash(Rayon rayon){

         hashSumAge = new HashMap<>();
         hashSumPol = new HashMap<>();
         hashSumVopros4 = new HashMap<>();
         hashSumVopros5 = new HashMap<>();
         hashSumVopros6 = new HashMap<>();

         hashProcAge = new HashMap<>();
         hashProcPol = new HashMap<>();
         hashProcVopros4 = new HashMap<>();
         hashProcVopros5 = new HashMap<>();
         hashProcVopros6 = new HashMap<>();

        for (Otvet otvet: this.getRayonOtvet(rayon)){
            AgeD     ageD_     = otvet.getAged();
            Pol      pol_      = otvet.getPol();
            Vopros_4 vopros_4_ = otvet.getVopros_4();
            Vopros_5 vopros_5_ = otvet.getVopros_5();
            Vopros_6 vopros_6_ = otvet.getVopros_6();

            hashSumAge.put(ageD_, hashSumAge.keySet().contains(ageD_) ? hashSumAge.get(ageD_)+ 1: 1);
            hashSumPol.put(pol_, (hashSumPol.keySet().contains(pol_)) ? hashSumPol.get(pol_)+1 : 1);
            hashSumVopros4.put(vopros_4_, (hashSumVopros4.keySet().contains(vopros_4_)) ? hashSumVopros4.get(vopros_4_)+1 : 1);
            hashSumVopros5.put(vopros_5_, (hashSumVopros5.keySet().contains(vopros_5_)) ? hashSumVopros5.get(vopros_5_)+1 : 1);
            hashSumVopros6.put(vopros_6_, (hashSumVopros6.keySet().contains(vopros_6_)) ? hashSumVopros6.get(vopros_6_)+1 : 1);

                    }

              for (AgeD ageD : hashSumAge().keySet()){
                   Integer sum = hashSumAge().get(ageD);
                   hashProcAge.put(ageD, sum*100/allSum(hashSumAge()));
              }

              for (Pol pol : hashSumPol().keySet()){
                  Integer sum = hashSumPol().get(pol);
                  hashProcPol.put(pol, sum*100/allSum(hashSumPol()));
              }

              for (Vopros_4 vopros_4 : hashSumVopros4().keySet()){
                  Integer sum = hashSumVopros4().get(vopros_4);
                  hashProcVopros4.put(vopros_4, sum*100/allSum(hashSumVopros4()));
              }
              for (Vopros_5 vopros_5 : hashSumVopros5().keySet()){
                  Integer sum = hashSumVopros5().get(vopros_5);
                  hashProcVopros5.put(vopros_5, sum*100/allSum(hashSumVopros5()));
              }
              for (Vopros_6 vopros_6 : hashSumVopros6().keySet()){
                  Integer sum = hashSumVopros6().get(vopros_6);
                  hashProcVopros6.put(vopros_6, sum*100/allSum(hashSumVopros6()));
              }
        }
    public Integer allSum(HashMap<?,Integer> hashSum){
        Integer allSum = 0;
        for(Integer integer : hashSum.values()){
            allSum+=integer;
        }
        return allSum;
    }
}