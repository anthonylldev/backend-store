package com.anthonylldev.store.infrastructure.rest;

import com.anthonylldev.store.application.dto.ItemDto;
import com.anthonylldev.store.application.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ItemRestController {
    private final ItemService itemService;

    @Autowired
    public ItemRestController(ItemService itemService) {
        this.itemService = itemService;
    }

    @CrossOrigin
    @GetMapping(value = "/items", produces = "application/json")
    public ResponseEntity<List<ItemDto>> getAllItems() {
        List<ItemDto> items = this.itemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping(value = "/categories/{categoryId}/items", produces = "application/json")
    public ResponseEntity<List<ItemDto>> getAllItemsByCategory(@PathVariable Long categoryId) {
        List<ItemDto> items = this.itemService.getAllItemsByCategory(categoryId);
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/items", produces = "application/json", consumes = "application/json")
    public ResponseEntity<ItemDto> saveItem(@RequestBody ItemDto itemDto) {
        itemDto = this.itemService.saveItem(itemDto);
        return new ResponseEntity<>(itemDto, HttpStatus.CREATED);
    }
}
