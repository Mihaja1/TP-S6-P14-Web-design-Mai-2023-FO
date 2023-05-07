package com.project.iacontentfrontoffice.controller;

import com.project.iacontentfrontoffice.dao.HibernateDao;
import com.project.iacontentfrontoffice.model.Admin;
import com.project.iacontentfrontoffice.model.Categorie;
import com.project.iacontentfrontoffice.model.Contenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Controller
public class ContenuController {

    @Autowired
    HibernateDao hibernateDao;

    public HibernateDao getHibernateDao() {
        return hibernateDao;
    }

    public void setHibernateDao(HibernateDao hibernateDao) {
        this.hibernateDao = hibernateDao;
    }

    @GetMapping("/")
    public ModelAndView liste(){
        List<Contenu> contenus = hibernateDao.findAll(Contenu.class);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("contenus", contenus);
        modelAndView.setViewName("ListeContenu");

        return modelAndView;
    }

    @GetMapping("details/{id}")
    public ModelAndView details(@PathVariable Integer id) {
        Contenu contenu = hibernateDao.findById(Contenu.class, id);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("contenu", contenu);
        modelAndView.setViewName("DetailsContent");

        return modelAndView;
    }

}
