package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.AlienRepo;
import com.example.demo.dao.AlienRepo1;
import com.example.demo.model.Alein;

//@RestController => then no need of @ResponseBody 
@Controller
public class alienController {
	@Autowired
	AlienRepo repo;
	
	@Autowired
	AlienRepo1 repo1;
	
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	
	@RequestMapping("/addAlien")
	public String addAlien(Alein alien) {
		repo.save(alien);
		return "home.jsp";
	}
	
	@RequestMapping("/getAlien")
	public ModelAndView addAlien(@RequestParam int aid) {
		ModelAndView mv= new ModelAndView("show.jsp");
		Alein alein= repo.findById(aid).orElse(new Alein());
		mv.addObject(alein);
		return mv;
	}
	
	@RequestMapping("/getAlienName")
	public ModelAndView getAlien(@RequestParam String aname) {
		ModelAndView mv= new ModelAndView("show.jsp");
		System.out.println(repo.findByAname("her"));
		System.out.println(repo.findByAidGreaterThan(2));
		System.out.println(repo.findByAnameSorted("her"));
		return mv;
	}
	
	@RequestMapping("/aliens")
	@ResponseBody
	public String getAliens() {
		return repo.findAll().toString();
	}
	
	@PostMapping(path="/addAlien1",consumes= {"application/json"})
	public Alein addAlien1(@RequestBody Alein alien) {
		repo.save(alien);
		return alien;
	}
	
	@PutMapping(path="/addAlien1",consumes= {"application/json"})
	public Alein saveOrUpdateAlien(@RequestBody Alein alien) {
		repo.save(alien);
		return alien;
	}
	
	@DeleteMapping("/alien/{aid}")
	public String deleteAlien(@PathVariable int aid) {
		Alein a = repo1.getOne(aid);
		repo.delete(a);
		return "deleted";
	}
	
	@GetMapping("/alien/{aid}")
	@ResponseBody
	public String getAliens(@PathVariable int aid) {
		return repo.findById(aid).toString();
	}
	
	@RequestMapping(path="/aliens1",produces={"application/xml"})
	@ResponseBody
	public List<Alein> getAliens1() {
		return repo1.findAll();
	}
	
	@RequestMapping("/alien1/{aid}")
	@ResponseBody
	public Optional<Alein> getAliens1(@PathVariable int aid) {
		return repo1.findById(aid);
	}
}
