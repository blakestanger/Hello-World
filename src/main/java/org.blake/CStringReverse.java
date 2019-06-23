package org.blake;

import java.lang.*;
public class CStringReverse {


    public static String reverse(String input){
        char[] data = input.toCharArray();
        int i = 0;
        int j= data.length-2;
        char temp;

        while (i < j){
            temp = data[i];
            data[i]= data[j];
            data[j] = temp;
            i++;
            j--;
        }

        String s = new String(data);
        return s;
    }
}

