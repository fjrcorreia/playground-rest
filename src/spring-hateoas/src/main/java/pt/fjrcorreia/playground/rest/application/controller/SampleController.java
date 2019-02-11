package pt.fjrcorreia.playground.rest.application.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pt.fjrcorreia.playground.rest.api.Author;
import pt.fjrcorreia.playground.rest.api.Message;
import pt.fjrcorreia.playground.rest.api.RestConstants;
import pt.fjrcorreia.playground.rest.application.service.MessagesService;

/**
 * @author Francisco Correia
 */

@RestController
@Api(value = "Playground Controller", description = "Controller to sample REST service using HATEOAS")
@RequestMapping(value = RestConstants.REST_BASE_PATH, produces = MediaTypes.HAL_JSON_VALUE)
public class SampleController {


    @Autowired
    private MessagesService messagesService;

    @ApiOperation(value = "Messages Lookup", notes = "Sample messages from some authors")
    @RequestMapping(method = RequestMethod.GET, value = RestConstants.REST_MESSAGES_PATH)
    public ResponseEntity<PagedResources<Message>> listMessages(String expand) {

        PagedResources<Message> pagedMessages = messagesService.getPagedMessages(MessagesService.EXPAND_AUTHOR);

        return new ResponseEntity<>(pagedMessages, HttpStatus.OK);
    }


    @ApiOperation(value = "Single Message", notes = "specific message")
    @RequestMapping(method = RequestMethod.GET, value = RestConstants.REST_MESSAGE_PATH)
    public ResponseEntity<Message> getMessage(@PathVariable Long id, String expand) {

        Message message = messagesService.getMessageById(id, MessagesService.EXPAND_AUTHOR);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }


    @ApiOperation(value = "List Authors", notes = "List the several authors that have produced messages")
    @RequestMapping(method = RequestMethod.GET, value = RestConstants.REST_AUTHORS_PATH)
    public ResponseEntity<PagedResources<Author>> listAuthors(String expand) {

        PagedResources<Author> pagedAuthors = messagesService.getPagedAuthors();

        return new ResponseEntity<>(pagedAuthors, HttpStatus.OK);
    }

    @ApiOperation(value = "Single Author", notes = "Information about a single author")
    @RequestMapping(method = RequestMethod.GET, value = RestConstants.REST_AUTHOR_PATH)
    public ResponseEntity<Author> getAuthor(@PathVariable Long id, String expand) {

        Author author = messagesService.getAuthorById(id);
        return new ResponseEntity<>(author, HttpStatus.OK);
    }




}