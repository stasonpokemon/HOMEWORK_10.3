package utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import pojo.*;

public class HibernateSessionFactoryUtil {

    private static SessionFactory sessionFactory;

    public HibernateSessionFactoryUtil() {
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null){
            Configuration configure = new Configuration().configure();
            configure.addAnnotatedClass(Course.class);
            configure.addAnnotatedClass(Student.class);
            configure.addAnnotatedClass(Teacher.class);
//            configure.addAnnotatedClass(Subscription.class);
            configure.addAnnotatedClass(PurchaseList.class);
            StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().
                    applySettings(configure.getProperties());
            sessionFactory = configure.buildSessionFactory(builder.build());
        }
        return sessionFactory;
    }
}
