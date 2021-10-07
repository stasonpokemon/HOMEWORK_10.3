package Services;

import org.hibernate.Session;
import pojo.Teacher;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class TeacherService {

    private static TeacherService teacherService = null;

    public static TeacherService getTeacherService() {
        if (teacherService == null){
            teacherService = new TeacherService();
        }
        return teacherService;
    }

    public TeacherService() {
    }

    public List<Teacher> findAllTeachers(){
        List<Teacher> teachers = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Teacher").list();
        return teachers;
    }

    public Teacher findTeacherById(int id){
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Teacher teacher = session.get(Teacher.class, id);
        return teacher;
    }
}
