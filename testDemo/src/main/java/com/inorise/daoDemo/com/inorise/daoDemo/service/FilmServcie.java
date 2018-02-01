package com.inorise.daoDemo.com.inorise.daoDemo.service;

import com.inorise.daoDemo.com.inorise.daoDemo.dao.FilmDao;
import com.inorise.daoDemo.com.inorise.daoDemo.domain.Film;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
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
