## Notes About REST

Rest services are about making resources available, the path should reflect that.
Paths should use Nouns NOT verbs


"Design Outside-In", The user(consumer) is the main stakeholder


## API Versioning
  - [GitHub :: Spring Api Versioning](https://github.com/augusto/restVersioning)
  - Using a Header to indicate the version
  - Specify the version on the path (/api/1/resources, /api/latest/resources)

### Media Types

#### Vendor Specific Sub Type
vnd.<subtype>+type

 - [Wikipedia :: Media type](https://en.wikipedia.org/wiki/Media_type)




### Data Structure
 - [Hal JSON :: Stateless](http://stateless.co/hal_specification.html)
 - [Hal JSON :: IETF](https://tools.ietf.org/html/draft-kelly-json-hal-08)
 - [Error Representation :: vnd.error+json](https://github.com/blongden/vnd.error)


     {  
         // Error Code for API ERRORS(Out of spec)
          "errorCode":40104,
          "logref":"YtN08_WYTIyxN6_BMEXCiw",
          "message":"Authentication failed (invalid credentials)",
          "_links":{  
             "help":{  
                "href":"https://auth.ptinovacao.pt/api/errors/40104",
                "type":"text/html"
             }
          }
       }


### Pointers
 - https://docs.spring.io/spring-data/rest/docs/current/reference/html/#_the_hal_browser



### Presentation
 - [Building Beautiful REST APIs with ASP.NET Core](https://www.slideshare.net/stormpath/building-beautiful-rest-apis-with-aspnet-core?next_slideshow=1)

## Spring
 - [Jackson – Bidirectional Relationships](http://www.baeldung.com/jackson-bidirectional-relationships-and-infinite-recursion)
 - [Securing Spring Boot with JWTs](https://auth0.com/blog/securing-spring-boot-with-jwts/)
 - [Implementing JWT Authentication on Spring Boot APIs](https://auth0.com/blog/implementing-jwt-authentication-on-spring-boot/)
 - [GitHub :: springboot-jwt](https://github.com/nydiarra/springboot-jwt)
