package Services;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Course;
import pojo.Student;
import pojo.Teacher;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class CourseService {

    private static StudentService studentService = StudentService.getStudentService();
    private static CourseService courseService = null;

    public final static CourseService getCourseService() {
        if (courseService == null) {
            courseService = new CourseService();
        }
        return courseService;
    }

    public CourseService() {
    }

    public List<Course> findAllCourses() {
        List<Course> courses = HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM Course").list();
        return courses;
    }

    public Course findCourseById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Course course = session.get(Course.class, id);
        return course;
    }

    public void deleteCourseById(int courseId) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Course course = session.get(Course.class, courseId);
        session.delete(course);
        transaction.commit();
        session.close();

    }


    public Teacher getTeacherByIdCourse(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Course course = session.get(Course.class, id);
        return course.getTeacher();
    }

    public int getNumberOfStudentsByIdCourse(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Course course = session.get(Course.class, id);
        List<Student> students = course.getStudents();
        return students.size();
    }

    public List<Student> getAllStudentsByIdCourse(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Course course = session.get(Course.class, id);
        List<Student> students = course.getStudents();
        return students;
    }

    public void addCourse(Course course) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(course);
        transaction.commit();
        session.close();
    }

    public void addStudentToTheCourse(int courseId, Student student) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Course course = session.get(Course.class, courseId);
        List<Student> students = course.getStudents();
        students.add(student);
        course.setStudents(students);
        session.update(course);

        transaction.commit();
        session.close();
    }

    public void addTeacherToTheCourse(int courseId, Teacher teacher) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Course course = session.get(Course.class, courseId);
        course.setTeacher(teacher);
        session.save(course);
        transaction.commit();
        session.close();
    }

    public void changeTeacherOnCourse(int courseId, int teacherId) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Course course = session.get(Course.class, courseId);
        Teacher teacher = session.get(Teacher.class, teacherId);
        course.setTeacher(teacher);
        session.save(course);
        transaction.commit();
        session.close();
    }


}
