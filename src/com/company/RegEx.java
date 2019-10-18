package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegEx {
    private String INPUT;
    private Pattern pattern_Eng = Pattern.compile("(\\w{3,9})\\s([0-2][0-9]|3[0-1]),\\s(\\d{3,4})");
    private Pattern pattern_Russ = Pattern.compile("([0-2][0-9]|3[0-1]).(0[1-9]|1[0-2]).(\\d{3,4})");
    private String [] month = { "January","February", "March", "April", "May", "June", "July", "August", "September", "October",
            "November", "December" };
    public RegEx(String str){
        INPUT = str;
    }

    public String Eng_or_Russ(){
        Matcher matcher_Eng = pattern_Eng.matcher(INPUT);
        Matcher matcher_Russ = pattern_Russ.matcher(INPUT);
        if(matcher_Eng.matches()) return "В введенных данных нашлась Английская дата";
        if(matcher_Russ.matches()) return "В введенных данных нашлась Русская дата";
        return "Введенная дата не соответствует ни русской ни английской записи дат";
    }

    public void change_date() throws Exception{
        Matcher matcher_Eng = pattern_Eng.matcher(INPUT);
        String date_eng = "";

        int start = 0;
        int end = 0;

        while (matcher_Eng.find()){
            start = matcher_Eng.start();
            end = matcher_Eng.end();
            date_eng = INPUT.substring(start,end);
            System.out.println("Найдено совпадение " + date_eng + " с "+ start + " по " + (end-1) + " позицию");
        }

        if(date_eng == "") throw new Exception(new String("В введенных данных не было найдено даты или " +
                "введенная дата не в Английском формате !!!"));

        String [] split_date = date_eng.split("[ ,]");

        int index = 999;

        for(int i = 0; i < month.length; i++){
            if(split_date[0].equals(month[i])) index = i;
        }

        if(index == 999) throw new Exception(new String("Месяц был неправильно написан!!!"));


        split_date[0] = split_date[1] + ".";
        split_date[1] = String.valueOf(index+1) + ".";

        String date_rus = "";

        for(String elem : split_date)
            date_rus += elem;

        String new_INPUT = "";

        new_INPUT = INPUT.substring(0, start-1) + " " + date_rus;
        INPUT = new_INPUT;

        System.out.println(INPUT);
    }
}
