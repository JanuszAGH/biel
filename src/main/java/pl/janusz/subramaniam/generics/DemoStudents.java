package pl.janusz.subramaniam.generics;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.*;

/**
 * Created by Janusz Kacki on 30/11/2019. Project; bielmarcus
 */
public class DemoStudents {

    public static void main(String[] args) {

        new DemoStudents().start();
    }

    private void start() {

        Student first = new Student(3, 33);
        Student second = new Student(1, 22);
        Student third = new Student(2, 11);
        List<Student> students = new ArrayList<>(Arrays.asList(first, second, third));
        students.forEach(System.err::println);

        Comparator<Student> marks = Comparator.comparingInt(s -> s.marks);
        Comparator<Student> rollnos = Comparator.comparingInt(s -> s.rollno);
        students.sort(marks.thenComparing(rollnos));
        students.forEach(System.err::println);
        Collections.sort(students);
    }

    @ThreadSafe
    private @Data
    class Student implements Comparable<Student> {

        @Getter
        @Setter
        @GuardedBy("this")
        private int rollno;
        @Getter
        @Setter
        private int marks;

        public Student(int rollno, int marks) {

            this.rollno = rollno;
            this.marks = marks;
        }

        @Override
        public int compareTo(Student o) {

            return Integer.compare(rollno, o.rollno);
        }
    }
}
