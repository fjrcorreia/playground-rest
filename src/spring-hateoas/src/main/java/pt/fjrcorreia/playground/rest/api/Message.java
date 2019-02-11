package pt.fjrcorreia.playground.rest.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author Francisco Correia
 */
@JsonPropertyOrder({"id", "message"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface Message {

    @JsonProperty("id")
    Long getMessageId();

    @JsonProperty("message")
    String getMessage();

}
