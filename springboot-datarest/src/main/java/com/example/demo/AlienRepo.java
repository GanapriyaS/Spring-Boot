package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.model.Alein;

import java.util.*;

@RepositoryRestResource( collectionResourceRel="aliens",path="aliens")
public interface AlienRepo extends JpaRepository<Alein,Integer> {
	
}
