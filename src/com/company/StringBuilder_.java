package com.company;

import java.util.Arrays;

public class StringBuilder_ {
    private StringBuilder strb;

    public StringBuilder_(StringBuilder string) throws Exception{
        String s = string.toString();
        s.split("[ ;]");
        if((string.toString().split("[ ;]").length) % 2 != 0) throw new Exception(new String("Не верно введённые  данные!!!!"));
            strb = string.append("");
    }

    public void output(){
        System.out.println(strb);
    }

    public void delete_zeros(){
        String [] str = strb.toString().split("[ ;]");

        for(int i = 0; i < str.length; i ++){
            if(str[i].equals("0")) {
                str[i-1] = "null";
                str[i] = "null";
            }
        }

        strb.delete(0, strb.length());
        String temp_ = new String();


        for(int i = 1; i <= str.length; i+=2){
            if(!str[i].equals("null")){
                temp_ += str[i-1] + " " + str[i] + ";";
                //System.out.println(str[i]);
            }
        }
        strb.append(temp_);
    }

    public void max_len_goods(){
        String [] str = strb.toString().split("[ ;]");

        int max_len = 0;
        int index_max = 0;
        int min_len = 999999999;
        int index_min = 0;

        for(int i = 0; i < str.length; i += 2){
            if(str[i].length() > max_len){
                max_len = str[i].length();
                index_max = i;
            }
        }

        for(int i = 0; i < str.length; i += 2){
            if(str[i].length() < min_len){
                min_len = str[i].length();
                index_min = i;
            }
        }

        System.out.println("Минимальная длинна информации о продаже : " + min_len + "\n"
                + str[index_min] + "(Товар) : " + str[index_min+1] + "(Цена)");

        System.out.println("Максимальная длинна информации о продаже : " + max_len + "\n"
                + str[index_max] + "(Товар) : " + str[index_max+1] + "(Цена)\n");

        str[index_min] = str[index_max];
        str[index_min+1] = str[index_max+1];

        for(int i = 0; i < str.length; i+=2){
            System.out.println(str[i] + "(Товар) : " + str[i+1] + "(Цена)");
        }
    }

    public void input_data(String input) throws Exception{
        if(input.split("[ ;]").length > 2) throw new Exception(new String("Вы ввели несколько товаров!\nВведите только один товар"));
        String [] temp = input.split("[ ;]");
        strb.append(temp[0] + " " + temp[1] + ";");
    }
}
