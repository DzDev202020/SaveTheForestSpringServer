package repository;

import java.util.ArrayList;
import java.util.List;




import model.Fire;

public class FireRepository implements DAO<Fire> {
static final
	List<Fire> fires = new ArrayList<>();


	public FireRepository() {
	
	}
	@Override
	public Fire create(Fire obj) {

		fires.add(obj);
		return obj;
	}

	@Override
	public boolean delete(Fire obj) {
		for(int i = 0 ; i < fires.size();i++){
			if(fires.get(i).getId()== obj.getId())
			{
				fires.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public Fire update(Fire obj) {
		for(int i = 0 ; i < fires.size();i++){
			if(fires.get(i).getId()== obj.getId())
			{
				fires.remove(i);
				fires.add(obj);
				return obj;
			}
		}

		return null;
	}

	@Override
	public Fire find(String id) {
		for(int i = 0 ; i < fires.size();i++){
			if(fires.get(i).getId()+""== id)
			{
		
				return fires.get(i);
			}
		}
return null;
	}

	public List<Fire> findAll() {


		return fires;
	}

}
