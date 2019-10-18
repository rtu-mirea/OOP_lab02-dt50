package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
	// write your code here
        try {
            Scanner scanner = new Scanner(System.in);
            String var;
            System.out.println("Тест работы 'String_'");
            System.out.println("Введите список товаров следующем образом.");
            System.out.println("Товар Цена;Товар Цена;Товар Цена; ... ");

            var = scanner.nextLine();
            String_ string_ = new String_(var);
            string_.output_list();
            System.out.println("\n Задание №1\n");
            System.out.println("Сумма всех покупок : " + string_.summ() + " рублей.");
            System.out.println("\n Задание №2\n");
            System.out.println("Название товара прописными буквами");
            string_.convert_to_lower();
            System.out.println("\n Задание №3\n");
            System.out.println("Вывод количества повторений товаров в списке");
            System.out.println(string_.rating());
            System.out.println("\n Задание №4\n");
            System.out.print("Ведите индекс массива что бы вывести этот эллемент : ");
            string_.output_elem(scanner.nextInt());

            System.out.println("Тест работы 'StringBuilder_'");
            System.out.println("Введите список товаров следующем образом.");
            System.out.println("Товар Цена;Товар Цена;Товар Цена; ... ");

            var = scanner.nextLine();
            StringBuilder_ stringBuilder_ = new StringBuilder_(new StringBuilder(var));
            System.out.println("\nЗадание №1\n");
            System.out.println("Удаляем все записи, где цена равна 0(нулю)");
            stringBuilder_.delete_zeros();
            stringBuilder_.output();
            System.out.println("\n Задание №2\n");
            System.out.println("Заменить информацию товара имеющую " +
                   "самую маленькую длинну информации на наиюольшую");
            stringBuilder_.max_len_goods();
            System.out.println("\n Задание №3\n");
            System.out.println("Введите новые данные");
            stringBuilder_.input_data(scanner.nextLine());
            stringBuilder_.output();


            System.out.println("Введите дату в Англиском или руском формате");
            System.out.println("Русский формат : ДД.ММ.ГГГГ");
            System.out.println("Английский формат : МЕСЯЦ ДД, ГГГГ");

            var = scanner.nextLine();
            RegEx regEx = new RegEx(var);
            System.out.println(regEx.Eng_or_Russ());

            System.out.println("Введите строку где есть Английский формат записи даты для изменения его на Русский формат");

            var = scanner.nextLine();
            regEx = new RegEx(var);
            regEx.change_date();
        }catch (Exception e) {
            System.out.println(e.toString());
        }

    }


}
