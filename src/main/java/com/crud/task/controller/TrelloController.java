package com.crud.task.controller;


import com.crud.task.domain.CreatedTrelloCard;
import com.crud.task.domain.TrelloBoradDto;
import com.crud.task.domain.TrelloCardDto;
import com.crud.task.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/trello")
@CrossOrigin("*")
public class TrelloController {
    @Autowired
    private TrelloClient trelloClient;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public void getTrelloBoards() {

        List<TrelloBoradDto> trelloBoards = trelloClient.getTrelloBoards();
         //   trelloBoards.stream()
         //           .filter(s->s.getName().contains("Kodilla"))
         //           .filter(s->!s.getId().isEmpty())
         //           .filter(s->!s.getName().isEmpty())
         //           .forEach(trelloBoardDto -> System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName()));
         //trelloBoards.forEach(trelloBoardDto -> System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName()));

         trelloBoards.forEach(TrelloBoradDto -> {

            System.out.println(TrelloBoradDto.getName() + " - " + TrelloBoradDto.getId());

            System.out.println("This board contains lists: ");

            TrelloBoradDto.getLists().forEach(trelloList ->
                    System.out.println(trelloList.getName() + " - " + trelloList.getId() + " - " + trelloList.isClosed()));

        });
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTrelloCard")
    public CreatedTrelloCard createTrelloCard(@RequestBody TrelloCardDto trelloCardDto){
        return trelloClient.createNewCard(trelloCardDto);
    }

}
