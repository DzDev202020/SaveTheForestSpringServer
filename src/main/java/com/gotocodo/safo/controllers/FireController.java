package com.gotocodo.safo.controllers;

import java.sql.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;

import model.Client;
import model.Fire;
import model.FireList;
import repository.FireRepository;
import util.MyTime;

@RestController
public class FireController {

	FireRepository fireRepository;

	public FireController() {
		fireRepository = new FireRepository();
	}

	@RequestMapping(value = "/fire", method = RequestMethod.POST)
	public ResponseEntity<Object> createFire(@RequestBody Fire fire) {

		fire.setCreatedDate(new Date(MyTime.getTime()));

		Fire result = fireRepository.create(fire);

		if (result != null) {

			System.out.println("result != null :" + result != null);
			System.out.println("result != null :" + result != null);
			System.out.println("result != null :" + result != null);

			return new ResponseEntity<>(result, HttpStatus.CREATED);
		} else
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	}

	@RequestMapping(value = "/fire")
	public ResponseEntity<FireList> getFires() {
		FireList fireList = new FireList();
		fireList.setFireList(fireRepository.findAll());

		if (fireList.getFireList() != null) {
			return new ResponseEntity<>(fireList, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);

		}

	}

//	@RequestMapping(value = "/fire")
//	public ResponseEntity<FireList> getFires() {
//		Gson gson=  new GsonBuilder()
//                .setDateFormat("yyyy-MM-dd")
//                .create();
//		
//		FireList fireList = new FireList();
//		fireList.setFireList(fireRepository.findAll());
//		
//		if(fireList.getFireList()!=null) {
//			return  new ResponseEntity<>(fireList, HttpStatus.OK);
//		}
//		else {
//			return  new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
//
//		}
//		
//	}

//	@RequestMapping(value = "/fire")
//	public ResponseEntity<String> getFires() {
//		Gson gson=  new GsonBuilder()
//                .setDateFormat("yyyy-MM-dd")
//                .create();
//		
//		FireList fireList = new FireList();
//		fireList.setFireList(fireRepository.findAll());
//		
//		if(fireList.getFireList()!=null) {
//			return  new ResponseEntity<>(gson.toJson(fireList), HttpStatus.OK);
//		}
//		else {
//			return  new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
//
//		}
//		
//	}

	@RequestMapping(value = "/fire/{id}")
	public ResponseEntity<Fire> getFire(@PathVariable("id") String id) {
		Fire fire = fireRepository.find(id);
		if (fire != null) {
			return new ResponseEntity(fire, HttpStatus.OK);
		} else {
			return new ResponseEntity(null, HttpStatus.EXPECTATION_FAILED);
		}

	}
}
