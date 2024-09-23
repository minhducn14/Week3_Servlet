package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import dao.UserDAO;
import entities.User;

public class UserDAOImpl implements UserDAO {
	private DataSource datasource;

	public UserDAOImpl(DataSource datasource) {
		super();
		this.datasource = datasource;
	}

	@Override
	public List<User> getAllUsers() {
		String sql = "SELECT * FROM users";
		List<User> list = new ArrayList<User>();
		try (Connection con = this.datasource.getConnection();
				PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();) {
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setFirstName(rs.getString("first_name"));
				user.setLastName(rs.getString("last_name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setBirthday(rs.getDate("birthday"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public User getById(int id) {
		String sql = "SELECT * FROM users WHERE id=?";
		User user = null;
		try (Connection con = this.datasource.getConnection();
				PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);) {
			ps.setInt(1, id);
			try (ResultSet rs = ps.executeQuery();) {
				if (rs.next()) {
					user = new User();
					user.setId(rs.getInt("id"));
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("password"));
					user.setBirthday(rs.getDate("birthday"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public void addUser(User p) {
		String sql = "INSERT INTO users(first_name, last_name, email, password, birthday) VALUES(?,?,?,?,?)";
		try (Connection con = this.datasource.getConnection();
				PreparedStatement ps = (PreparedStatement) con.prepareStatement(sql);) {
			ps.setString(1, p.getFirstName());
			ps.setString(2, p.getLastName());
			ps.setString(3, p.getEmail());
			ps.setString(4, p.getPassword());
			if (p.getBirthday() != null) {
				java.util.Date utilDate = p.getBirthday();
				java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
				ps.setDate(5, sqlDate);
			} else {
				ps.setDate(5, null);
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
