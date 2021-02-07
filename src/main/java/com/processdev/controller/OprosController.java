package com.processdev.controller;

import com.processdev.entity.Otvet;
import com.processdev.forms.OtvetForms;
import com.processdev.model.*;
import com.processdev.service.api.OtvetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
public class OprosController {

    @Autowired
    private OtvetService otvetService;

    @RequestMapping("/")
    public String home(Model model) {
        OtvetForms otvetForms = new OtvetForms();
        model.addAttribute("otvetForms", otvetForms);
        return "opros";
    }

    @RequestMapping(value = "/opros", method = RequestMethod.GET)
    public String opros(Model model, HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
//        for (Cookie cookie:cookies){
//          if(cookie.getName().equals("otvet")){
//              model.addAttribute("okMessage", "Спасибо за Ваше мнение.");
//              return "otvetCooki";
//          }
//        }
        OtvetForms otvetForms = new OtvetForms();
        model.addAttribute("otvetForms", otvetForms);
        return "opros";
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/opros", method= RequestMethod.POST)
    public String materialpersonalAddSofa(@ModelAttribute("OtvetForms") OtvetForms otvetForms, Model model, HttpServletResponse response, HttpServletRequest request) {
         Pol pol           =otvetForms.getPol();
         AgeD ageD         =otvetForms.getAgeD();
         Rayon rayon       =otvetForms.getRayon();
         Vopros_4 vopros_4 =otvetForms.getVopros_4();
         Vopros_5 vopros_5 =otvetForms.getVopros_5();
         Vopros_6 vopros_6 =otvetForms.getVopros_6();
         String ipAddr     =request.getRemoteAddr();
        if (pol != null
          &&ageD != null
          &&rayon != null
          &&vopros_4 != null
          &&vopros_5 != null
          &&vopros_6 != null) {

            Otvet otvet = new Otvet(pol, ageD, rayon, vopros_4, vopros_5, vopros_6);
                  otvet.setDt_otvet(new Date());
                  otvet.setIp(ipAddr);
                  otvetService.addOtvet(otvet);
//nnn
//            model.addAttribute("otvetForms", otvetForms);

            model.addAttribute("otvetForms", new OtvetForms());
            model.addAttribute("okMessage", "Спасибо за Ваше мнение.");

//            Cookie cookie= new Cookie("otvet", "true");
//            response.addCookie(cookie);
        } else {
            model.addAttribute("otvetForms", otvetForms);
            model.addAttribute("errorMessage", "Пожалуста, заполните все поля анкеты!");
        }
        return "opros";
    }


    @RequestMapping(value = "/rezult", method = RequestMethod.GET)
    public String result( Model model){
        model.addAttribute("otvetForms", new OtvetForms());
        return "rezult_2";
    }

    //@PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/rezult", method= RequestMethod.POST)
    public String result(@ModelAttribute("OtvetForms") OtvetForms otvetForms, Model model) {

        Rayon rayon =  otvetForms.getRayon();

        List<Otvet> otvets = otvetService.getRayonOtvet(rayon);
        otvetService.addZnHash(rayon);

        model.addAttribute("otvetForms", otvetForms);
        model.addAttribute("otvets", otvets);

        model.addAttribute("hashSumAge", otvetService.hashSumAge());
        model.addAttribute("hashSumPol", otvetService.hashSumPol());
        model.addAttribute("hashSumVopros4", otvetService.hashSumVopros4());
        model.addAttribute("hashSumVopros5", otvetService.hashSumVopros5());
        model.addAttribute("hashSumVopros6", otvetService.hashSumVopros6());

        model.addAttribute("hashProcAge", otvetService.hashProcAge());
        model.addAttribute("hashProcPol", otvetService.hashProcPol());
        model.addAttribute("hashProcVopros4", otvetService.hashProcVopros4());
        model.addAttribute("hashProcVopros5", otvetService.hashProcVopros5());
        model.addAttribute("hashProcVopros6", otvetService.hashProcVopros6());

        return "rezult_2";
    }
    @RequestMapping(value = "/allOtvet", method = RequestMethod.GET)
    public String allOtvet( Model model){
        model.addAttribute("otvetForms", new OtvetForms());
        return "all_otvet";
    }
}