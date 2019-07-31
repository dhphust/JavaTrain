package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 自定义比较器
 */
public class Code_Comparator {
    public static class Student {
        public String name;
        public int id;
        public int age;

        public Student(String name, int id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }
    }

    /**
     * 按照id生序排列
     * compare()方法用来给两个输入参数排序，返回负数，0，正数表明第一个参数是小于，等于，大于第二个参数。
     */
    public static class IdAscendingComparator implements Comparator<Student>{

        @Override
        public int compare(Student o1, Student o2) {
//            if (o1.id < o2.id)
//                return -1;
//            else if (o2.id < o1.id)
//                return 1;
//            else
//                return 0;
            return o1.id - o2.id;
        }
    }


    /**
     * 按照id降序排列
     */
    public static class IdDescendingComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return o2.id - o1.id;
        }
    }

    public static void printStudents(Student[] students) {
        for (Student student : students) {
            System.out.println("Name : " + student.name + ", Id : " + student.id + ", Age : " + student.age);
        }
        System.out.println("===========================");
    }
    public static void main(String[] args) {
        Student student1 = new Student("A", 1, 23);
        Student student2 = new Student("B", 2, 21);
        Student student3 = new Student("C", 3, 22);

        Student[] students = new Student[] { student3, student2, student1 };
        printStudents(students);

        Arrays.sort(students, new IdAscendingComparator());
        printStudents(students);

        Arrays.sort(students, new IdDescendingComparator());
        printStudents(students);

        //尝试去掉new IdAscendingComparator()试试
        PriorityQueue<Student> heap = new PriorityQueue<>(new IdAscendingComparator());
        heap.add(student3);
        heap.add(student2);
        heap.add(student1);
        while(!heap.isEmpty()){
            Student student = heap.poll();
            System.out.println("Name:" + student.name + "----id:" +student.id + "----age:" + student.age);
        }

    }

}
