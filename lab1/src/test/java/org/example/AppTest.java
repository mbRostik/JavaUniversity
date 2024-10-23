/*
@author   $Rostyslav_Daskaliuk
@project   $Practice 1. Integer to roman. 40 tests
@class  $444B
@since 19.10.2024 - 15.54
*/

package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    @Test
    public void testRomanToArabicI() {
        assertEquals(1, App.romanToArabic("I"));
    }

    @Test
    public void testRomanToArabicII() {
        assertEquals(2, App.romanToArabic("II"));
    }

    @Test
    public void testRomanToArabicIII() {
        assertEquals(3, App.romanToArabic("III"));
    }

    @Test
    public void testRomanToArabicIV() {
        assertEquals(4, App.romanToArabic("IV"));
    }

    @Test
    public void testRomanToArabicV() {
        assertEquals(5, App.romanToArabic("V"));
    }

    @Test
    public void testRomanToArabicIX() {
        assertEquals(9, App.romanToArabic("IX"));
    }

    @Test
    public void testRomanToArabicX() {
        assertEquals(10, App.romanToArabic("X"));
    }

    @Test
    public void testRomanToArabicXL() {
        assertEquals(40, App.romanToArabic("XL"));
    }

    @Test
    public void testRomanToArabicL() {
        assertEquals(50, App.romanToArabic("L"));
    }

    @Test
    public void testRomanToArabicXC() {
        assertEquals(90, App.romanToArabic("XC"));
    }

    @Test
    public void testRomanToArabicC() {
        assertEquals(100, App.romanToArabic("C"));
    }

    @Test
    public void testRomanToArabicCD() {
        assertEquals(400, App.romanToArabic("CD"));
    }

    @Test
    public void testRomanToArabicD() {
        assertEquals(500, App.romanToArabic("D"));
    }

    @Test
    public void testRomanToArabicCM() {
        assertEquals(900, App.romanToArabic("CM"));
    }

    @Test
    public void testRomanToArabicM() {
        assertEquals(1000, App.romanToArabic("M"));
    }

    @Test
    public void testRomanToArabicMMXX() {
        assertEquals(2020, App.romanToArabic("MMXX"));
    }

    @Test
    public void testRomanToArabicComplex1() {
        assertEquals(1987, App.romanToArabic("MCMLXXXVII"));
    }

    @Test
    public void testRomanToArabicComplex2() {
        assertEquals(1776, App.romanToArabic("MDCCLXXVI"));
    }

    @Test
    public void testRomanToArabicComplex3() {
        assertEquals(3999, App.romanToArabic("MMMCMXCIX"));
    }

    // Тесты для метода arabicToRoman
    @Test
    public void testArabicToRoman1() {
        assertEquals("I", App.arabicToRoman(1));
    }

    @Test
    public void testArabicToRoman2() {
        assertEquals("II", App.arabicToRoman(2));
    }

    @Test
    public void testArabicToRoman3() {
        assertEquals("III", App.arabicToRoman(3));
    }

    @Test
    public void testArabicToRoman4() {
        assertEquals("IV", App.arabicToRoman(4));
    }

    @Test
    public void testArabicToRoman5() {
        assertEquals("V", App.arabicToRoman(5));
    }

    @Test
    public void testArabicToRoman9() {
        assertEquals("IX", App.arabicToRoman(9));
    }

    @Test
    public void testArabicToRoman10() {
        assertEquals("X", App.arabicToRoman(10));
    }

    @Test
    public void testArabicToRoman40() {
        assertEquals("XL", App.arabicToRoman(40));
    }

    @Test
    public void testArabicToRoman50() {
        assertEquals("L", App.arabicToRoman(50));
    }

    @Test
    public void testArabicToRoman90() {
        assertEquals("XC", App.arabicToRoman(90));
    }

    @Test
    public void testArabicToRoman100() {
        assertEquals("C", App.arabicToRoman(100));
    }

    @Test
    public void testArabicToRoman400() {
        assertEquals("CD", App.arabicToRoman(400));
    }

    @Test
    public void testArabicToRoman500() {
        assertEquals("D", App.arabicToRoman(500));
    }

    @Test
    public void testArabicToRoman900() {
        assertEquals("CM", App.arabicToRoman(900));
    }

    @Test
    public void testArabicToRoman1000() {
        assertEquals("M", App.arabicToRoman(1000));
    }

    @Test
    public void testArabicToRoman2020() {
        assertEquals("MMXX", App.arabicToRoman(2020));
    }

    @Test
    public void testArabicToRomanComplex1() {
        assertEquals("MCMLXXXVII", App.arabicToRoman(1987));
    }

    @Test
    public void testArabicToRomanComplex2() {
        assertEquals("MDCCLXXVI", App.arabicToRoman(1776));
    }

    @Test
    public void testArabicToRomanComplex3() {
        assertEquals("MMMCMXCIX", App.arabicToRoman(3999));
    }

    @Test
    public void testRomanToArabicEmptyString() {
        assertEquals(0, App.romanToArabic(""));
    }

    

    @Test
    public void testRomanToArabicOrder() {
        assertEquals(1990, App.romanToArabic("MCMXC"));
    }

    @Test
    public void testRomanToArabicVI() {
        assertEquals(6, App.romanToArabic("VI"));
    }

    @Test
    public void testRomanToArabicXI() {
        assertEquals(11, App.romanToArabic("XI"));
    }

    @Test
    public void testArabicToRoman11() {
        assertEquals("XI", App.arabicToRoman(11));
    }

    @Test
    public void testArabicToRoman6() {
        assertEquals("VI", App.arabicToRoman(6));
    }

    @Test
    public void testEmptyRoman() {
        assertEquals(0, App.romanToArabic(""));
    }
}
