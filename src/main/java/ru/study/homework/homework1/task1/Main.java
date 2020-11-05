package ru.study.homework.homework1.task1;

public class Main {

    public static void main(String[] args) {

//    1. Создать ссылку объектов друг на друга в куче (Heap);

        One one = new One();
        Ten ten = new Ten();

        one.ten = ten;
        ten.one = one;
        one.a();
        one = null;
    }
}