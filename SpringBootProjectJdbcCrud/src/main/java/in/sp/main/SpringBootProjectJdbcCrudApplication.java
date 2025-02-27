package in.sp.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import in.sp.main.dao.UserDao;
import in.sp.main.entity.User;

@SpringBootApplication
public class SpringBootProjectJdbcCrudApplication  implements CommandLineRunner
{
	
    @Autowired
	private UserDao userDao;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectJdbcCrudApplication.class, args);
	    
	
	}

	@Override
	public void run(String... args) throws Exception {
		
		//insertion
		//User user1= new User("noorjahan","nooritannu@gmail.com","F","banglore");
//		User user4= new User("sallu","sallu@gmail.com","F","rgwjal");
//	    boolean status = userDao.inserUser(user4);
//	    if(status)
//	    	System.out.println("inserted ..");
//	    else
//	    	System.out.println("not inserted ...");
		
		//updation
//		User use = new User("noorjahan","nooritannu@gmail.com","F","jkdbw");
//		boolean status =userDao.updateUser(use);
//		if(status)System.out.println("updated");
//		else System.out.println("not updated");
		
		//deletion
//		boolean status = userDao.deleteUser("sallu@gmail.com");
//		if(status)System.out.println("deleted the row");
//		else System.out.println("wrong email");
	//selection one user
//		User user = userDao.getUSerByEmail("nooritannu@gmail.com");
//		System.out.println("Name :"+user.getName());
//		System.out.println("Email : "+user.getEmail());
//		System.out.println("Gender : "+user.getGender());
//		System.out.println("City : "+user.getCity());
		
		
		//select all users 
		List<User> list =userDao.getAllUsers();
		for(User user:list)
		{
			System.out.println("Name :"+user.getName());
			System.out.println("Email : "+user.getEmail());
			System.out.println("Gender : "+user.getGender());
			System.out.println("City : "+user.getCity());
			System.out.println("....-----....");
		}
	}

}
