package com.inorise.daoDemo.com.inorise.daoDemo.dao;

import com.inorise.daoDemo.com.inorise.daoDemo.domain.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FilmDao extends JpaRepository<Film,Long> {

}
