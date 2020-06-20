package ru.sultanov;

import java.util.Scanner;

public class VendingAutomat {

    public static void main(String[] args) {

        int cash = 0;     // Деньги, внесенные на счет автомата
        int userChoice = 0; // Выбор в меню пользователя

        while (userChoice != 4) {         // Пока не выбран пункт "Выйти", выполнять программу
            System.out.println("\nНа вашем счете - " + cash + " рублей.\n " +
                    "Введите цифру для действия:\n1 - Посмотреть меню" +
                    " напитков\n2 - Внести деньги\n3 - Купить напиток\n" +
                    "4 - Выйти");
            Scanner sc = new Scanner(System.in);
            userChoice = sc.nextInt();

            switch (userChoice) {
                case 1:
                    for (Drinks d : Drinks.values()) {
                        System.out.println(d.getPosition() + "." + d.getName() +
                                "........." + d.getPrice() + " рублей");
                    }
                    break;
                case 2:
                    System.out.println("Введите сумму в рублях");
                    cash += sc.nextInt();
                    break;
                case 3:
                    System.out.println("Введите позиционный номер напитка");
                    int drinkChoice = sc.nextInt();
                    if (drinkChoice > 6) {
                        System.out.println("Напитка под этим номером нет");
                    }
                    for (Drinks d : Drinks.values()) {
                        if (d.getPosition() == drinkChoice) {
                            if (cash >= d.getPrice()) {
                                cash -= d.getPrice();
                            } else {
                                System.out.println("Недостаточно средств");
                            }

                        }
                    }
                    break;
            }
        }
    }
}

