package ru.netology.hibernatedaolayer.entity;

import javax.persistence.*;

@Entity
@Table
@IdClass(PersonDataPrimaryKey.class)
public class Person {

    @Column
    @Id
    private String name;

    @Column
    @Id
    private String surname;

    @Column
    @Id
    private int age;

    @Column(name = "phone_number")
    private int phoneNumber;

    @Column(name = "city_of_living")
    private String cityOfLiving;

    public Person() {
    }

    public Person(String name, String surname, int age, int phoneNumber, String cityOfLiving) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.cityOfLiving = cityOfLiving;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int phoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String cityOfLiving() {
        return cityOfLiving;
    }

    public void cityOfLiving(String cityOfLiving) {
        this.cityOfLiving = cityOfLiving;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", phone_number=" + phoneNumber +
                ", city_of_living='" + cityOfLiving + '\'' +
                '}';
    }
}
