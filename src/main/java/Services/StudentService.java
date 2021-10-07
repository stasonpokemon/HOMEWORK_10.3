package Services;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Course;
import pojo.Student;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class StudentService {

    private static StudentService studentService = null;

    public static StudentService getStudentService() {
        if (studentService == null){
            studentService = new StudentService();
        }
        return studentService;
    }

    public StudentService() {
    }

    public List<Student> findAllStudents() {
        List<Student> students = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Student").list();
        return students;
    }

    public Student findStudentById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Student.class, id);

    }

    public void saveStudent(Student student) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
    }

    public void updateStudent(Student student) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(session);
        transaction.commit();
        session.close();
    }

    public void deleteStudent(Student student) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(student);
        transaction.commit();
        session.close();
    }

    public List<Course> getAllCoursesByStudentId(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Student student = session.get(Student.class, id);
        List<Course> courses = student.getCourses();
        return courses;
    }

    public int getNumberOfCourseByIdStudent(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Student student = session.get(Student.class, id);
        return student.getCourses().size();
    }

}
