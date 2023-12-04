package repository;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;




import model.Client;

public class ClientRepository implements DAO<Client> {
static final
List<Client> clients = new ArrayList<>();

	public ClientRepository() {
	Client client=new Client();
	client.setId(1);
	client.setEmail("MyEmail@gmail.com");
	client.setPassword("Password123");
	client.setFirstName("MyName");
	client.setLastName("MyLastName");
	client.setPhonenumber("123456789");
	client.setReputation(0);
	client.setDate(new Date(931557600000L));
	clients.add(client);
	}

	@Override
	public Client create(Client obj) {
		clients.add(obj);
		return obj;
		
	}

	@Override
	public boolean delete(Client obj) {
		for(int i = 0 ; i < clients.size();i++){
			if(clients.get(i).getId()== obj.getId())
			{
				clients.remove(i);
				return true;
			}
		}

		return false;
	}

	@Override
	public Client update(Client obj) {
		for(int i = 0 ; i < clients.size();i++){
			if(clients.get(i).getId()== obj.getId())
			{
				clients.remove(i);
				clients.add(obj);
				return obj;
			}
		}

		return null;
	}

	@Override
	public Client find(String id) {
		for(int i = 0 ; i < clients.size();i++){
			if(clients.get(i).getId()+""== id)
			{
		
				return clients.get(i);
			}
		}
return null;

	}

	public List<Client> findAll() {
		return clients;

	}

	public Client userSignIn(String email, String password) {

		for(int i = 0 ; i < clients.size();i++){
			if(clients.get(i).getEmail().equals(email)  && clients.get(i).getPassword().equals(password))
			{
				return clients.get(i);
			}
		}
		return null;
	}

}
