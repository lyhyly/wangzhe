package com.inorise.daoDemo.com.inorise.daoDemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.inorise.daoDemo.com.inorise.daoDemo.domain.Film;

public interface FilmDao extends JpaRepository<Film,Long>,JpaSpecificationExecutor<Film> {

}
