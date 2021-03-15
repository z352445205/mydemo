package com.example.demo.stream;

import java.util.Optional;

/**
 * @author Zhengyn
 * @description
 * @create 20/12/29 17:07
 */
public class TestPerson {
    public static void main(String[] args) {
        final Person person = new Person(new Address(new Country("中国")));
        String result = Optional.ofNullable(person)
                .map(per -> per.address)
                .map(address -> address.country)
                .map(country -> country.name).orElse(null);
        System.out.println(result);
    }
    static class Person {
        Address address;

        public Person(Address address) {
            this.address = address;
        }
    }

    static class Address {
        Country country;

        public Address(Country country) {
            this.country = country;
        }
    }

    static class Country {
        String name;

        public Country(String name) {
            this.name = name;
        }
    }
}
