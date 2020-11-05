package ru.study.homework.homework1.task4;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

//    3. Создать объект (5-10 полей) через шаблон Builder и сохранить его в файл в виде JSON.
//    2 отдельных метода main.
//    1-й метод - берёт объект и сохраняет в JSON, и сохраняет в файл;
//    2-й метод - читает этот файл и из JSON собирает объект.
//    Для «кастования» в JSON использовать библиотеку Google – GSON.

        Scanner scn = new Scanner(System.in);

        String input = ""; // переменная для работы контекстного меню

        String pathFile = "src/main/java/ru.study.homework.homework2.homework1/task3/jsonFile.json"; // ссылка на файл с объектом
        String pathFileList = "src/main/java/ru.study.homework.homework2.homework1/task3/jsonListFile.json"; // ссылка на файл с объектом, включающим в себя список

        Person person = new Person();
        PersonList personList = new PersonList();

        JSONParser parser = new JSONParser();

        List<TypePhone> listTypePhone =  new ArrayList<>();

        while(!input.equals("7")){
            System.out.println("1. Создание объекта типа <Person>.");
            System.out.println("2. Создание объекта типа <PersonList> со списком.");
            System.out.println("3. Запись объекта <Person> в файл.");
            System.out.println("4. Чтение объекта <Person> из файла.");
            System.out.println("5. Запись объекта со списком <PersonList> в файл.");
            System.out.println("6. Чтение объекта со списком <PersonList> из файла.");
            System.out.println("7. Выход.");
            input = scn.nextLine();

            if(input.equals("1")){

                System.out.println("1. Создание объекта типа <Person>." + "\n");

                PersonBuilder personBuilder = new PersonBuilder();

                person = personBuilder
                        .setId(1)
                        .setName("Oleg")
                        .setLastName("Ivanov")
                        .setAge(30)
                        .setAddress("Moscow")
                        .setGrowth(185)
                        .setWeight(85)
                        .setPhoneNumber("123-45-67")
                        .build();

                System.out.println(person.toString());

            }
            else if(input.equals("2")){

                System.out.println("2. Создание объекта типа <PersonList> со списком.");

                PersonListBuilder personListBuilder = new PersonListBuilder();

                listTypePhone = Arrays.asList(new TypePhone("home", "111-22-33"), new TypePhone("work", "444-55-66"),
                        new TypePhone("mobile", "777-88-99"));

                personList = personListBuilder
                        .setId(2)
                        .setName("Ivan")
                        .setLastName("Barinov")
                        .setAge(40)
                        .setAddress("Rostov")
                        .setGrowth(175)
                        .setWeight(70)
                        .setPhoneNumber(listTypePhone)
                        .build();

                System.out.println(personList.toString());

            }

            else if(input.equals("3")){

                System.out.println("3. Запись объекта <Person> в файл." + "\n");

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", person.getId());
                jsonObject.put("name", person.getName());
                jsonObject.put("lastName", person.getLastName());
                jsonObject.put("age", person.getAge());
                jsonObject.put("address", person.getAddress());
                jsonObject.put("growth", person.getGrowth());
                jsonObject.put("weight", person.getWeight());
                jsonObject.put("phoneNumber", person.getPhoneNumber());

                String writedPerson = jsonObject.toJSONString();

                try(Writer wr = new FileWriter(pathFile)){
                    wr.write(writedPerson);
                }catch(Exception ex){
                    ex.printStackTrace();
                    System.out.println(ex);
                }

            }
            else if(input.equals("4")){

                System.out.println("4. Чтение объекта <Person> из файла." + "\n");

                try(FileReader fr = new FileReader(pathFile)){
                    JSONObject jsonObject = (JSONObject) parser.parse(fr);
                    long id = (long) jsonObject.get("id");
                    String name = (String) jsonObject.get("name");
                    String lastName = (String) jsonObject.get("lastName");
                    long age = (long) jsonObject.get("age");
                    String address = (String) jsonObject.get("address");
                    long growth = (long) jsonObject.get("growth");
                    long weight = (long) jsonObject.get("weight");
                    String phoneNumber = (String) jsonObject.get("phoneNumber");

                    Person readedPerson = new Person((int) id, name, lastName, (int) age, address, (int) growth, (int) weight, phoneNumber);

                    System.out.println(readedPerson.toString());
                }catch(Exception ex){
                    ex.printStackTrace();
                    System.out.println(ex);
                }

            }
            else if(input.equals("5")){

                System.out.println("5. Запись объекта со списком <PersonList> в файл." + "\n");

                JSONObject jsonObject = new JSONObject();
                jsonObject.put("id", personList.getId());
                jsonObject.put("name", personList.getName());
                jsonObject.put("lastName", personList.getLastName());
                jsonObject.put("age", personList.getAge());
                jsonObject.put("address", personList.getAddress());
                jsonObject.put("growth", personList.getGrowth());
                jsonObject.put("weight", personList.getWeight());

                JSONArray jsArray = new JSONArray();
                for (int i = 0; i < listTypePhone.size(); i++) {
                    JSONObject jsObject = new JSONObject();
                    jsObject.put("type", listTypePhone.get(i).getType());
                    jsObject.put("number", listTypePhone.get(i).getNumber());
                    jsArray.add(jsObject);
                }

                jsonObject.put("phoneNumber", jsArray);

                String jsonString = jsonObject.toJSONString();
                System.out.println(jsonString);

                try(Writer wr = new FileWriter(pathFileList)){
                    wr.write(jsonString);
                }catch(Exception ex){
                    ex.printStackTrace();
                    System.out.println(ex);
                }

            }
            else if(input.equals("6")){

                System.out.println("6. Чтение объекта со списком <PersonList> из файла." + "\n");

                try(FileReader fr = new FileReader(pathFileList)){
                    JSONObject jsonObject = (JSONObject) parser.parse(fr);
                    long id = (long) jsonObject.get("id");
                    String name = (String) jsonObject.get("name");
                    String lastName = (String) jsonObject.get("lastName");
                    long age = (long) jsonObject.get("age");
                    String address = (String) jsonObject.get("address");
                    long growth = (long) jsonObject.get("growth");
                    long weight = (long) jsonObject.get("weight");

                    List<TypePhone> listTypePhoneRead =  new ArrayList<>();
                    JSONArray jsonArray = (JSONArray) jsonObject.get("phoneNumber");

                    for(Object ob : jsonArray){
                        JSONObject typePhone = (JSONObject) ob;
                        String type = (String) typePhone.get("type");
                        String number = (String) typePhone.get("number");
                        TypePhone typePhone1 = new TypePhone(type, number);
                        listTypePhoneRead.add(typePhone1);
                    }

                    PersonList readedPersonList = new PersonList ((int) id, name, lastName, (int) age, address, (int) growth, (int) weight, listTypePhoneRead);

                    System.out.println(readedPersonList.toString());

                }catch(Exception ex){
                    ex.printStackTrace();
                    System.out.println(ex);
                }


            }
            else if(input.equals("7")){

                System.out.println("7. Выход.");

            }
            else{

                System.out.println("Некорректный ввод." + "\n");

            }
        }


    }
}
