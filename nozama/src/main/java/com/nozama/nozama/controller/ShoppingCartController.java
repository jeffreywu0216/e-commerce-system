package com.nozama.nozama.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nozama.nozama.domain.Item;
import com.nozama.nozama.domain.ShoppingCart;
import com.nozama.nozama.domain.User;
import com.nozama.nozama.service.ItemService;
import com.nozama.nozama.service.ShoppingCartService;
import com.nozama.nozama.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

@Controller //this is a bean that can handle request
@RequestMapping(path="/cart")
public class ShoppingCartController {
    private ShoppingCartService service;
    private ItemService itemService;
    private User user = new User();
    private EntityManager entityManager;

    @Autowired
    public void setService(ShoppingCartService service, ItemService itemService, UserService userService) {
        this.service = service;
        this.itemService = itemService;
    }

    @GetMapping(path="/buyer/{id}", produces= MediaType.APPLICATION_JSON_VALUE) //v
    @ResponseBody
    public ResponseEntity<List<ShoppingCart>> findByBuyerId(@PathVariable("id") Integer id) {
        user.setId(id);
        List<ShoppingCart> cartItems = service.findByBuyerId(user);
        return new ResponseEntity<>(cartItems, HttpStatus.OK);
    }

    @PostMapping(path="/watch-item/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)   //v
    @ResponseBody
    public ResponseEntity addItemToCart(@PathVariable("id") Integer buyerId, @RequestBody Item item) {
        ShoppingCart cart = new ShoppingCart();
        user.setId(buyerId);
        cart.setBuyerId(user);
        cart.setItemId(item);
//        cart.setItemId(item.getItemId());
        service.save(cart);
        ObjectMapper mapper = new ObjectMapper();
        String message = "Success";
        String returnVal = null;
        try {
            returnVal = mapper.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ResponseEntity(returnVal, HttpStatus.OK);
    }

    @PostMapping(path="/unwatch-item/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)  //v
    @ResponseBody
    public ResponseEntity removeItemFromCart(@PathVariable("id") Integer id, @RequestBody Item item) {
        user.setId(id);
        service.deleteByBuyerIdAndItemId(user, item);
        ObjectMapper mapper = new ObjectMapper();
        String message = "Success";
        String returnVal = null;
        try {
            returnVal = mapper.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ResponseEntity(returnVal, HttpStatus.OK);
    }

    @PostMapping(path="/purchase", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)  //v
    @ResponseBody
    @Transactional
    public ResponseEntity buyItems(@RequestBody ShoppingCart shoppingCart) {
        System.out.println(shoppingCart);
        System.out.println(shoppingCart.getBuyerId());
        itemService.setBuyer(shoppingCart.getBuyerId());
        service.deleteAllByBuyerId(shoppingCart.getBuyerId());
        ObjectMapper mapper = new ObjectMapper();
        String message = "Success";
        String returnVal = null;
        try {
            returnVal = mapper.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ResponseEntity(returnVal, HttpStatus.OK);
    }
}
