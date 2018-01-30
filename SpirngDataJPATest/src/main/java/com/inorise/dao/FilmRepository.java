package com.inorise.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

import com.inorise.domain.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {
                                         
}
