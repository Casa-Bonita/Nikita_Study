package ru.study.homework.homework1.task4;

public class PersonBuilder {

    private Person person = new Person();

    public PersonBuilder setId (int id){
        person.setId(id);
        return this;
    }

    public PersonBuilder setName (String name){
        person.setName(name);
        return this;
    }

    public PersonBuilder setLastName (String lastName){
        person.setLastName(lastName);
        return this;
    }

    public PersonBuilder setAge (int age){
        person.setAge(age);
        return this;
    }

    public PersonBuilder setAddress (String address){
        person.setAddress(address);
        return this;
    }

    public PersonBuilder setGrowth (int growth){
        person.setGrowth(growth);
        return this;
    }

    public PersonBuilder setWeight (int weight){
        person.setWeight(weight);
        return this;
    }

    public PersonBuilder setPhoneNumber (String phoneNumber){
        person.setPhoneNumber(phoneNumber);
        return this;
    }

    public Person build (){
        return person;
    }
}
