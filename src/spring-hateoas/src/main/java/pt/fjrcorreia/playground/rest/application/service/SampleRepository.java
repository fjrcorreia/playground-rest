package pt.fjrcorreia.playground.rest.application.service;

import pt.fjrcorreia.playground.rest.api.Author;
import pt.fjrcorreia.playground.rest.api.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Francisco Correia
 */
public class SampleRepository {



    public static List<MessageImpl> getMessages(){
        List messages = new ArrayList();

        AuthorImpl author1 = new AuthorImpl(1L, "Sample Author1", "Dedicated Autor to write about void");
        AuthorImpl author2 = new AuthorImpl(2L, "Sample Author1", "Believer that every person should be treated fairly because we are all different");


        messages.add(new MessageImpl(1L, "The future is a constant while the past is a constant evolution", author1));
        messages.add(new MessageImpl(2L, "If tomorrow I go back past, it is still the future", author1));
        messages.add(new MessageImpl(3L, "For true equality, the respect for the difference is a requirement", author2));
        messages.add(new MessageImpl(4L, "Fighting against evil that does not exist, will create that evil", author2));


        return messages;
    }


}
