package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class String_ {

    Scanner scanner = new Scanner(System.in);

    private String txt;
    private String[] temp;
    private List<String[]> str = new ArrayList<String[]>();

    public String_(String string) throws Exception{
        this.txt = string;
        temp = this.txt.split(";");
        for(String elem : temp){
            if(((elem.split(" ").length) % 2) != 0)
                throw new Exception(new String("Не верно введённые данные!!!!"));
            else
                str.add(elem.split(" "));
        }
    }

    public void output_list(){
        for(String[] elems : str){
            for(int i = 0; i < elems.length / 2; i++)
                System.out.println(elems[i] + "(Товар) : " + elems[i+1] + "(Цена)");
        }
    }

    public int summ(){
        int summ = 0;
        for(String[] elems : str){
            for(int i = 1; i < elems.length; i++)
                summ += Integer.parseInt(elems[i]);
        }
        return summ;
    }

    public void convert_to_lower(){
        for(String[] elems : str){
            for(int i = 0; i < elems.length / 2; i++)
                elems[i] = elems[i].toLowerCase();
        }
        output_list();
    }

    public String rating(){
        String [] merchandise = new String[str.size()];
        int [] counter = new int[str.size()];
        String res = new String();
        Arrays.fill(counter, 0);

        int i = 0;

        //Формирование массива из списка товаров
        for(String [] elems : str){
            if(!Arrays.stream(merchandise).anyMatch(elems[0]::equals))
                merchandise[i] = elems[0];
            i++;
        }

        //Перебор и составление второго массива с количеством встречающихся элементов где индексы одинкавоые (товар) : (число встреч в списке)
        for(String [] elems : str){
            int c = 0;
            for(int j = 0; j < merchandise.length; j++){
                if(elems[0].equals(merchandise[j])){
                     counter[c] += 1;
                }
                c++;
            }
        }
        for(int j = 0; j < merchandise.length; j++) {
            if (merchandise[j] != null && !(counter[j] == 0))
                res += merchandise[j] + " " + counter[j] + "\n";
        }
        return res;
    }

    public void output_elem(int index) throws IndexOutOfBoundsException{
        if(index >= str.size()) throw new IndexOutOfBoundsException( new String("Введенный индекс выходит за рамки массива!!!") );
        System.out.println( "Элемент под индексом[" + index + "] : " + str.get(index)[0] + "(Товар) : " +  str.get(index)[1] + "(Цена)" );
    }

}
