package ru.study.homework.homework1.task4;

import java.util.List;

public class PersonListBuilder {

    private PersonList personList = new PersonList();

    public PersonListBuilder setId (int id){
        personList.setId(id);
        return this;
    }

    public PersonListBuilder setName (String name){
        personList.setName(name);
        return this;
    }

    public PersonListBuilder setLastName (String lastName){
        personList.setLastName(lastName);
        return this;
    }

    public PersonListBuilder setAge (int age){
        personList.setAge(age);
        return this;
    }

    public PersonListBuilder setAddress (String address){
        personList.setAddress(address);
        return this;
    }

    public PersonListBuilder setGrowth (int growth){
        personList.setGrowth(growth);
        return this;
    }

    public PersonListBuilder setWeight (int weight){
        personList.setWeight(weight);
        return this;
    }

    public PersonListBuilder setPhoneNumber (List<TypePhone> listPhoneNumber){
        personList.setPhoneNumber(listPhoneNumber);
        return this;
    }

    public PersonList build(){
        return personList;
    }

}
