package com.demo.data;

import org.testng.annotations.DataProvider;

public class CredentialData{

    @DataProvider(name="vaild credential")
    public Object[][] giveVaildCredential(){
        Object[][] allCredential={{"standard_user","secret_sauce"}};
        return allCredential;
    }
}