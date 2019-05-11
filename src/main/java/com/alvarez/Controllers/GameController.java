package com.alvarez.Controllers;

import com.alvarez.Entities.Game;
import com.alvarez.Services.GameService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController {

    @GetMapping("/new")
    public ResponseEntity<Game> newGame() {
        return new ResponseEntity<>(GameService.newGame(), HttpStatus.OK);
    }

    @PostMapping("/input")
    public ResponseEntity<?> input(@RequestParam("x") int x, @RequestParam("y") int y) {
        return new ResponseEntity<>("NotImplemented", HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save() {
        return new ResponseEntity<>("NotImplemented", HttpStatus.OK);
    }

    @GetMapping("/load")
    public ResponseEntity<?> load() {
        return new ResponseEntity<>("NotImplemented", HttpStatus.OK);
    }
}
