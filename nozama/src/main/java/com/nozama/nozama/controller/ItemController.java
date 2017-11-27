package com.nozama.nozama.controller;

import com.nozama.nozama.domain.Item;
import com.nozama.nozama.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller //this is a bean that can handle request
@RequestMapping(path="/items")
public class ItemController {
    private ItemService service;

    @Autowired
    public void setService(ItemService service) {
        this.service = service;
    }

    @GetMapping(path="/item/{id}", produces= MediaType.APPLICATION_JSON_VALUE)  //v
    @ResponseBody
    public ResponseEntity<Item> findOne(@PathVariable("id") Integer id) {
        Item item = service.findOne(id);
        return new ResponseEntity(item, HttpStatus.OK);
    }

    @GetMapping(produces= MediaType.APPLICATION_JSON_VALUE) //v
    @ResponseBody
    public ResponseEntity<List<Item>> getAllSellingItems() {
        List<Item> items = null;
        try {
            items = service.findByStatusId(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(items, HttpStatus.OK);
    }

    @GetMapping(path="/search/{word}", produces= MediaType.APPLICATION_JSON_VALUE)  //v
    @ResponseBody
    public ResponseEntity<List<Item>> getSearchResult(@PathVariable("word") String word) {
        List<Item> items = service.findByDescriptionContaining(word);
        return new ResponseEntity(items, HttpStatus.OK);
    }

    @GetMapping(path="/seller/{id}", produces= MediaType.APPLICATION_JSON_VALUE)    //v
    @ResponseBody
    public ResponseEntity<List<Item>> getAllItemsBySellerId(@PathVariable("id") Integer id) {
        List<Item> items = service.findBySellerId(id);
        return new ResponseEntity(items, HttpStatus.OK);
    }

    @GetMapping(path="/seller/sell/{id}", produces= MediaType.APPLICATION_JSON_VALUE)      //v
    @ResponseBody
    public ResponseEntity<List<Item>> getAllSellItemsBySellerId(@PathVariable("id") Integer id) {
        List<Item> items = service.findBySellerIdAAndStatusId(id, 1);
        return new ResponseEntity(items, HttpStatus.OK);
    }

    @GetMapping(path="/seller/sold/{id}", produces= MediaType.APPLICATION_JSON_VALUE)   //v
    @ResponseBody
    public ResponseEntity<List<Item>> getAllSoldItemsBySellerId(@PathVariable("id") Integer id) {
        List<Item> items = service.findBySellerIdAAndStatusId(id, 2);
        return new ResponseEntity(items, HttpStatus.OK);
    }

    @GetMapping(path="/buyer/bought/{id}", produces= MediaType.APPLICATION_JSON_VALUE)  //v
    @ResponseBody
    public ResponseEntity<List<Item>> getAllBoughtItemsByBuyerId(@PathVariable("id") Integer id) {
        List<Item> items = service.findByBuyerId(id);
        return new ResponseEntity(items, HttpStatus.OK);
    }

    @PostMapping(path="/item/new/{id}") //v
    @ResponseBody
    public ResponseEntity submitNewSellItem(@PathVariable("id") Integer id, @RequestBody Item item) {
        item.setSellerId(id);
        service.save(item);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(path="/item/update/{id}") //v
    @ResponseBody
    public ResponseEntity updateSellItem(@PathVariable("id") Integer id, @RequestBody Item item) {
        item.setItemId(id);
        service.save(item);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(path="/item/delete")   //v
    @ResponseBody
    public ResponseEntity removeSellItem(@RequestBody Item item) {
        service.deleteByItemId(item.getItemId());
        return new ResponseEntity(HttpStatus.OK);
    }
}
