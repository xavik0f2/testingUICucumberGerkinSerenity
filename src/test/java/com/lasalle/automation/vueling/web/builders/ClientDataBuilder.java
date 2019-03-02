package com.lasalle.automation.vueling.web.builders;

public class ClientDataBuilder {

    public static ClientBuilder defaultClient(Integer id){
        return ClientBuilder
                .aClient()
                .withId(id)
                .withName("SomeOne At the end of the bar")
                .withEmail("something@mail.com")
                .withPhone("33213213");
    }
}
