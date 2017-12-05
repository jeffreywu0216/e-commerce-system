package com.nozama.nozama.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nozama.nozama.domain.Item;
import com.nozama.nozama.domain.ProductReview;
import com.nozama.nozama.domain.User;
import com.nozama.nozama.domain.UserReview;
import com.nozama.nozama.service.ProductReviewService;
import com.nozama.nozama.service.UserReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/reviews")
public class ReviewController {
    private ProductReviewService productService;
    private UserReviewService userReviewService;

    @Autowired
    public void setService(ProductReviewService service, UserReviewService userService){
        this.productService = service;
        this.userReviewService = userService;
    }

    @PostMapping(path="/new/product", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType
            .APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity submitNewComment(@RequestBody ProductReview review
    ){
        System.out.println(review);
        productService.save(review);
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

    @PostMapping(path="/new/user", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType
            .APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity submitNewComment(@RequestBody UserReview review
    ){
        System.out.println(review);
        userReviewService.save(review);
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
