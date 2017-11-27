package com.nozama.nozama.controller;

import com.nozama.nozama.domain.Item;
import com.nozama.nozama.domain.ShoppingCart;
import com.nozama.nozama.service.ItemService;
import com.nozama.nozama.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@Controller //this is a bean that can handle request
@RequestMapping(path="/cart")
public class ShoppingCartController {
    private ShoppingCartService service;
    private ItemService itemService;

    @Autowired
    public void setService(ShoppingCartService service, ItemService itemService) {
        this.service = service;
        this.itemService = itemService;
    }

    @GetMapping(path="/buyer/{id}", produces= MediaType.APPLICATION_JSON_VALUE) //v
    @ResponseBody
    public ResponseEntity<List<ShoppingCart>> findByBuyerId(@PathVariable("id") Integer id) {
        List<ShoppingCart> cartItems = service.findByBuyerId(id);
        return new ResponseEntity<>(cartItems, HttpStatus.OK);
    }

    @PostMapping(path="/watch-item/{id}")   //v
    @ResponseBody
    public ResponseEntity addItemToCart(@PathVariable("id") Integer buyerId, @RequestBody Item item) {
        ShoppingCart cart = new ShoppingCart();
        cart.setBuyerId(buyerId);
        cart.setItemId(item.getItemId());
        service.save(cart);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(path="/unwatch-item")  //v
    @ResponseBody
    public ResponseEntity removeItemFromCart(@RequestBody ShoppingCart shoppingCart) {
        service.deleteByShoppingCartId(shoppingCart.getShoppingCartId());
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping(path="/purchase")  //v
    @ResponseBody
    @Transactional
    public ResponseEntity buyItems(@RequestBody ShoppingCart shoppingCart) {
        itemService.setBuyer(shoppingCart.getBuyerId());
        service.deleteAllByBuyerId(shoppingCart.getBuyerId());
        return new ResponseEntity(HttpStatus.OK);
    }
}
