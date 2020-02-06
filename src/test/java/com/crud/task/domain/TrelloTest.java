package com.crud.task.domain;

import org.junit.Assert;
import org.junit.Test;

public class TrelloTest {
    @Test
    public void should(){
        //Given
        Trello trello=new Trello(3,4);
        Trello trello2=new Trello();
        //When
        int boardId=trello.getBoard();
        int boardId2=trello2.getBoard();
        int cardId=trello.getCard();
        int cardId2=trello2.getCard();
        //Then
        Assert.assertEquals(3,boardId);
        Assert.assertEquals(0,boardId2);
        Assert.assertEquals(4,cardId);
        Assert.assertEquals(0,cardId2);
    }
}
