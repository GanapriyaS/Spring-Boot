package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//prototpe not provide object not before , it provide when requested
//Autowire search by type and qualifier search by name

@Component
@Scope(value="prototype")
public class Alien {
	private int aid;
	private String aname;
	private String tech;
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public Alien() {
		super();
		System.out.println("Object Created");
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	
	@Autowired
	@Qualifier("laptop")
	private Laptop lap;
	public void show() {
		System.out.println("Hello");
		lap.compile();
	}

}
