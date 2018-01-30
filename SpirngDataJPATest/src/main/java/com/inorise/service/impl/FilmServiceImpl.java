package com.inorise.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

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
		Film film = filmRepository.findOne(1l);
		int year = 1900;
		Random random = new Random();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(new File("C:\\Users\\Sun\\Desktop\\1.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		char[] arr = new char[10];
		for(int i = 18328 ; i< 1000000;i++) {
			//正态分布数
			double sqrt = Math.sqrt(0.2);
			sqrt = sqrt*40;
			year = (int) (sqrt*random.nextGaussian())+1950;
			while(year<1901||year>1999) {
				year = (int) (sqrt*random.nextGaussian())+1950;
			}
			//读取字符
			try {
				if(!br.ready()) {
					br = new BufferedReader(new FileReader(new File("C:\\Users\\Sun\\Desktop\\1.txt")));
				}
				br.read(arr);
				film.setDescription(Arrays.toString(arr));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//year符合正态分布
			film.setReleaseYear(String.valueOf(year));
			//length符合线性分布
			film.setLength((short) (i/10000));
			//将id设为null
			film.setFilmId(null);
			//存储film
			try {
				filmRepository.save(film);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("出异常啦，year为:"+film.getReleaseYear());
				i--;
			}
		}
	}

	@Override
	public void delete() {
		for(int i = 1001;i<10000;i++) {
			filmRepository.delete((long) i);;
		}
	}
	

}
