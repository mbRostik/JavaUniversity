/*
@author   $Rostyslav_Daskaliuk
@project   $Practice 1. Integer to roman. 40 tests
@class  $444B
@since 19.10.2024 - 15.54
*/

package org.example;
import java.util.HashMap;
import java.util.Map;
public class App 
{
    private static final Map<Character, Integer> romanToArabicMap = new HashMap<>();
    private static final int[] arabicValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] romanNumerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    static {
        romanToArabicMap.put('I', 1);
        romanToArabicMap.put('V', 5);
        romanToArabicMap.put('X', 10);
        romanToArabicMap.put('L', 50);
        romanToArabicMap.put('C', 100);
        romanToArabicMap.put('D', 500);
        romanToArabicMap.put('M', 1000);
    }

    public static int romanToArabic(String roman) {
        int result = 0;
        for (int i = 0; i < roman.length(); i++) {
            int current = romanToArabicMap.get(roman.charAt(i));
            if (i < roman.length() - 1 && current < romanToArabicMap.get(roman.charAt(i + 1))) {
                result -= current;
            } else {
                result += current;
            }
        }
        return result;
    }

    public static String arabicToRoman(int number) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < arabicValues.length; i++) {
            while (number >= arabicValues[i]) {
                result.append(romanNumerals[i]);
                number -= arabicValues[i];
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String romanNumeral = "XXVII";
        int arabicNumeral = romanToArabic(romanNumeral);
        System.out.println("Rom numb " + romanNumeral + " = : " + arabicNumeral);

        int arabicNumber = 27;
        String romanResult = arabicToRoman(arabicNumber);
        System.out.println("Arabian " + arabicNumber + " = : " + romanResult);
    }
}