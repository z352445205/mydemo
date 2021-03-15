package com.example.demo.stream.function;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Zhengyn
 * @description
 * @create 20/12/22 18:59
 */
public class SupplierDemo {
    public static void main(String[] args) {


        List<Student> students = new ArrayList<>();

       /* students.add(new Student("dbc", 12));
        students.add(new Student("bcd", 12));
        students.add(new Student("cde", 17));
        students.add(new Student("cde", 17));
        students.add(new Student("def", 25));
        students.add(new Student("efg", 15));*/


        final List<Man> collect = students.stream().map(student -> {
                    final Man man = new Man();
                    man.setName(student.getName());
                    return man;
                }
        ).collect(Collectors.toList());
        System.err.println(collect);
        //students.sort(Comparator.reverseOrder().thenComparing(Student::getAge));
       /* final List<Student> collect1 = students.stream().filter(student -> student.getAge() > 13).collect(Collectors.toList());
        System.out.println(collect1);
        final Map<Integer, List<Student>> collect = students.stream().collect(Collectors.groupingBy(Student::getAge));

        for (Student stu : students) {
            System.out.println(stu);
        }
        System.err.println(collect);*/
        /*List<String> list = Arrays.asList("AA", "BB", "CC", "BB", "CC", "AA", "AA");

        for (Student stu : students) {
            System.out.println(stu);
        }
        System.err.println("---------------");
        final long count = students.stream().distinct().count();
        for (Student stu : students) {
            System.out.println(stu);
        }
        System.err.println(count);

        final val collect = list.stream().distinct().collect(Collectors.toList());
        //collect.add("sss");
        System.err.println(collect);*/
    }
}
