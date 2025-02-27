package in.sp.main.repository;

import org.hibernate.Session;
import in.sp.main.config.HibernateConfig;
import in.sp.main.entities.User;
import org.springframework.stereotype.Component;

@Component
public class DbOperationsImpl implements DbOperations {

    @Override
    public User getUserDetails(Long id) {
        User us = null;
        try (Session s = HibernateConfig.getSessionFactory().openSession()) {
            us = s.get(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return us;
    }
}
