/*
@author   $Rostyslav_Daskaliuk
@project   $Roman to integer. 10 tests.
@class  $444B
@since 19.10.2024 - 15.54
*/

package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    void testRomanToArabic_I() {
        assertEquals(1, App.romanToArabic("I"));
    }

    @Test
    void testRomanToArabic_II() {
        assertEquals(2, App.romanToArabic("II"));
    }

    @Test
    void testRomanToArabic_III() {
        assertEquals(3, App.romanToArabic("III"));
    }

    @Test
    void testRomanToArabic_IV() {
        assertEquals(4, App.romanToArabic("IV"));
    }

    @Test
    void testRomanToArabic_V() {
        assertEquals(5, App.romanToArabic("V"));
    }

    @Test
    void testRomanToArabic_VI() {
        assertEquals(6, App.romanToArabic("VI"));
    }

    @Test
    void testRomanToArabic_IX() {
        assertEquals(9, App.romanToArabic("IX"));
    }

    @Test
    void testRomanToArabic_X() {
        assertEquals(10, App.romanToArabic("X"));
    }

    @Test
    void testRomanToArabic_XL() {
        assertEquals(40, App.romanToArabic("XL"));
    }

    @Test
    void testRomanToArabic_L() {
        assertEquals(50, App.romanToArabic("L"));
    }

    @Test
    void testRomanToArabic_XC() {
        assertEquals(90, App.romanToArabic("XC"));
    }

    @Test
    void testRomanToArabic_C() {
        assertEquals(100, App.romanToArabic("C"));
    }

    @Test
    void testRomanToArabic_CD() {
        assertEquals(400, App.romanToArabic("CD"));
    }

    @Test
    void testRomanToArabic_D() {
        assertEquals(500, App.romanToArabic("D"));
    }

    @Test
    void testRomanToArabic_MCMLXXXVII() {
        assertEquals(1987, App.romanToArabic("MCMLXXXVII"));
    }
}
