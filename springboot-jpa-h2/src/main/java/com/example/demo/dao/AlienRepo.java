package com.example.demo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Alein;

import java.util.*;

public interface AlienRepo extends CrudRepository<Alein,Integer> {
	List<Alein> findByAname(String name);
	List<Alein> findByAidGreaterThan(int aid);
	
	@Query("from Alein where aname=?1 order by aname")
	List<Alein> findByAnameSorted(String name);
}
