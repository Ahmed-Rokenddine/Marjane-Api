package controller;

import java.util.List;

import Entity.HistoryEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import service.AbstractService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class HistoryController {

    @Qualifier("historyServiceImp")
    @Autowired
    private AbstractService historyService;




    /*---Get a History by id---*/
    @GetMapping("/History/{id}")
    public ResponseEntity<HistoryEntity> get(@PathVariable("id") int id) {
        HistoryEntity History = (HistoryEntity) historyService.get(id);
        return ResponseEntity.ok().body(History);
    }

    /*---get all Historys---*/
    @GetMapping("/History")
    public ResponseEntity<List<HistoryEntity>> list() {
        List<HistoryEntity> Historys = historyService.list();
        return ResponseEntity.ok().body(Historys);
    }
}
