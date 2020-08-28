package com.github.perscholas.controllers;

import com.github.perscholas.models.Guests;
import com.github.perscholas.models.MyModel;
import com.github.perscholas.services.GuestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value="/guests")
public class GuestsController {
    private GuestsService guestsService;

    @Autowired
    public GuestsController(GuestsService guestsService) {
        this.guestsService = guestsService;
    }

    @GetMapping("/")
    public ResponseEntity<Iterable<Guests>> index() {
        return new ResponseEntity<>(guestsService.index(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guests> show(@PathVariable Long id) {
        return new ResponseEntity<>(guestsService.show(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Guests> create(@RequestBody Guests guest) {
        return new ResponseEntity<>(guestsService.create(guest), HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Guests> update(@PathVariable Long id, @RequestBody Guests guest) {
        return new ResponseEntity<>(guestsService.update(id, guest), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        return new ResponseEntity<>(guestsService.delete(id), HttpStatus.OK);
    }
}
