package pt.fjrcorreia.playground.rest.application.service;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.PagedResources;
import org.springframework.stereotype.Service;
import pt.fjrcorreia.playground.rest.api.Author;
import pt.fjrcorreia.playground.rest.api.Message;
import pt.fjrcorreia.playground.rest.application.controller.SampleController;

import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

/**
 * @author Francisco Correia
 */

@Service
public class MessagesService {

    public static final String EXPAND_AUTHOR = "author";


    public List<MessageImpl> getMessages(String expand){
        List<MessageImpl> messages = new ArrayList<>();
        for (MessageImpl m: SampleRepository.getMessages()){
            //Link self
            m.add(linkTo(methodOn(SampleController.class).getMessage(m.getMessageId(), null)).withSelfRel());
            m.add(linkTo(methodOn(SampleController.class).getAuthor(m.getAuthor().getAuthorId(), null)).withRel("author"));

            if (expand != null && expand.contains("author")){
                m.addEmbedResources("author", Collections.singletonList(m.getAuthor()));
            }

            messages.add(m);
        }
        return messages;
    }


    public PagedResources<Message> getPagedMessages(String expand){
        List<MessageImpl> messages = getMessages(expand);
        PagedResources.PageMetadata pageMeta = new PagedResources.PageMetadata(10, 0, messages.size(), 1);
        PagedResources messagesPage = new PagedResources(messages, pageMeta);
        return messagesPage;
    }


    public Message getMessageById(Long id, String expand){
        for(Message m : getMessages(expand)){
            if (m.getMessageId().equals(id)){
                return m;
            }
        }
        return null;
    }



    public List<Author> getAuthors(){
        Map<Long, AuthorImpl> authorsMap = new HashMap<>();
        for (MessageImpl m: SampleRepository.getMessages()){
            AuthorImpl author = m.getAuthor();
            authorsMap.put(author.getAuthorId(), author);
        }


        List<Author> authors = new ArrayList<>();
        for (AuthorImpl a: authorsMap.values()){
            a.add(linkTo(methodOn(SampleController.class).getAuthor(a.getAuthorId(), null)).withSelfRel());
            authors.add(a);
        }
        return authors;
    }



    public PagedResources<Author> getPagedAuthors(){
        List<Author> authors = getAuthors();
        PagedResources.PageMetadata pageMeta = new PagedResources.PageMetadata(10, 0, authors.size(), 1);
        PagedResources authorsPage = new PagedResources(authors, pageMeta);
        return authorsPage;
    }


    public Author getAuthorById(Long id){
        for(Author a : getAuthors()){
            if (a.getAuthorId().equals(id)){
                return a;
            }
        }
        return null;
    }

}
