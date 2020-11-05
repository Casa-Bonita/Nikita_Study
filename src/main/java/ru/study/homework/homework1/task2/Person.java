package ru.study.homework.homework1.task2;

public class Person {
    private int id;
    private String name;
    private String lastName;
    private int age;
    private String address;
    private int growth; // рост
    private int weight; // вес
    private String phoneNumber;

    public Person() {
    }

    public Person(int id, String name, String lastName, int age, String address, int growth, int weight, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.growth = growth;
        this.weight = weight;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getGrowth() {
        return growth;
    }

    public void setGrowth(int growth) {
        this.growth = growth;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "id = " + id + ", name = " + name + ", lastName = " + lastName + ", age = " + age + ", address = " + address
                + ", growth = " + growth + ", weight = " + weight + ", phoneNumber = " + phoneNumber;
    }
}