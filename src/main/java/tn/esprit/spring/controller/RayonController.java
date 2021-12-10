package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.service.RayonServiceImpl;
import tn.esprit.spring.service.StockService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.service.RayonServiceImpl;

@RestController
@RequestMapping("/rayon")
public class RayonController {
	
	
	@Autowired
	RayonServiceImpl servicerayon;
	
	@CrossOrigin(origins = "http://localhost:4200")
	// http://localhost:8089/SpringMVC/client/retrieve-all-rayon
	@GetMapping("/retrieve-all-rayon")
	@ResponseBody
	public List<Rayon>getRayon() {
	List<Rayon> listrayons = servicerayon.retrieveAllRayons();
	return listrayons;
	}

	@CrossOrigin(origins = "http://localhost:4200")
	//http://localhost:8089/SpringMVC/rayon/retrieve-rayon/8
	@GetMapping("/retrieve-rayon/{rayon-id}")
	@ResponseBody
	public Rayon retrieveStock(@PathVariable("rayon-id") Long rayonId) {
	return servicerayon.retrieveRayon(rayonId);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	// http://localhost:8089/SpringMVC/rayon/add-rayon
	@PostMapping("/add-rayon")
	@ResponseBody
	public Rayon addRayon(@RequestBody Rayon c3)
	{
		Rayon rayonn = servicerayon.addRayon(c3);
	return rayonn;
	}


	@CrossOrigin(origins = "http://localhost:4200")
	//http://localhost:8089/SpringMVC/rayon/remove-rayon/{rayon-id}
	@DeleteMapping("/remove-rayon/{rayon-id}")
	@ResponseBody
	public void removeRayon(@PathVariable("rayon-id") Long rayonId) {
		servicerayon.deleteRayon(rayonId);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	//http://localhost:8089/SpringMVC/rayon/modify-rayon
	@PutMapping("/modify-rayon")
	@ResponseBody
	public Rayon modifyrayon(@RequestBody Rayon rayon) {
	return servicerayon.updateRayon(rayon);
	}

}