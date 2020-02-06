package com.crud.task.config;

import com.crud.task.trello.TrelloConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloConfigTest {
    @Autowired
    TrelloConfig trelloConfig;

    @Test
    public void shouldGetTrelloApiEndpoint() {
        //Given && When
        String endpoint =trelloConfig.getTrelloApiEndpoint();

        //Then
        Assert.assertEquals("https://api.trello.com/1",endpoint);
    }

    @Test
    public void shouldGetTrelloAppKey() {
        //Given && When
        String appKey =trelloConfig.getTrelloAppKey();

        //Then
        Assert.assertEquals("a89524e17e71f5cacc279cda42426a7d",appKey);
    }

    @Test
    public void shouldGetTrelloToken() {
        //Given && When
        String appToken =trelloConfig.getTrelloToken();

        //Then
        Assert.assertEquals("15bc03a552155d59447f8421bbbf36181125b7dfc467369a45f522122a4e3be5",appToken);
    }

    @Test
    public void shouldGetTrelloUsername() {
        //Given && When
        String username =trelloConfig.getTrelloUsername();

        //Then
        Assert.assertEquals("beatabliniewska",username);
    }
}
