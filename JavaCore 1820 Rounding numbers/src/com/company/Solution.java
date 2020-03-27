package com.company;

/*
1820 Rounding numbers
Read 2 file names from the console.
The first file contains real (fractional) numbers, separated by a space. For example, 3.1415.
Round the numbers to integers and write them with a space in the second file.
Close streams.
Rounding principle:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4

Requirements:
1. The program should read the file names from the console twice.
2. For the first file, create a stream for reading. For the second, a stream for recording.
3. Read the numbers from the first file, round them and write a space in the second.
4. The rounding principles specified in the assignment must be observed.
5. Streams created for files must be closed.
 */

import java.io.*;
import java.util.ArrayList;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        //Читаем файл
        ArrayList<String> list = new ArrayList<String>();
        BufferedReader f1 = new BufferedReader(new FileReader(fileName1));
        while (f1.ready())
            list.add(f1.readLine());
        f1.close();

        //Парсим и округляем
        ArrayList<Long> values = new ArrayList<Long>();
        for (String s : list) {
            for (String part : s.split(" ")) {
                double a = Double.parseDouble(part);
                values.add(Math.round(a));
            }
        }
        f1.close();

        //Запись в файл
        FileWriter f2 = new FileWriter(fileName2);
        for (Long value : values)
            f2.write( value.toString()+" ");

        f2.close();
    }
}





