package ru.study.homework.homework1.task3;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

//    2. JAVA8 stream.
//    Создать объект Person (5-10 полей), заполнить 1000 объектов, положить их в stream.
//    С помощью stream:
//    - сортировать по разным параметрам;
//    - фильтровать по разным параметрам.


        Scanner scn = new Scanner(System.in);

        String input = "";

        List<Group> groups = new ArrayList<>();

        List<Person> listPerson1 = new ArrayList<>();
        List<Person> listPerson2 = new ArrayList<>();

        Group group1 = null;
        Group group2 = null;

        while(!input.equals("9")) {
            System.out.println("1. Создать список объектов типа <Person> в 2-х группах.");
            System.out.println("2. Считать все записи из списка, из всех групп.");
            System.out.println("3. Вывести всех людей из всех групп с одинаковым адресом.");
            System.out.println("4. Найти человека с максимальный возрастом из всех групп.");
            System.out.println("5. Общий вес всех людей из всех групп.");
            System.out.println("6. Найти человека по фамилии.");
            System.out.println("7. Получить все телефонные номера.");
            System.out.println("8. Получить все значения возрастов, которые больше 25 лет из всех групп.");
            System.out.println("9. Выход.");
            input = scn.nextLine();

            if (input.equals("1")) {
                System.out.println("1. Создать список объектов типа <Person> в 2-х группах." + "\n");

                PersonBuilder personBuilder1 = new PersonBuilder();
                Person person1 = personBuilder1
                        .setId(1)
                        .setName("Ivan")
                        .setLastName("Ivanov")
                        .setAge(30)
                        .setAddress("Russia")
                        .setGrowth(180)
                        .setWeight(90)
                        .setPhoneNumber("123-45-67")
                        .build();

                listPerson1.add(person1);

                PersonBuilder personBuilder2 = new PersonBuilder();
                Person person2 = personBuilder2
                        .setId(2)
                        .setName("Sergey")
                        .setLastName("Sergeev")
                        .setAge(40)
                        .setAddress("Russia")
                        .setGrowth(190)
                        .setWeight(80)
                        .setPhoneNumber("987-65-43")
                        .build();

                listPerson1.add(person2);

                PersonBuilder personBuilder3 = new PersonBuilder();
                Person person3 = personBuilder3
                        .setId(3)
                        .setName("Olga")
                        .setLastName("Lobanova")
                        .setAge(20)
                        .setAddress("France")
                        .setGrowth(170)
                        .setWeight(60)
                        .setPhoneNumber("111-22-33")
                        .build();

                listPerson1.add(person3);

                PersonBuilder personBuilder4 = new PersonBuilder();
                Person person4 = personBuilder4
                        .setId(4)
                        .setName("Irina")
                        .setLastName("Petrova")
                        .setAge(25)
                        .setAddress("France")
                        .setGrowth(165)
                        .setWeight(65)
                        .setPhoneNumber("444-55-66")
                        .build();

                listPerson2.add(person4);

                PersonBuilder personBuilder5 = new PersonBuilder();
                Person person5 = personBuilder5
                        .setId(5)
                        .setName("Pavel")
                        .setLastName("Rodionov")
                        .setAge(35)
                        .setAddress("Russia")
                        .setGrowth(185)
                        .setWeight(85)
                        .setPhoneNumber("777-88-99")
                        .build();

                listPerson2.add(person5);

                PersonBuilder personBuilder6 = new PersonBuilder();
                Person person6 = personBuilder6
                        .setId(6)
                        .setName("Anna")
                        .setLastName("Stogova")
                        .setAge(35)
                        .setAddress("France")
                        .setGrowth(175)
                        .setWeight(75)
                        .setPhoneNumber("999-88-77")
                        .build();

                listPerson2.add(person6);

                group1 = new Group(listPerson1);
                group2 = new Group(listPerson2);

                groups.add(group1);
                groups.add(group2);


            } else if (input.equals("2")){
                System.out.println("2. Считать все записи из списка, из всех групп." + "\n");

                groups.stream()
                        .map(Group::getPersons)
                        .flatMap(list -> list.stream())
                        .forEach(person -> System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %n",person.getId(), person.getName(),
                                person.getLastName(), person.getAge(), person.getAddress(), person.getGrowth(), person.getWeight(), person.getPhoneNumber()));
            }

            else if (input.equals("3")) {
                System.out.println("3. Вывести всех людей из всех групп с одинаковым адресом." + "\n");

                System.out.println("Input address:");
                String inputAddress = scn.nextLine();

                groups.stream()
                        .map(Group::getPersons)
                        .flatMap(list -> list.stream())
                        .filter(person -> person.getAddress().equals(inputAddress))
                        .forEach(person -> System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %n",person.getId(), person.getName(),
                                person.getLastName(), person.getAge(), person.getAddress(), person.getGrowth(), person.getWeight(), person.getPhoneNumber()));

            }

            else if(input.equals("4")){
                System.out.println("4. Найти человека с максимальный возрастом из всех групп." + "\n");

                OptionalInt maxTemp = groups.stream()
                        .map(Group::getPersons)
                        .flatMap(list -> list.stream())
                        .mapToInt(Person::getWeight)
                        .max();

                int maxWeight = maxTemp.getAsInt();

                groups.stream()
                        .map(Group::getPersons)
                        .flatMap(list -> list.stream())
                        .filter(person -> person.getWeight() == maxWeight)
                        .forEach(person -> System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %n",person.getId(), person.getName(),
                                person.getLastName(), person.getAge(), person.getAddress(), person.getGrowth(), person.getWeight(), person.getPhoneNumber()));

            }

            else if(input.equals("5")){
                System.out.println("5. Общий вес всех людей из всех групп." + "\n");

                int sumWeight = groups.stream()
                        .map(Group::getPersons)
                        .flatMap(list -> list.stream())
                        .mapToInt(Person::getWeight)
                        .sum();

                System.out.println("Total weight = " + sumWeight);

            }

            else if (input.equals("6")){
                System.out.println("6. Найти человека по фамилии." + "\n");

                System.out.println("Введите фамилию:");
                String inputLastName = scn.nextLine();

                groups.stream()
                        .map(Group::getPersons)
                        .flatMap(list -> list.stream())
                        .filter(person -> person.getLastName().equals(inputLastName))
                        .forEach(person -> System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %n",person.getId(), person.getName(),
                                person.getLastName(), person.getAge(), person.getAddress(), person.getGrowth(), person.getWeight(), person.getPhoneNumber()));

            }

            else if (input.equals("7")){
                System.out.println("7. Получить все телефонные номера." + "\n");

                List<String> listPhoneNumbers = groups.stream()
                        .map(Group::getPersons)
                        .flatMap(list -> list.stream())
                        .map(person -> person.getPhoneNumber())
                        .collect(Collectors.toList());

                System.out.println(listPhoneNumbers);

            }

            else if(input.equals("8")){
                System.out.println("8. Получить все значения возрастов, которые больше 25 лет из всех групп.");

                List<Integer> listAges = groups.stream()
                        .map(Group::getPersons)
                        .flatMap(list -> list.stream())
                        .map(person -> person.getAge())
                        .filter(age -> age > 25)
                        .collect(Collectors.toList());

                System.out.println(listAges);

            }

            else if (input.equals("9")){
                System.out.println("9. Выход.");

            }

            else{
                System.out.println("Некорректный ввод.");

            }

        }

    }
}