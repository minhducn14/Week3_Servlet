package dao;

import java.util.List;

import entities.User;

public interface UserDAO {
	public List<User> getAllUsers();

	public User getById(int id);

	public void addUser(User p);
}
