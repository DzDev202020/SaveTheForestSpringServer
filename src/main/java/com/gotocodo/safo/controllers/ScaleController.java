package com.gotocodo.safo.controllers;

import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Post;
import model.Scale;
import repository.ScaleRepository;
import util.MyTime;


@RestController
public class ScaleController {
	
	ScaleRepository scaleRepository;
	
	public ScaleController() {
		scaleRepository = new ScaleRepository();
	}
	
	
	@RequestMapping(value = "/scale", method = RequestMethod.POST)
	   public ResponseEntity<Scale> createPost(@RequestBody Scale scale) {
		
		System.out.println("");
		System.out.println("");
		System.out.println("create");
		scale.setConfirmedAt(new Date( MyTime.getTime()));
		
		Scale result= scaleRepository.create(scale);
		System.out.println("");
		System.out.println("");
		System.out.println("result");
		if(result != null)
	      return new ResponseEntity<>(result, HttpStatus.OK);
		else
		      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	   }
	
	

}
