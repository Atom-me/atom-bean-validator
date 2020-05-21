package com.atom.beanvalidator;

import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * @author Atom
 */
public class SimpleTest {

    @Test
    public void testObjectsEquals() {

        System.out.println(Objects.equals("", ""));//true
        System.out.println(Objects.equals("", "a"));//false
        System.out.println(Objects.equals("", 4));//false
        System.out.println(Objects.equals("", null));//false
        System.out.println(Objects.equals(null, null));//true
        System.out.println(Objects.equals(99, 99));//true
        System.out.println(Objects.equals("abc", new String("abc")));//true
    }
}
