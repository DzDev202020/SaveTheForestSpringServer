package com.gotocodo.safo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import model.Client;
import repository.ClientRepository;

@RestController
public class ClientController {

	ClientRepository clientRepository;

	public ClientController() {
		clientRepository = new ClientRepository();
	}

//	@RequestMapping(value = "/users")
//	public String getUsers() {
//		return "All users";
//	}

//	@RequestMapping(value = "/clients")
//	public ResponseEntity<Client> getUsers() {
//		return new ResponseEntity<Client>(
//				new Client(null, "ayoub", "khalfaoui", "ayoub@gmail.com", "123456789", 674372368, null, 0),
//				HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/client")
//	public ResponseEntity<Client> getClient(
//			@Param("email") String email,
//			@Param("password") String password) {
//		
//		System.out.println("To email:" + email);
//		System.out.println("To password:" + password);
//
//		
//		if (email.equals("@gmail.com") && password.equals("****"))
//			return new ResponseEntity<Client>(
//					new Client("1", "ayoub", "khaaoui", "@gmail.com", "****", 674372368, null, 5), HttpStatus.OK);
//		else
//			return new ResponseEntity<Client>(new Client(), HttpStatus.OK);
//	}
//
//	@RequestMapping(value = "/client", method = RequestMethod.POST)
//	public ResponseEntity<Object> postUser(@RequestBody Client client) {
//		 if(client!=null){
//             System.out.println("client.getFirstName= "+client.getFirstName());
//             System.out.println("client.getLastName= "+client.getLastName());
//             System.out.println("client.getEmailName= "+client.getEmail());
//             System.out.println("client.getPassword= "+client.getPassword());
//             System.out.println("client.getReputation= "+client.getReputation());
//             
//    		 return new ResponseEntity<>(client, HttpStatus.CREATED);
//
//         }
//         else{
//             System.out.println("Client Null");
//    		 return new ResponseEntity<>("client is null", HttpStatus.BAD_REQUEST);
//
//         }
//	}

	@RequestMapping(value = "/client")
	public ResponseEntity<Client> userSignIn(@RequestParam ("email") String email, @RequestParam ("password") String password) {
		System.out.println("userSignIn : " + email + " " + password);

		Client result = clientRepository.userSignIn(email, password);
		if (result != null) {
			return new ResponseEntity<Client>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<Client>(result, HttpStatus.NOT_FOUND);

		}
	}

	@RequestMapping(value = "/client", method = RequestMethod.POST)
	public ResponseEntity<Object> createClient(@RequestBody Client client) {

		if (client != null) {
			System.out.println("client.getFirstName= " + client.getFirstName());
			System.out.println("client.getLastName= " + client.getLastName());
			System.out.println("client.getEmailName= " + client.getEmail());
			System.out.println("client.getPassword= " + client.getPassword());
			System.out.println("client.getReputation= " + client.getReputation());
//			client.setId("0");
			client.setReputation(5);

		} else {
			System.out.println("Client Null");
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}

		Client result = clientRepository.create(client);
		if (result != null)
			return new ResponseEntity<>(result, HttpStatus.CREATED);
		else
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	}

}
