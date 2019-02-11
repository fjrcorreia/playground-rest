package pt.fjrcorreia.playground.rest.application.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;
import pt.fjrcorreia.playground.rest.api.Message;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Francisco Correia
 */
@Relation(value = "message", collectionRelation = "messages")
public class MessageImpl extends ResourceSupport implements Message {

    private final Long id;
    private final String message;

    private final AuthorImpl author;


    private final Map<String, List<? extends ResourceSupport>> embedded = new HashMap<>();


    public MessageImpl(Long id, String message, AuthorImpl author) {
        this.id = id;
        this.message = message;
        this.author = author;
    }


    @Override
    public Long getMessageId() {
        return id;
    }

    @Override
    public String getMessage() {
        return message;
    }


    @JsonIgnore
    public AuthorImpl getAuthor() {
        return author;
    }


    /**
     * Relations include in a single object when expand is used
     * @return
     */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @JsonProperty("_embedded")
    public Map<String, List<? extends ResourceSupport>> getEmbeddedResources() {
        return embedded;
    }

    public void addEmbedResources(String relName, List<? extends ResourceSupport> resources) {

        if (resources == null || resources.isEmpty()){
            return;
        }
        embedded.put(relName, resources);
    }
}
