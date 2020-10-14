package com.example.mangomessages;

import com.example.mangomessages.MongoDB.MongoStoreText;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MongoStoreTextTest {
    @Test
    public void storeTextToDB() {
        MongoStoreText mongoStoreText = new MongoStoreText();

        assertEquals(true, mongoStoreText.storeTextToDB("Testing This for Unit Test"));
        assertEquals(true, mongoStoreText.storeTextToDB(""));
        assertEquals(true, mongoStoreText.storeTextToDB("1 2 3 4 5 6 7 8 9 10"));
        assertEquals(true, mongoStoreText.storeTextToDB("Priya Jaswal"));
        assertEquals(true, mongoStoreText.storeTextToDB("Star Wars if fun!!!!!"));
        assertEquals(true, mongoStoreText.storeTextToDB("When will Homelander go crazy?"));
    }
}
