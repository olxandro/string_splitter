package com.skypro.olexandro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String str = "dskfhf sdfhw sekejfh wkefh wekf ";
        split(str);
        splitTwo(str);
        System.out.println(splitSubstr(str, 7));
        splitPatt(str);

    }

    /*
    1. Использование библиотеки Guava.
     */

    public static void split(String s) {
        int chunkSize = 5;

        Iterable<String> chunks = Splitter.fixedLength(chunkSize).split(s);
        System.out.println(chunks);
    }

    /*
    2. Использование String.split() метод
     */
    public static void splitTwo(String s) {
        int chunkSize = 5;

        String[] chunks = s.split("(?<=\\G.{" + chunkSize + "})");
        System.out.println(Arrays.toString(chunks));
    }

    /*
    3. Использование String.substring() метод
     */
    public static List<String> splitSubstr(String s, int chunkSize) {
        List<String> chunks = new ArrayList<>();
        for (int i = 0; i < s.length(); i += chunkSize) {
            chunks.add(s.substring(i, Math.min(s.length(), i + chunkSize)));
        }
        return chunks;
    }

    /*
    4. Использование Pattern.compile() метод
     */
    public static void splitPatt(String s) {
        int chunkSize = 5;

        Matcher match = Pattern.compile(".{1," + chunkSize + "}").matcher(s);
        List<String> chunks = new ArrayList<>();
        while (match.find()) {
            chunks.add(s.substring(match.start(), match.end()));
        }
        System.out.println(chunks);
    }

}