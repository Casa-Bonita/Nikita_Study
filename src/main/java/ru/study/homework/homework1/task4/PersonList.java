package ru.study.homework.homework1.task4;

import java.util.List;

public class PersonList {
    private int id;
    private String name;
    private String lastName;
    private int age;
    private String address;
    private int growth;
    private int weight;
    private List<TypePhone> listPhoneNumber;

    public PersonList() {
    }

    public PersonList(int id, String name, String lastName, int age, String address, int growth, int weight, List<TypePhone> listPhoneNumber) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.address = address;
        this.growth = growth;
        this.weight = weight;
        this.listPhoneNumber = listPhoneNumber;
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

    public List<TypePhone> getPhoneNumber() {
        return listPhoneNumber;
    }

    public void setPhoneNumber(List<TypePhone> listPhoneNumber) {
        this.listPhoneNumber = listPhoneNumber;
    }

    @Override
    public String toString() {
        return "id = " + id + ", name = " + name + ", lastName = " + lastName + ", age = " + age + ", address = " + address +
                ", growth = " + growth + ", weight = " + weight + ", phoneNumber = " + listPhoneNumber;
    }

}
