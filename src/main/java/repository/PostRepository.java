package repository;

import java.util.ArrayList;
import java.util.List;




import model.Post;

public class PostRepository implements DAO<Post> {
	


	static final List<Post> posts = new ArrayList<>();
	public PostRepository() {
	}


	@Override
	public Post create(Post obj) {
		
		posts.add(obj);
		return obj;

	}

	@Override
	public boolean delete(Post obj) {
		for(int i = 0 ; i < posts.size();i++){
			if(posts.get(i).getId()== obj.getId())
			{
				posts.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public Post update(Post obj) {
		for(int i = 0 ; i < posts.size();i++){
			if(posts.get(i).getId()== obj.getId())
			{
				posts.remove(i);
				posts.add(obj);
				return obj;
			}
		}
		return null;
	}

	@Override
	public Post find(String id) {
		for(int i = 0 ; i < posts.size();i++){
			if(posts.get(i).getId()+""== id)
			{
		
				return posts.get(i);
			}
		}
		return null;
	}

	public List<Post> findAll() {
	return posts;
	}

}
