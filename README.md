# webflux
Example of an API using webflux and mongodb

# Some Considerations:
- There are two controllers: controller/functional (builded using a functional structure) and controller (builded with blocking and non-blocking structure).
  
  ## To use the traditional controller
  - uncomment the @RestController from the PlaylistController and go to the controller/functional and comment @Component from the PlaylistHandler and @Configuration and    
    @Bean from the PlayRouter
  
  ## To use functional controller
  - comment the @RestController from the PlaylistController and go to the controller/functional and uncomment @Component from the PlaylistHandler and @Configuration and    
    @Bean from the PlayRouter
    
# Running the container
- To run the container, run the command below into the main folder<br>
docker-compose up -d

# cURL 
- Save endpoint <br>
curl --location --request POST 'localhost:8080/playlist' \
--header 'Content-Type: application/json' \
--data '   {
        "nome": "TESTE"
    }'
 
- findAll endpoint <br>
curl --location --request GET 'localhost:8080/playlist/'

- findById endpoint <br>
curl --location --request GET 'localhost:8080/playlist/<id recovered by endpoint above>'

- find per event (using non-blocking structure) <br>
curl --location --request GET 'localhost:8080/playlist/events'

    

  

  
