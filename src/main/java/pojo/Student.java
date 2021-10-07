package pojo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    @Column(name = "registration_date", columnDefinition = "datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;
    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(name = "subscriptions",
            joinColumns = {@JoinColumn(name = "student_id")},
            inverseJoinColumns = {@JoinColumn(name = "course_id")}
    )
    private List<Course> courses = new ArrayList<>();

    public Student() {
    }

    public Student(String name, int age, Date registrationDate) {
        this.name = name;
        this.age = age;
        this.registrationDate = registrationDate;
    }

    //    @OneToMany(cascade = CascadeType.ALL)
//    private List<Subscription> subscriptions;

//    public List<Subscription> getSubscriptions() {
//        return subscriptions;
//    }
//
//    public void setSubscriptions(List<Subscription> subscriptions) {
//        this.subscriptions = subscriptions;
//    }

    public void addCourse(Course course){
        courses.add(course);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", registrationDate=" + registrationDate +
                ", courses=" + courses +
//                ", subscription=" + subscriptions +
                '}';
    }
}
