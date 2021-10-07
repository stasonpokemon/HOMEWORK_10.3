import Services.CourseService;
import Services.StudentService;
import Services.TeacherService;
import info.TextInfo;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pojo.Course;
import pojo.CourseType;
import pojo.Student;
import pojo.Teacher;
import utils.HibernateSessionFactoryUtil;


import java.sql.Timestamp;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static TextInfo textInfo = TextInfo.getTextInfo();
    private static CourseService courseService = CourseService.getCourseService();
    private static StudentService studentService = StudentService.getStudentService();
    private static TeacherService teacherService = TeacherService.getTeacherService();
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        menu();
//        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//        Course course = session.get(Course.class, 50);
//        Student student = session.get(Student.class,106);
//        course.addStudent(student);
//        session.update(student);
//        student.addCourse(course);
//        session.update(course);
//        transaction.commit();
//        session.close();
    }

    private static void menu() {
        int courseId = 0;
        int studentId = 0;
        int teacherId = 0;
        boolean menuExit = true;
        do {
            textInfo.infoMenu();
            String menuOperation = scanner.nextLine();
            switch (menuOperation.toLowerCase()) {
                case "1":
                    boolean courseIdValid = true;
                    boolean studentIdValid = true;
                    boolean teacherIdValid = true;
                    boolean showExit = true;
                    do {
                        textInfo.infoShow();
                        String operation = scanner.nextLine();
                        switch (operation.toLowerCase()) {
                            case "1":
                                List<Course> allCourses = courseService.findAllCourses();
                                if (allCourses == null) {
                                    System.out.println("There are no courses.");
                                } else {
                                    allCourses.forEach(System.out::println);
                                }
                                break;
                            case "2":
                                List<Student> allStudents = studentService.findAllStudents();
                                if (allStudents == null) {
                                    System.out.println("There are no students.");
                                } else {
                                    allStudents.forEach(System.out::println);
                                }
                                break;
                            case "3":
                                List<Teacher> allTeachers = teacherService.findAllTeachers();
                                if (allTeachers == null) {
                                    System.out.println("There are no teachers.");
                                } else {
                                    allTeachers.forEach(System.out::println);
                                }
                                break;
                            case "4":
                                courseIdValid = true;
                                do {
                                    try {
                                        System.out.println("Enter course id...");
                                        courseId = scanner.nextInt();
                                        scanner.nextLine();
                                        Course courseById = courseService.findCourseById(courseId);
                                        if (courseById == null) {
                                            System.out.println("there is no course.");
                                        } else {
                                            System.out.println(courseById);
                                        }
                                        courseIdValid = false;
                                    } catch (InputMismatchException e) {
                                        System.out.println("invalid id entered... Try again.");
                                        scanner.nextLine();
                                        System.out.println("Exception: " + e);
                                    }
                                } while (courseIdValid);
                                break;
                            case "5":
                                studentIdValid = true;
                                do {
                                    try {
                                        System.out.println("Enter student id...");
                                        studentId = scanner.nextInt();
                                        scanner.nextLine();
                                        Student studentById = studentService.findStudentById(studentId);
                                        if (studentById == null) {
                                            System.out.println("there is no student.");
                                        } else {
                                            System.out.println(studentById);
                                        }
                                        studentIdValid = false;
                                    } catch (InputMismatchException e) {
                                        System.out.println("invalid id entered... Try again.");
                                        scanner.nextLine();
                                        System.out.println("Exception: " + e);
                                    }
                                } while (studentIdValid);
                                break;
                            case "6":
                                teacherIdValid = true;
                                do {
                                    try {
                                        System.out.println("Enter teacher id...");
                                        teacherId = scanner.nextInt();
                                        scanner.nextLine();
                                        Teacher teacherById = teacherService.findTeacherById(teacherId);
                                        if (teacherById == null) {
                                            System.out.println("there is no teacher.");
                                        } else {
                                            System.out.println(teacherId);
                                        }
                                        teacherIdValid = false;
                                    } catch (InputMismatchException e) {
                                        System.out.println("invalid id entered... Try again.");
                                        scanner.nextLine();
                                        System.out.println("Exception: " + e);
                                    }
                                } while (teacherIdValid);
                                break;
                            case "7":
                                courseIdValid = true;
                                do {
                                    try {
                                        System.out.println("Enter course id...");
                                        courseId = scanner.nextInt();
                                        scanner.nextLine();
                                        List<Student> allStudentsByIdCourse = courseService.getAllStudentsByIdCourse(courseId);
                                        if (allStudentsByIdCourse == null) {
                                            System.out.println("There are no students.");
                                        } else {
                                            allStudentsByIdCourse.forEach(System.out::println);
                                        }
                                        courseIdValid = false;
                                    } catch (InputMismatchException e) {
                                        System.out.println("invalid id entered... Try again.");
                                        scanner.nextLine();
                                        System.out.println("Exception: " + e);
                                    }
                                } while (courseIdValid);
                                break;
                            case "8":
                                studentIdValid = true;
                                do {
                                    try {
                                        System.out.println("Enter student id...");
                                        studentId = scanner.nextInt();
                                        scanner.nextLine();
                                        List<Course> allCoursesByStudentId = studentService.getAllCoursesByStudentId(studentId);
                                        if (allCoursesByStudentId == null) {
                                            System.out.println("There are no courses.");
                                        } else {
                                            allCoursesByStudentId.forEach(System.out::println);
                                        }
                                        studentIdValid = false;
                                    } catch (InputMismatchException e) {
                                        System.out.println("invalid id entered... Try again.");
                                        scanner.nextLine();
                                        System.out.println("Exception: " + e);
                                    }
                                } while (studentIdValid);
                                break;
                            case "9":
                                courseIdValid = true;
                                do {
                                    try {
                                        System.out.println("Enter course id...");
                                        courseId = scanner.nextInt();
                                        scanner.nextLine();
                                        Teacher teacherByIdCourse = courseService.getTeacherByIdCourse(courseId);
                                        if (teacherByIdCourse == null) {
                                            System.out.println("there is no teacher.");
                                        } else {
                                            System.out.println(teacherByIdCourse);
                                        }
                                        courseIdValid = false;
                                    } catch (InputMismatchException e) {
                                        System.out.println("invalid id entered... Try again.");
                                        scanner.nextLine();
                                        System.out.println("Exception: " + e);
                                    }
                                } while (courseIdValid);
                                break;
                            case "10":
                                showExit = false;
                                System.out.println("exit to menu...");
                                break;
                            default:
                                System.out.println("Invalid operation entered...");
                                break;
                        }
                    } while (showExit);
                    break;
                case "2":
                    Course newCourse = null;
                    Student newStudent = null;
                    boolean addingExit = true;
                    String operation = null;
                    do {
                        textInfo.infoAdding();
                        operation = scanner.nextLine();
                        switch (operation.toLowerCase()) {
                            case "1":
                                int durationCourse = 0;
                                int price = 0;
                                int enterCourseType = 0;
                                boolean durationValid = true;
                                boolean priceValid = true;
                                boolean courseTypeValid = true;
                                CourseType courseType = null;
                                System.out.println("Adding course...\n" +
                                        "Enter name course:");
                                String courseName = scanner.nextLine();
                                do {
                                    try {
                                        System.out.println("Enter duration:");
                                        durationCourse = scanner.nextInt();
                                        durationValid = false;
                                    } catch (InputMismatchException e) {
                                        System.out.println("INCORRECT INPUT FORMAT. Enter INTEGER!!!");
                                        scanner.nextLine();
                                        System.out.println("Exception: " + e);
                                    }
                                } while (durationValid);

                                boolean switchExit = true;
                                do {
                                    do {
                                        try {
                                            System.out.println("Enter course type:\n" +
                                                    "1 - DESIGN,\n" +
                                                    "2 - PROGRAMMING,\n" +
                                                    "3 - MARKETING, \n" +
                                                    "4 - MANAGEMENT, \n" +
                                                    "5 - BUSINESS.");
                                            enterCourseType = scanner.nextInt();
                                            scanner.nextLine();
                                            courseTypeValid = false;
                                        } catch (InputMismatchException e) {
                                            System.out.println("INCORRECT INPUT FORMAT. Enter INTEGER!!!");
                                            scanner.nextLine();
                                            System.out.println("Exception: " + e);
                                        }
                                    } while (courseTypeValid);

                                    switch (enterCourseType) {
                                        case 1:
                                            courseType = CourseType.DESIGN;
                                            switchExit = false;
                                            break;
                                        case 2:
                                            courseType = CourseType.PROGRAMMING;
                                            switchExit = false;
                                            break;
                                        case 3:
                                            courseType = CourseType.MARKETING;
                                            switchExit = false;
                                            break;
                                        case 4:
                                            courseType = CourseType.MANAGEMENT;
                                            switchExit = false;
                                            break;
                                        case 5:
                                            courseType = CourseType.BUSINESS;
                                            switchExit = false;
                                            break;
                                        default:
                                            System.out.println("There is no such type. Try typing again...");
                                            break;
                                    }
                                } while (switchExit);
                                do {
                                    try {
                                        System.out.println("Enter price...");
                                        price = scanner.nextInt();
                                        priceValid = false;
                                    } catch (InputMismatchException e) {
                                        System.out.println("INCORRECT INPUT FORMAT. Enter INTEGER!!!");
                                        scanner.nextLine();
                                        System.out.println("Exception: " + e);
                                    }
                                } while (priceValid);
                                newCourse = new Course(courseName, durationCourse, courseType, courseName, price);
                                courseService.addCourse(newCourse);
                                break;
                            case "2":
                                courseIdValid = true;
                                boolean courseIdTrue = true;
                                boolean teacherIdTrue = true;
//                                do {
//                                    System.out.println("Enter course id...");
//                                    courseId = scanner.nextInt();
//                                    scanner.nextLine();
//                                    Course courseById = courseService.findCourseById(courseId);
//                                    if (courseById == null){
//                                        boolean operationValid = true;
//                                        do {
//                                            System.out.println("The course does not exist...\n" +
//                                                    "1 - try again.\n" +
//                                                    "2 - exit.");
//                                            operation = scanner.nextLine();
//                                            switch (operation){
//                                                case "1":
//                                                    operationValid = false;
//                                                    break;
//                                                case "2":
//                                                    operationValid = false;
//                                                    courseIdValid = false;
//                                                    break;
//                                                default:
//                                                    System.out.println("Invalid operation entered. Try again...");
//                                                    break;
//                                            }
//                                        } while (operationValid);
//                                    } else {
//                                        System.out.println("Enter name student...");
//                                        String studentName =  scanner.nextLine();
//                                        boolean ageValid = true;
//                                        int studentAge = 0;
//                                        do {
//                                            try {
//                                                System.out.println("Enter age student...");
//                                                studentAge = scanner.nextInt();
//                                                ageValid = false;
//                                            } catch (InputMismatchException e) {
//                                                System.out.println("INCORRECT INPUT FORMAT. Enter INTEGER!!!");
//                                                scanner.nextLine();
//                                                System.out.println("Exception: " + e);
//                                            }
//                                        } while (ageValid);
//                                        Timestamp data = new Timestamp(new Date().getTime());
//                                        newStudent = new Student(studentName, studentAge,data);
//                                        courseService.addStudentToTheCourse(newStudent, courseId);
//                                    }
//                                } while (courseIdValid);                                                      T


                                break;
                            case "3":
                                boolean addTeacherValid = true;
                                Teacher teacher = new Teacher();
                                courseIdValid = true;
                                courseIdTrue = true;
                                switchExit = true;
                                boolean salaryValid = true;
                                boolean ageValid = true;
                                do {
                                    do {
                                        try {
                                            System.out.println("Enter course id...");
                                            courseId = scanner.nextInt();
                                            scanner.nextLine();
                                            Course courseById = courseService.findCourseById(courseId);
                                            if (courseById == null) {
                                                do {
                                                    System.out.println("There is no such course..." +
                                                            "Enter operation: \n" +
                                                            "1 - try again enter course id.\n" +
                                                            "2 - exit to adding menu.");
                                                    operation = scanner.nextLine();
                                                    switch (operation) {
                                                        case "1":
                                                            switchExit = false;
                                                            break;
                                                        case "2":
                                                            switchExit = false;
                                                            courseIdValid = false;
                                                            courseIdTrue = false;
                                                            addTeacherValid = false;
                                                            break;
                                                        default:
                                                            System.out.println("Invalid operation entered...");
                                                            break;
                                                    }
                                                } while (switchExit);
                                            } else {
                                                courseIdValid = false;
                                            }
                                        } catch (InputMismatchException e) {
                                            System.out.println("INCORRECT INPUT FORMAT. Enter INTEGER!!!");
                                            scanner.nextLine();
                                            System.out.println("Exception: " + e);
                                        }
                                    } while (courseIdValid);
                                    if (courseIdTrue) {
                                        System.out.println("Enter teacher name...");
                                        String teacherName = scanner.nextLine();
                                        teacher.setName(teacherName);
                                        do {
                                            try {
                                                System.out.println("Enter teacher salary...");
                                                int teacherSalary = scanner.nextInt();
                                                teacher.setSalary(teacherSalary);
                                                salaryValid = false;
                                            } catch (InputMismatchException e) {
                                                System.out.println("INCORRECT INPUT FORMAT. Enter INTEGER!!!");
                                                scanner.nextLine();
                                                System.out.println("Exception: " + e);
                                            }
                                            do {
                                                try {
                                                    System.out.println("Enter teacher age...");
                                                    int teacherAge = scanner.nextInt();
                                                    teacher.setAge(teacherAge);
                                                    ageValid = false;
                                                } catch (InputMismatchException e) {
                                                    System.out.println("INCORRECT INPUT FORMAT. Enter INTEGER!!!");
                                                    scanner.nextLine();
                                                    System.out.println("Exception: " + e);
                                                }
                                            } while (ageValid);
                                        } while (salaryValid);
                                        courseService.addTeacherToTheCourse(courseId, teacher);
                                        addTeacherValid = false;
                                    }
                                } while (addTeacherValid);
                                break;
                            case "4":
                                boolean changeTeacherValid = true;
                                switchExit = true;
                                courseIdValid = true;
                                courseIdTrue = true;
                                teacherIdValid = true;
                                teacherIdTrue = true;
                                do {
                                    do {
                                        try {
                                            System.out.println("Enter course id...");
                                            courseId = scanner.nextInt();
                                            scanner.nextLine();
                                            Course courseById = courseService.findCourseById(courseId);
                                            if (courseById == null) {
                                                do {
                                                    System.out.println("There is no such course..." +
                                                            "Enter operation: \n" +
                                                            "1 - try again enter course id.\n" +
                                                            "2 - exit to adding menu.");
                                                    operation = scanner.nextLine();
                                                    switch (operation) {
                                                        case "1":
                                                            switchExit = false;
                                                            break;
                                                        case "2":
                                                            switchExit = false;
                                                            courseIdValid = false;
                                                            courseIdTrue = false;
                                                            changeTeacherValid = false;
                                                            teacherIdTrue = false;
                                                            break;
                                                        default:
                                                            System.out.println("Invalid operation entered...");
                                                            break;
                                                    }
                                                } while (switchExit);
                                            } else {
                                                courseIdValid = false;
                                            }
                                        } catch (InputMismatchException e) {
                                            System.out.println("INCORRECT INPUT FORMAT. Enter INTEGER!!!");
                                            scanner.nextLine();
                                            System.out.println("Exception: " + e);
                                        }
                                    } while (courseIdValid);
                                    if (courseIdTrue) {
                                        do {
                                            try {
                                                System.out.println("Enter teacher id...");
                                                teacherId = scanner.nextInt();
                                                scanner.nextLine();
                                                Teacher teacherById = teacherService.findTeacherById(teacherId);
                                                if (teacherById == null) {
                                                    do {
                                                        System.out.println("There is no such teacher..." +
                                                                "Enter operation: \n" +
                                                                "1 - try again enter teacher id.\n" +
                                                                "2 - exit to adding menu.");
                                                        operation = scanner.nextLine();
                                                        switch (operation) {
                                                            case "1":
                                                                switchExit = false;
                                                                break;
                                                            case "2":
                                                                switchExit = false;
                                                                teacherIdValid = false;
                                                                teacherIdTrue = false;
                                                                changeTeacherValid = false;
                                                                break;
                                                            default:
                                                                System.out.println("Invalid operation entered...");
                                                                break;
                                                        }
                                                    } while (switchExit);
                                                } else {
                                                    teacherIdValid = false;
                                                }
                                            } catch (InputMismatchException e) {
                                                System.out.println("INCORRECT INPUT FORMAT. Enter INTEGER!!!");
                                                scanner.nextLine();
                                                System.out.println("Exception: " + e);
                                            }
                                        } while (teacherIdValid);
                                    }
                                    if (teacherIdTrue) {
                                        courseService.changeTeacherOnCourse(courseId, teacherId);
                                        changeTeacherValid = false;
                                    }
                                } while (changeTeacherValid);
                                break;
                            case "5":
                                System.out.println("Exit to menu...");
                                addingExit = false;
                                break;
                            default:
                                System.out.println("Invalid operation entered...");
                                break;
                        }
                    } while (addingExit);
                    break;
                case "3":
                    boolean deletionExit = true;
                    boolean courseIdTrue = true;
                    do {
                        textInfo.infoDeletion();
                        operation = scanner.nextLine();
                        switch (operation) {
                            case "1":
                                /**
                                 *
                                 * Не получатеся удалить курс
                                 *
                                 * */
//                                boolean deleteCourseValid = true;
//                                boolean switchExit = true;
//                                courseIdValid = true;
//                                do {
//                                    do {
//                                        try {
//                                            System.out.println("Enter course id...");
//                                            courseId = scanner.nextInt();
//                                            scanner.nextLine();
//                                            Course courseById = courseService.findCourseById(courseId);
//                                            if (courseById == null) {
//                                                do {
//                                                    System.out.println("There is no such course..." +
//                                                            "Enter operation: \n" +
//                                                            "1 - try again enter course id.\n" +
//                                                            "2 - exit to adding menu.");
//                                                    operation = scanner.nextLine();
//                                                    switch (operation) {
//                                                        case "1":
//                                                            switchExit = false;
//                                                            break;
//                                                        case "2":
//                                                            switchExit = false;
//                                                            courseIdValid = false;
//                                                            courseIdTrue = false;
//                                                            deleteCourseValid = false;
//                                                            break;
//                                                        default:
//                                                            System.out.println("Invalid operation entered...");
//                                                            break;
//                                                    }
//                                                } while (switchExit);
//                                            } else {
//                                                courseIdValid = false;
//                                            }
//                                        } catch (InputMismatchException e) {
//                                            System.out.println("INCORRECT INPUT FORMAT. Enter INTEGER!!!");
//                                            scanner.nextLine();
//                                            System.out.println("Exception: " + e);
//                                        }
//                                    } while (courseIdValid);
//                                    if (courseIdTrue){
//                                        courseService.deleteCourseById(courseId);
//                                        deleteCourseValid = false;
//                                    }
//                                } while (deleteCourseValid);
                                break;
                            case "2":
                                break;
                            case "3":
                                break;
                            case "4":
                                break;
                            case "5":
                                break;
                            case "6":
                                break;
                            case "7":
                                break;
                            case "8":
                                System.out.println("exit to menu...");
                                deletionExit = false;
                                break;
                            default:
                                System.out.println("Invalid operation entered...");
                                break;
                        }
                    } while (deletionExit);
                    break;
                case "4":
                    break;
                case "5":
                    menuExit = false;
                    System.out.println("exit...");
                    break;
                default:
                    System.out.println("Invalid operation entered...");
                    break;
            }
        } while (menuExit);
    }

}
