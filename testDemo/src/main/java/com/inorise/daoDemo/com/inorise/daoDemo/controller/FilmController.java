package com.inorise.daoDemo.com.inorise.daoDemo.controller;

import com.inorise.daoDemo.com.inorise.daoDemo.dao.FilmDao;
import com.inorise.daoDemo.com.inorise.daoDemo.domain.Film;
import com.inorise.daoDemo.com.inorise.daoDemo.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/film")
public class FilmController {

    @Autowired
    private FilmDao filmDao;

    @RequestMapping("/findOne/{id}")
    public Film findOne(@PathVariable(name="id") Long id){
        Film film = filmDao.findOne(id);
        System.out.println(film);
        return film;
    }

    /**
     * 分页查询方法
     * @param page
     * @param rows
     * @return resultJson对象
     */
    @RequestMapping("/pageQuery")
    public Result pageQuery(@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer rows){

        Pageable pageable = new PageRequest(page-1,rows);
        Page<Film> page1 = filmDao.findAll(pageable);
        List<Film> list = page1.getContent();
        long total = page1.getTotalElements();
        Result result = new Result();
        result.setRows(list);
        result.setTotal(total);
        return result;

    }

    /**
     * 保存方法
     * @param film
     */
    @RequestMapping("/save")
    public void save(Film film) {
    	filmDao.save(film);
    }
    
    
    /**
     * 单元测试方法
     * @return
     */
    @RequestMapping("/hello")
    public String helloWorld() {
    	return "Hello World";
    }
    

}
