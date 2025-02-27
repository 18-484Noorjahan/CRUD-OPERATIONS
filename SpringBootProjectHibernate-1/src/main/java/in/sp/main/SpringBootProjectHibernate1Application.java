package in.sp.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import in.sp.main.entities.User;
import in.sp.main.repository.DbOperations;

@SpringBootApplication
@ComponentScan("in.sp.main.repository")  // Add this if DbOperationsImpl is in a different package
public class SpringBootProjectHibernate1Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringBootProjectHibernate1Application.class, args);
        DbOperations d = context.getBean(DbOperations.class);
        User s = d.getUserDetails(1L);

        if (s != null) {
            System.out.println(s.getEmail());
            System.out.println(s.getName());
        } else {
            System.out.println("something went wrong");
        }
    }
}
