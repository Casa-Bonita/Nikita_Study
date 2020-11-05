package ru.study.homework.homework1.task2;

import java.util.*;
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

        List<Person> listPerson = new ArrayList<>();

        while(!input.equals("9")) {
            System.out.println("1. Создать список объектов типа <Person>.");
            System.out.println("2. Считать все записи из списка.");
            System.out.println("3. Найти человека с максимальным возрастом.");
            System.out.println("4. Найти человека с минимальным ростом.");
            System.out.println("5. Общий вес всех людей в списке.");
            System.out.println("6. Найти человека по фамилии.");
            System.out.println("7. Получить все телефонные номера.");
            System.out.println("8. Получить все значения возрастов, которые больше 25 лет.");
            System.out.println("9. Выход.");
            input = scn.nextLine();

            if (input.equals("1")) {
                System.out.println("1. Создать список объектов типа <Person>." + "\n");

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

                listPerson.add(person1);

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

                listPerson.add(person2);

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

                listPerson.add(person3);

            } else if (input.equals("2")){
                System.out.println("2. Считать все записи из списка." + "\n");

                listPerson.stream()
                        .forEach(person -> System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %n",person.getId(), person.getName(),
                                person.getLastName(), person.getAge(), person.getAddress(), person.getGrowth(), person.getWeight(), person.getPhoneNumber()));
            }

            else if (input.equals("3")) {
                System.out.println("3. Найти человека с максимальным возрастом." + "\n");

                OptionalInt maxAgeTemp = listPerson.stream()
                        .mapToInt(Person::getAge)
                        .max();

                int maxAge = maxAgeTemp.getAsInt();

                listPerson.stream()
                        .filter(person -> person.getAge() == maxAge)
                        .map(Person::getName)
                        .forEach(System.out::println);

            }

            else if(input.equals("4")){
                System.out.println("4. Найти человека с минимальным ростом." + "\n");

                OptionalInt minTempGrowth = listPerson.stream()
                        .mapToInt(Person::getGrowth)
                        .min();

                int minGrowth = minTempGrowth.getAsInt();

                listPerson.stream()
                        .filter(person -> person.getGrowth() == minGrowth)
                        .map(Person::getName)
                        .forEach(System.out::println);

            }

            else if(input.equals("5")){
                System.out.println("5. Общий вес всех людей в списке." + "\n");

                int sumWeight = listPerson.stream()
                        .mapToInt(Person::getWeight)
                        .sum();

                System.out.println("Total weight = " + sumWeight);

            }

            else if (input.equals("6")){
                System.out.println("6. Найти человека по фамилии." + "\n");

                System.out.println("Введите фамилию:");
                String inputLastName = scn.nextLine();

                listPerson.stream()
                        .filter(person -> person.getLastName().equals(inputLastName))
                        .forEach(person -> System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %n",person.getId(), person.getName(),
                                person.getLastName(), person.getAge(), person.getAddress(), person.getGrowth(), person.getWeight(), person.getPhoneNumber()));

            }

            else if (input.equals("7")){
                System.out.println("7. Получить все телефонные номера." + "\n");

                List<String> listPhoneNumbers = listPerson.stream()
                        .map(person -> person.getPhoneNumber())
                        .collect(Collectors.toList());

                System.out.println(listPhoneNumbers);

            }

            else if(input.equals("8")){
                System.out.println("8. Получить все значения возрастов, которые больше 25 лет.");

                List<Integer> listAges = listPerson.stream()
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