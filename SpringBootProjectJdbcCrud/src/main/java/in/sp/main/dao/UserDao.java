package in.sp.main.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import in.sp.main.entity.User;

@Repository
public class UserDao { 
 
	@Autowired
	private JdbcTemplate jdbcTemplate; //provides methods tointeract with jdbc
	public boolean  inserUser(User user)
	{
		boolean status=false;
		try {
			String INSERT_SQL_QUERY ="INSERT  INTO users(name , email,gender,city) VALUES(?,?,?,?)";
			
			int count =jdbcTemplate.update(INSERT_SQL_QUERY, user.getName(),user.getEmail(),user.getGender(),user.getCity());
			if(count>0)
			{
				status=true;
			}else
			{
				status=false;
			}
			
		} catch (Exception e) {
			status =false;
			e.printStackTrace();
		}
		return status;
	}
	
	public boolean updateUser(User use)
	{
		boolean status=false;
		try {
			String UPDATE_SQL_QUERY	="UPDATE users SET name =?,gender=?,city=?WHERE email=?";
			int count= jdbcTemplate.update(UPDATE_SQL_QUERY,use.getName(),use.getGender(),use.getCity(),use.getEmail());
			
			if(count>0)
			{
				status=true;
			}else
			{
				status=false;
			}
			
		} catch (Exception e) {
			status =false;
			e.printStackTrace();
		}
		return status;
	}
	public boolean deleteUser(String email)
	{
		boolean status=false;
		try {
			String DELETE_SQL_QUERY	="DELETE FROM users WHERE email=?";
			int count= jdbcTemplate.update(DELETE_SQL_QUERY,email);
			if(count>0)
			{
				status=true;
			}else
			{
				status=false;
			}
			
		} catch (Exception e) {
			status =false;
			e.printStackTrace();
		}
		return status;
	}
	
	public User getUSerByEmail(String email)
	{
		String SELECT_SQL_QUERY="SELECT * FROM users WHERE email=?";
		return  jdbcTemplate.queryForObject(SELECT_SQL_QUERY,new UserRowMapper(),email);
	}
	
	public List<User> getAllUsers()
	{
		String SELECT_SQL_QUERY="SELECT * FROM users ";
		return jdbcTemplate.query(SELECT_SQL_QUERY,new UserRowMapper());
	}
	public static final class UserRowMapper implements RowMapper<User>
	{

		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setName(rs.getString("name"));
			user.setEmail(rs.getString("email"));
			user.setGender(rs.getString("gender"));
			user.setCity(rs.getString("city"));
			return user;
		}
		
	}
}
