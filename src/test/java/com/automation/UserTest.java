package com.automation;

import org.testng.annotations.*;

import javax.jws.soap.SOAPBinding;

import static org.testng.Assert.assertEquals;

public class UserTest {
    private User user;
    @BeforeClass

    public void beforeClass(){
        System.out.println("beforeClass");
        System.out.println("set up");

    }
    @AfterClass
    public void afterClass(){
        System.out.println("afterClass");
        System.out.println("stop");

    }


    @BeforeMethod
    public void beforeMetod(){
        System.out.println("before");
        user=new User("Bob",30);

    }

    @AfterMethod
    public void afterMetod(){
        System.out.println("after");


    }
    @Test
    public void userNameTest(){
        System.out.println("test");
        assertEquals(user.getName(),"Bob");
    }

    @Test
    public void userAgeTest(){
        System.out.println("test");
        assertEquals(user.getAge(),30);
    }

}
