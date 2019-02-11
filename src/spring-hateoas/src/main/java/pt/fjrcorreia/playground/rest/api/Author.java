package pt.fjrcorreia.playground.rest.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author Francisco Correia
 */

@JsonPropertyOrder({"id", "name", "description"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface Author {

    @JsonProperty("id")
    Long getAuthorId();

    @JsonProperty("name")
    String getName();

    @JsonProperty("description")
    String getDescription();

}
