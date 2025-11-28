import java.util.List;

/**
 * 学校类
 */
public class School {
    private List<Department> departments; // 包含多个院系
    private List<Student> students;       // 包含多个学生（0个或多个）

    public School(List<Department> departments, List<Student> students) {
        this.departments = departments;
        this.students = students;
    }
}

/**
 * 院系类
 */
public class Department {
    private List<Instructor> instructors; // 包含多个教师（至少1个）
    private List<Subject> subjects;       // 包含多门课程（至少1门）

    public Department(List<Instructor> instructors, List<Subject> subjects) {
        this.instructors = instructors;
        this.subjects = subjects;
    }
}

/**
 * 教师类
 */
public class Instructor {
    private Department department; // 所属院系
    private List<Subject> subjects; // 教授的课程（1-3门）

    public Instructor(Department department, List<Subject> subjects) {
        this.department = department;
        this.subjects = subjects;
    }
}

/**
 * 课程类（Subject）
 */
public class Subject {
    private Department department; // 所属院系
    private Instructor instructor;  // 授课教师
    private List<Student> students; // 选课学生

    public Subject(Department department, Instructor instructor, List<Student> students) {
        this.department = department;
        this.instructor = instructor;
        this.students = students;
    }
}

/**
 * 学生类
 */
public class Student {
    private School school;         // 所属学校
    private List<Subject> subjects; // 选修的课程（1-5门）

    public Student(School school, List<Subject> subjects) {
        this.school = school;
        this.subjects = subjects;
    }
}