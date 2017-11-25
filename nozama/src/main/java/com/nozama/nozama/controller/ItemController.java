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

    @GetMapping(path="/{id}", consumes= MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Item> findOne(@PathVariable("id") Integer id) {
        Item item = service.findOne(id);
        return new ResponseEntity(item, HttpStatus.OK);
    }

    @GetMapping(consumes= MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Item>> getAllSellingItems() {
        List<Item> items = service.findByStatusId(1);
        return new ResponseEntity(items, HttpStatus.OK);
    }

    @GetMapping(path="/search", consumes= MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Item>> getSearchResult(@RequestBody String word) {
        List<Item> items = service.findByDescriptionContaining(word);
        return new ResponseEntity(items, HttpStatus.OK);
    }

    @GetMapping(path="/seller/{id}", consumes= MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Item>> getAllItemsBySellerId(@PathVariable("id") Integer id) {
        List<Item> items = service.findBySellerId(id);
        return new ResponseEntity(items, HttpStatus.OK);
    }

    @GetMapping(path="/seller/sell/{id}", consumes= MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Item>> getAllSellItemsBySellerId(@PathVariable("id") Integer id) {
        List<Item> items = service.findBySellerIdAAndStatusId(id, 1);
        return new ResponseEntity(items, HttpStatus.OK);
    }

    @GetMapping(path="/seller/sold/{id}", consumes= MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Item>> getAllSoldItemsBySellerId(@PathVariable("id") Integer id) {
        List<Item> items = service.findBySellerIdAAndStatusId(id, 2);
        return new ResponseEntity(items, HttpStatus.OK);
    }

    @GetMapping(path="/buyer/bought/{id}", consumes= MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Item>> getAllBoughtItemsByBuyerId(@PathVariable("id") Integer id) {
        List<Item> items = service.findByBuyerId(id);
        return new ResponseEntity(items, HttpStatus.OK);
    }

//    @PostMapping(path="/item/new/{id}", consumes= MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public ResponseEntity submitNewSellItem(@PathVariable("id") Integer id, @RequestBody Double price,
//                                            @RequestBody String productName, @RequestBody String description) {
//        Item item = new Item();
//        item.setSellerId(userService.findOne(id));
//        item.setPrice(price);
//        item.setProductName(productName);
//        item.setDescription(description);
//        service.save(item);
//        return new ResponseEntity(HttpStatus.OK);
//    }

    @PostMapping(path="/item/update/{id}", consumes= MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity updateSellItem(@PathVariable("id") Integer id, @RequestBody Double price,
                                            @RequestBody String productName, @RequestBody String description) {
        Item item = service.findOne(id);
        item.setPrice(price);
        item.setProductName(productName);
        item.setDescription(description);
        service.save(item);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping(path="/item/{id}")
    @ResponseBody
    public ResponseEntity removeSellItem(@PathVariable("id") Integer id) {
        service.deleteByItemId(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
