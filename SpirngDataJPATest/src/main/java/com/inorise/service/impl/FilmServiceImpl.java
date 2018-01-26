package com.inorise.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inorise.dao.FilmRepository;
import com.inorise.domain.Film;
import com.inorise.service.FilmService;

@Service("filmService")
public class FilmServiceImpl implements FilmService{
	
	@Autowired
	private FilmRepository filmRepository;

	@Override
	public void test1() {
		System.out.println("test成功");
	}

	@Override
	public void addFilm() {
		Film findById = filmRepository.findOne((short)1);
		System.out.println(findById);
	}

}
