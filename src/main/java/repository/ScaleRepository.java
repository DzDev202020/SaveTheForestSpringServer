package repository;

import java.util.ArrayList;
import java.util.List;



import model.Scale;

public class ScaleRepository implements DAO<Scale> {


	public ScaleRepository() {

	}


	
	static final List<Scale> scales = new ArrayList<>();

	@Override
	public Scale create(Scale obj) {

scales.add(obj);
		return obj;
	}

	@Override
	public boolean delete(Scale obj) {
		for(int i = 0 ; i < scales.size();i++){
			if(scales.get(i).getId()== obj.getId())
			{
				scales.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public Scale update(Scale obj) {
		for(int i = 0 ; i < scales.size();i++){
			if(scales.get(i).getId()== obj.getId())
			{
				scales.remove(i);
				scales.add(obj);
				return obj;
			}
		}
		return null;
	}

	@Override
	public Scale find(String id) {
		for(int i = 0 ; i < scales.size();i++){
			if(scales.get(i).getId()+""== id)
			{
		
				return scales.get(i);
			}
		}
		return null;
	}

	@Override
	public List<Scale> findAll() {
		return	scales;
	}

}
