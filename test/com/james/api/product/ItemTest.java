package com.james.api.product;

import org.junit.jupiter.api.Assertions;

import static org.junit.Assert.assertEquals;

class ItemTest {

    @org.junit.jupiter.api.Test
    void systemOut() {
        Item s = new Item();
        String s3 = s.systemOut();
        System.out.println("-->"+s3);
        String s2 = "hello";
        Assertions.assertEquals(s.systemOut(), "hello");
    }

    @org.junit.jupiter.api.Test
    void add() {
        Item m = new Item();
        int result = Item.add(1,2);
        assertEquals(4, result);

    }
}