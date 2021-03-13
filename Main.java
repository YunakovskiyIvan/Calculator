package com.metanit;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;


class Calculator {

    public static int Sum(int a, int b) {
        int x = a + b;
        return x;
    }

    public static int Subtraction(int a, int b) {
        int x = a - b;
        return x;
    }

    public static int Multiplication(int a, int b) {
        int x = a * b;
        return x;
    }

    public static int Division(int a, int b) {
        int x = a / b;
        return x;
    }
}

public class Main {

    public static boolean CheckType(String a, String b) {

        List<String> list = Arrays.asList(new String[]{ "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X" });

        boolean contains = (list.contains(a) && list.contains(b));

        if (!contains) {
            if(!list.contains(a) && !list.contains(b)) return false;
            else {
                System.out.println("Ошибка, вы ввели неверные входные данные!");
                System.exit(0);
            }
        }

        return true;
    }

    public static int ConvertRomanToArabic(String strValue) {

        int intValue;

        switch (strValue) {
            case "I":
                intValue = 1;
                break;
            case "II":
                intValue = 2;
                break;
            case "III":
                intValue = 3;
                break;
            case "IV":
                intValue = 4;
                break;
            case "V":
                intValue = 5;
                break;
            case "VI":
                intValue = 6;
                break;
            case "VII":
                intValue = 7;
                break;
            case "VIII":
                intValue = 8;
                break;
            case "IX":
                intValue = 9;
                break;
            case "X":
                intValue = 10;
                break;
            default:
                intValue = -1;
                break;
        }

        return intValue;
    }

    public static void PrintArabic(int number) {

        System.out.printf("Result: ");
        System.out.println(number);
    }

    public static void PrintRoman(int number) {
        int num[] = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
        String sym[] = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
        int i = 12;

        System.out.printf("Result: ");

        while (number > 0)
        {
            int div = number / num[i];
            number = number % num[i];
            while (div-- > 0)
            {
                System.out.printf(sym[i]);
            }

            i--;
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.printf("Input numbers: ");
        String firstvalue = in.next();
        char sign = in.next().charAt(0);;
        String secondvalue = in.next();

        in.close();

        Calculator calculator = new Calculator();
        int firstNumber;
        int secondNumber;
        boolean isRoman = CheckType(firstvalue, secondvalue);

        if (isRoman) {
            firstNumber = ConvertRomanToArabic(firstvalue);
            secondNumber = ConvertRomanToArabic(secondvalue);
        }

        else {
            firstNumber = Integer.valueOf(firstvalue);
            secondNumber = Integer.valueOf(secondvalue);
        }

        int result = 0;

        switch (sign) {

            case '+':
                result = calculator.Sum(firstNumber, secondNumber);
                break;

            case '-':
                result = calculator.Subtraction(firstNumber, secondNumber);
                break;

            case '*':
                result = calculator.Multiplication(firstNumber, secondNumber);
                break;

            case '/':
                result = calculator.Division(firstNumber, secondNumber);
                break;

            default:
                System.out.println("Ошибка, введена неверная арифметическая операция");
                System.exit(0);
        }
        if (isRoman) {
            PrintRoman(result);
        }
        else {
            PrintArabic(result);
        }

    }

}