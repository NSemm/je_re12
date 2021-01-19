package com.k7;

import com.k7.groupPayments.*;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        String text = "Повседневная практика 0632354441  показывает, что рамки и место обучения " +
                "кадров способствует подготовки и реализации систем 674569874массового участия. С другой 80676459861" +
                " стороны рамки и место обучения кадров позволяет о +380677841120 ценить значение" +
                " систем массового участия. С другой 7758845 стороны рамки и место обучения кадров" +
                " 0632354441 обеспечивает широкому кругу (специалистов) участие в формировании модели" +
                " развития. 674569874 0632383652 Разнообразный 80654569874 и богатый опыт рамки и место" +
                " обучения +380677841120 кадров позволяет 0632354441 выполнять важные задания по разработке дальнейших" +
                " направлений 674569874 развития. ";

        PhoneParser phoneParser = new PhoneParser(text);
        Scanner sc = new Scanner(System.in);
        Payments payments = new Payments();
        Parser parser = new Parser(payments);
        //UserInput userInput = new ConsoleUserInput(sc, parser);
        UserInput userInput = new StringUserInput(parser);
        Calculation calculation = new Calculation(payments);


        phoneParser.formatter();


        String[] input = {"-700 закупка аппаратуры",
                "-150 услуги почты",
                "+480 аренда помещений",
                "+150 аренда подвижного состава",
                "+2000 продажа товара",
                "-200 услуги почты",
                "-4500 штрафные санкции",
                "+100 аренда помещений",
                "-50 канцелярия",
                "END"};


        System.out.println("Grouping payments");
        System.out.println("----------------------------");
        System.out.println("Enter your income and expense");
        //userInput.start(sc.nextLine()); //for ConsoleUserInput
        userInput.start(input); //for StringUserInput
        //payments.showPayments();
        calculation.showResult();
    }
}
