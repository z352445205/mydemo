package com.example.demo.stream;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Zhengyn
 * @description
 * @create 20/11/16 10:32
 */
public class StreamTest2 {

    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(7, 6, 9, 1, 8, 2, 3);

        //遍历符合条件的元素
        list.stream().filter(x -> x < 5).forEach(System.out::println);
        Optional<Integer> any = list.stream().filter(x -> x < 5).findAny();
        System.err.println(any.get());
        boolean b = list.parallelStream().allMatch(x -> x < 6);
        System.err.println(b);
    }

    @Test
    public void test2() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));
        List<Integer> collect1 = personList.parallelStream().filter(p -> p.getSalary() > 8000).map(Person::hashCode).collect(Collectors.toList());
        System.err.println(collect1);

        List<String> collect = personList.parallelStream().filter(p -> p.getSalary() > 8000).map(Person::getName).collect(Collectors.toList());
        System.err.println(collect);
    }

    @Test
    public void test3() {
        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");

        Optional<String> max = list.parallelStream().max(Comparator.comparingInt(String::length));
        max.ifPresent(System.err::println);
        System.err.println(max.get().length());
    }

    @Test
    public void test4() {
        List<Integer> list = Arrays.asList(7, 6, 9, 4, 11, 6);

        // 自然排序
        Optional<Integer> max = list.stream().max(Integer::compareTo);
        System.err.println(max.get());

        Optional<Integer> max1 = list.parallelStream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return -o1.compareTo(o2);
            }
        });
        System.err.println(max1.get());

    }

    @Test
    public void test5() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        Person person = personList.parallelStream().max(Comparator.comparingInt(Person::getSalary)).get();
        System.err.println(person);
    }

    @Test
    public void test6() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        // 不改变原来员工集合的方式
        List<Person> personListNew = personList.stream().map(person -> {
            Person personNew = new Person(person.getName(), 0, 0, null, null);
            personNew.setSalary(person.getSalary() + 10000);
            return personNew;
        }).collect(Collectors.toList());
        System.out.println("一次改动前：" + personList.get(0).getName() + "-->" + personList.get(0).getSalary() + "-->" + personList.get(0).getAge());
        System.out.println("一次改动后：" + personListNew.get(0).getName() + "-->" + personListNew.get(0).getSalary() + "-->" + personListNew.get(0).getAge());

        // 改变原来员工集合的方式
        List<Person> personListNew2 = personList.stream().peek(person -> person.setSalary(person.getSalary() + 10000)).collect(Collectors.toList());
        System.out.println("二次改动前：" + personList.get(0).getName() + "-->" + personListNew.get(0).getSalary() + "-->" + personList.get(0).getAge());
        System.out.println("二次改动后：" + personListNew2.get(0).getName() + "-->" + personListNew.get(0).getSalary() + "-->" + personListNew2.get(0).getAge());
    }

    @Test
    public void test7() {
        List<String> list = Arrays.asList("m,k,l,a", "1,3,5,7");
        List<String> collect = list.stream().flatMap(a -> {
            // 将每个元素转换成一个stream
            String[] split = a.split(",");
            return Arrays.stream(split);
        }).collect(Collectors.toList());
        System.err.println(list);
        System.err.println(collect);
    }
    @Test
    public void test8(){
        List<Integer> list = Arrays.asList(1, 3, 2, 8, 11, 4);

        Stream<Integer> sorted = list.stream().sorted();
        System.err.println(sorted.collect(Collectors.toList()));
        System.err.println(list);
        Optional<Integer> reduce = list.stream().reduce(Integer::sum);
        reduce.ifPresent(a->{
            System.err.println(a+10);
        });

        // 求最大值写法2
        Integer max2 = list.stream().reduce(1, Integer::max);
        System.err.println("最大值"+max2);
        Integer integer = list.stream().max(Integer::compareTo).get();
        System.err.println(integer);

        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        Optional<Integer> reduce1 = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        reduce1.ifPresent(System.out::println);
    }



}
