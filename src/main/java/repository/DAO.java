package repository;

import java.util.List;

public interface DAO<T> {
	
	T create(T t);
	
	boolean delete (T t);
	
	T update(T t);
	
	T find(String id);

	List<T>findAll();

}
