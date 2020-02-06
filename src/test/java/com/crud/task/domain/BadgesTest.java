package com.crud.task.domain;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BadgesTest {

    Trello trello;
    Trello trello2;
    AttachmentsByType attachmentsByType;
    AttachmentsByType attachmentsByType2;
    TrelloBadges badges;
    TrelloBadges badges2;

    @Before
    public void init(){
        //Given
        trello=new Trello();
        trello2=new Trello(1,1);
        attachmentsByType=new AttachmentsByType();
        attachmentsByType2=new AttachmentsByType(trello2);
        badges=new TrelloBadges();
        badges2=new TrelloBadges(2,attachmentsByType2);
    }

    @Test
    public void ShouldGetVotesTest() {
        //When
        int votes=badges2.getVotes();
        //Then
        Assert.assertEquals(2,votes);
    }

    @Test
    public void getAttachmentsByType() {
        // When
        AttachmentsByType attachmentsByTypeExpected=badges.getAttachmentsByType();
        //Then
        Assert.assertEquals(null,attachmentsByTypeExpected);
    }
}
