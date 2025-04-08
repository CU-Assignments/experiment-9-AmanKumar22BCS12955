import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
        } catch (Exception e) {
            throw new ExceptionInInitializerError("Failed to create SessionFactory object." + e);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
