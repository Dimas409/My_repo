package Collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArrayListMethods2 {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>(List.of(
                new Student("Ivan", 'm', 22, 3, 8.3),
                new Student("Nikolay", 'm', 28, 2, 6.4),
                new Student("Elena", 'f', 19, 1, 8.9),
                new Student("Petr", 'm', 35, 4, 7),
                new Student("Maria", 'f', 23, 3, 7.4)
        ));
        System.out.println(students);
        students.remove(new Student("Maria", 'f', 23, 3, 7.4));
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

class Student{
    private String name;
    private char sex;
    private int age;
    private int course;
    private double avgGrade;

    public Student(String name, char sex, int age, int course, double avgGrade) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.avgGrade = avgGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", course=" + course +
                ", avgGrade=" + avgGrade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return sex == student.sex && age == student.age && course == student.course && Double.compare(avgGrade, student.avgGrade) == 0 && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex, age, course, avgGrade);
    }
}
