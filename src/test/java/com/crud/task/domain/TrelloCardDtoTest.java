package com.crud.task.domain;

import org.junit.Assert;
import org.junit.Test;

public class TrelloCardDtoTest {
    @Test
    public void TrelloCardDtoTest(){
        //Given
        TrelloCardDto trelloCardDto=new TrelloCardDto();
        //When
        String name=trelloCardDto.getName();
        String desc=trelloCardDto.getDescription();
        String listId=trelloCardDto.getListId();
        String pos=trelloCardDto.getPos();
        //Then

        Assert.assertEquals(null,name);
        Assert.assertEquals(null,desc);
        Assert.assertEquals(null,listId);
        Assert.assertEquals(null,pos);

    }
}
