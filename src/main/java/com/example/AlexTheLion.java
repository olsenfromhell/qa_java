package com.example;

/*
1. Создай класс льва Алекса из мультфильма «Мадагаскар». Он будет наследником обычного льва.
Помимо обычных методов у него есть свои:
- getFriends() возвращает список имён его друзей — зебры Марти, бегемотихи Глории и жирафа Мелман;
- getPlaceOfLiving() возвращает место, где он живёт — Нью-Йоркский зоопарк.

Также нужно переопределить метод getKittens(), потому что у Алекса нет львят.
А ещё — написать свой конструктор, так как в классе Lion нет дефолтного конструктора.
Алекс самец, поэтому в конструктор класса Lion всегда будет передаваться одно и то же значение.

2. Покрой тестами созданный класс.
 */

import java.util.Arrays;
import java.util.List;

public class AlexTheLion extends Lion {

    public AlexTheLion(Predator predator) throws Exception {
        super("Самец", predator);
    }

    public List<String> getFriends() {
        return Arrays.asList("Марти", "Глория", "Мелман");

    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }

    @Override
    public int getKittens() {
        return 0;
    }
}
