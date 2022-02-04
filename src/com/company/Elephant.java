package com.company;

import java.util.HashSet;
import java.util.Scanner;

public class Elephant {
    Scanner scanner = new Scanner(System.in);//Считыване с консоли
    HashSet<String> otmazki = new HashSet<>();//Коллекция

    public void buyElephant() { //Реализация метода
        System.out.println("Купи слона");
        boolean flagElephant = false; //флаг для выхода из цикла
        while (flagElephant == false) { // сам цикл
            String name = this.scanner.nextLine(); // считывание даных из консоли. this потому что данные вне метода
            if (name.toLowerCase().equals("хорошо")) { //сравнение строк через equals обязательно
                System.out.print("Ну и отлично. Твои отмазки - ");
                flagElephant = true;
                for (String str:otmazki) // Использование итератора для вывода всех отмаз
                    System.out.print(str+",");
            } else {
                otmazki.add(name);
                System.out.println("Ну купи слона");
            }
        }
    }
}
