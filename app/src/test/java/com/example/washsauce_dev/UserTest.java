package com.example.washsauce_dev;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void getName() {
        User person = new User();
        person.name = "john";
        assertEquals(person.name, person.getName());
    }

    @Test
    public void setName() {
        User person = new User();
        person.setName("John");
        assertEquals(person.name, "John");
    }
}