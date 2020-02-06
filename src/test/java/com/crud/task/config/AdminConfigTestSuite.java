package com.crud.task.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminConfigTestSuite {
    @Autowired
    AdminConfig adminConfig;

    @Test
    public void shouldgetAdminMail(){

        //Given && When
        String mail =adminConfig.getAdminMail();

        //Then
        Assert.assertEquals("brbb0463@gmail.com",mail);

    }
}
