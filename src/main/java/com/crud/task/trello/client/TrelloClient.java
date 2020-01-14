package com.crud.task.trello.client;

import com.crud.task.config.TrelloConfig;
import com.crud.task.domain.CreatedTrelloCard;
import com.crud.task.domain.TrelloBoradDto;
import com.crud.task.domain.TrelloCardDto;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;


@Component
public class TrelloClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(TrelloClient.class);

    @Autowired
    private TrelloConfig trelloConfig;

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

        URI url = UriComponentsBuilder.fromHttpUrl(trelloConfig.getTrelloApiEndpoint() + "/members/beatabliniewska/boards")
                .queryParam("key", trelloConfig.getTrelloAppKey())
                .queryParam("token", trelloConfig.getTrelloToken())
                .queryParam("fields", "name,id")
                .queryParam("lists", "all").build().encode().toUri();

        try {
            TrelloBoradDto[] boardsResponse = restTemplatep.getForObject(url, TrelloBoradDto[].class);
            // if (boardsResponse != null) {
            //    return Arrays.asList(boardsResponse);
            //}
            //return new ArrayList<>();
            //return Arrays.asList(Optional.ofNullable(boardsResponse).orElse(new TrelloBoradDto[0]));
            return Arrays.asList(ofNullable(boardsResponse).orElse(new TrelloBoradDto[0]));
        } catch (RestClientException e) {
            LOGGER.error(e.getMessage(), e);
            return new ArrayList<>();
        }
    }
        public CreatedTrelloCard createdNewCard (TrelloCardDto trelloCardDto){

            URI url = UriComponentsBuilder.fromHttpUrl(trelloConfig.getTrelloApiEndpoint() + "/cards")
                    .queryParam("key", trelloConfig.getTrelloAppKey())
                    .queryParam("token", trelloConfig.getTrelloToken())
                    .queryParam("name", trelloCardDto.getName())
                    .queryParam("desc", trelloCardDto.getDescription())
                    .queryParam("pos", trelloCardDto.getPos())
                    .queryParam("idList", trelloCardDto.getListId()).build().encode().toUri();

            return restTemplatep.postForObject(url, null, CreatedTrelloCard.class);
        }
    }
