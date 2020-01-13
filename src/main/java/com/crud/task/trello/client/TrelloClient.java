package com.crud.task.trello.client;

import com.crud.task.domain.CreatedTrelloCard;
import com.crud.task.domain.TrelloBoradDto;
import com.crud.task.domain.TrelloCardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class TrelloClient {
    @Value("${trello.api.endpoint.prod}")
    private String trelloApiEndpoint;
    @Value("${trello.app.key}")
    private String trelloAppKey;
    @Value("${trello.app.token}")
    private String trelloToken;

    @Autowired
    private RestTemplate restTemplatep;

    //private URI getURL(){
    //
    //    return UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + "/members/beatabliniewska/boards")
    //            .queryParam("key", trelloAppKey)
    //            .queryParam("token", trelloToken)
    //            .queryParam("fields", "name,id")
    //            .queryParam("lists","all").build().encode().toUri();
    //}

    public List<TrelloBoradDto> getTrelloBoards() {

        URI url = UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + "/members/beatabliniewska/boards")
                .queryParam("key", trelloAppKey)
                .queryParam("token", trelloToken)
                .queryParam("fields", "name,id")
                .queryParam("lists","all").build().encode().toUri();

        TrelloBoradDto[] boardsResponse = restTemplatep.getForObject(url, TrelloBoradDto[].class);
        if (boardsResponse != null) {
           return Arrays.asList(boardsResponse);
       }
        return new ArrayList<>();
        //return Arrays.asList(Optional.ofNullable(boardsResponse).orElse(new TrelloBoradDto[0]));
    }

    public CreatedTrelloCard createNewCard(TrelloCardDto trelloCardDto){

        URI url =UriComponentsBuilder.fromHttpUrl(trelloApiEndpoint + "/cards")
                .queryParam("key", trelloAppKey)
                .queryParam("token", trelloToken)
                .queryParam("name", trelloCardDto.getName())
                .queryParam("desc", trelloCardDto.getDescription())
                .queryParam("pos", trelloCardDto.getPos())
                .queryParam("idList", trelloCardDto.getListId()).build().encode().toUri();


        return restTemplatep.postForObject(url, null, CreatedTrelloCard.class);
    }


}