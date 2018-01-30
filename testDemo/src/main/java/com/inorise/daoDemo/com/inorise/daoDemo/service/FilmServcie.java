package com.inorise.daoDemo.com.inorise.daoDemo.service;

import com.inorise.daoDemo.com.inorise.daoDemo.dao.FilmDao;
import com.inorise.daoDemo.com.inorise.daoDemo.domain.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FilmServcie {

    @Autowired
    private FilmDao filmDao;

    public Film findOne(Long id){
        Film film = filmDao.findOne(id);
        return film;
    }

}
