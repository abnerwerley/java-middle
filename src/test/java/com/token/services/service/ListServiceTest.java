package com.token.services.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListServiceTest {

    private ListService utils;

    @BeforeEach
    void setup() {
        this.utils = new ListService();
    }

    @Test
    void shouldReturnListReordered() {
        ArrayList<Object> request = new ArrayList<>();
        request.add("user1");
        request.add("user2");
        request.add("user3");

        ArrayList<Object> response = utils.returArrayReordered(request);

        assertEquals("user3", response.get(0));
        assertEquals("user2", response.get(1));
        assertEquals("user1", response.get(2));
    }

    @Test
    void shouldReturnListReordered5Itens() {
        ArrayList<Object> request = new ArrayList<>();
        request.add(0);
        request.add(1);
        request.add(2);
        request.add(3);
        request.add(4);
        request.add(5);

        ArrayList<Object> response = utils.returArrayReordered(request);

        assertEquals(5, response.get(0));
        assertEquals(4, response.get(1));
        assertEquals(3, response.get(2));
        assertEquals(2, response.get(3));
        assertEquals(1, response.get(4));
        assertEquals(0, response.get(5));
    }

    @Test
    void shouldReturnSameArrayReordered() {
        ArrayList<Object> request = new ArrayList<>();
        request.add(1);
        request.add(2);
        request.add(3);

        ArrayList<Object> response = utils.returnSameArrayReordered(request);

        assertEquals(3, response.get(0));
        assertEquals(2, response.get(1));
        assertEquals(1, response.get(2));
    }

    @Test
    void shouldReturnSameArrayReorderedEvenSize() {
        ArrayList<Object> request = new ArrayList<>();
        request.add(1);
        request.add(2);
        request.add(3);
        request.add(4);

        ArrayList<Object> response = utils.returnSameArrayReordered(request);

        assertEquals(4, response.get(0));
        assertEquals(3, response.get(1));
        assertEquals(2, response.get(2));
        assertEquals(1, response.get(3));
    }

    @Test
    void shouldReturnSameListReordered() {
        List<Object> request = new ArrayList<>();
        request.add(1);
        request.add(2);
        request.add(3);

        List<Object> response = utils.returnSameListReordered(request);

        assertEquals(3, response.get(0));
        assertEquals(2, response.get(1));
        assertEquals(1, response.get(2));
    }

    @Test
    void shouldReturnSameListReorderedEvenSize() {
        List<Object> request = new ArrayList<>();
        request.add(1);
        request.add(2);
        request.add(3);
        request.add(4);

        List<Object> response = utils.returnSameListReordered(request);

        assertEquals(4, response.get(0));
        assertEquals(3, response.get(1));
        assertEquals(2, response.get(2));
        assertEquals(1, response.get(3));
    }
}
