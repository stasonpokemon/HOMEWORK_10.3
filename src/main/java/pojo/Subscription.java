//package pojo;
//
//import javax.persistence.*;
//import java.util.Date;
//
//@Table(name = "subscriptions")
//public class Subscription {
//    @Column(name = "student_id")
//    @ManyToOne(cascade = CascadeType.ALL)
//    private Student student;
//    @Column(name = "course_id")
//    private int courseId;
//    @Column(name = "subscription_date", columnDefinition = "datetime")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date subscriptionDate;
//
//    public Student getStudent() {
//        return student;
//    }
//
//    public void setStudent(Student student) {
//        this.student = student;
//    }
//
//    public int getCourseId() {
//        return courseId;
//    }
//
//    public void setCourseId(int courseId) {
//        this.courseId = courseId;
//    }
//
//    public Date getSubscriptionDate() {
//        return subscriptionDate;
//    }
//
//    public void setSubscriptionDate(Date subscriptionDate) {
//        this.subscriptionDate = subscriptionDate;
//    }
//
//    @Override
//    public String toString() {
//        return "Subscription{" +
//                "studentId=" + student +
//                ", courseId=" + courseId +
//                ", subscriptionDate=" + subscriptionDate +
//                '}';
//    }
//}
