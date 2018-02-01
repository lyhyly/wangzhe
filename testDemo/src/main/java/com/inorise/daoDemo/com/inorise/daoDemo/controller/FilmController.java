package com.inorise.daoDemo.com.inorise.daoDemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.tomcat.util.codec.binary.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inorise.daoDemo.com.inorise.daoDemo.dao.FilmDao;
import com.inorise.daoDemo.com.inorise.daoDemo.domain.Film;
import com.inorise.daoDemo.com.inorise.daoDemo.domain.PageBean;
import com.inorise.daoDemo.com.inorise.daoDemo.domain.Result;


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
     * 此处使用pageBean，成员属性不能为film对象，无法封装。
     * @param rows
     * @return resultJson对象
     */
    @RequestMapping("/pageQuery")
    public Result pageQuery(final PageBean pageBean){
    	
        Pageable pageable = new PageRequest(pageBean.getPage()-1,pageBean.getRows());
        Specification<Film> spec = new Specification<Film>() {

			@Override
			public Predicate toPredicate(Root<Film> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Long id = pageBean.getFilmId();
				ArrayList<Predicate> list = new ArrayList<Predicate>();
				if(id !=null && !"".equals(id)) {
					list.add(cb.equal(root.get("filmId").as(Long.class), id));
				}
				/*
				 * 此处还有三个查询
				 */
				Predicate[] ps = new Predicate[list.size()];
				return query.where(list.toArray(ps)).getGroupRestriction();
			}
		};
        Page<Film> page1 = filmDao.findAll(spec,pageable);
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
