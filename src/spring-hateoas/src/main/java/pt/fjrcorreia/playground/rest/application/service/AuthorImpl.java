package pt.fjrcorreia.playground.rest.application.service;

import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;
import pt.fjrcorreia.playground.rest.api.Author;

/**
 * @author Francisco Correia
 */
@Relation(value = "author", collectionRelation = "authors")
public class AuthorImpl extends ResourceSupport implements Author {

    private final Long id;
    private final String name;
    private final String description;


    public AuthorImpl(Long id, String name, String description){
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public Long getAuthorId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
