package ru.study.homework.homework1.task3;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private List<Person> persons = new ArrayList<>();

    public Group(List<Person> persons) {
        this.persons = persons;
    }

    public List<Person> getPersons() {
        return persons;
    }

    @Override
    public String toString() {
        return "persons = " + persons;
    }
}
