package com.crud.task.controller;


import com.crud.task.domain.TrelloBoradDto;
import com.crud.task.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/trello")
public class TrelloController {
    @Autowired
    private TrelloClient trelloClient;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public void getTrelloBoards() {

        List<TrelloBoradDto> trelloBoards = trelloClient.getTrelloBoards();
            trelloBoards.stream()
                    .filter(s->s.getName().contains("Kodilla"))
                    .filter(s->!s.getId().isEmpty())
                    .filter(s->!s.getName().isEmpty())
                    .forEach(trelloBoardDto -> System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName()));
        //trelloBoards.forEach(trelloBoardDto -> System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName()));

    }
}
