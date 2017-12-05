package com.nozama.nozama.controller;

//import com.amazonaws.auth.AWSCredentials;
//import com.amazonaws.auth.BasicAWSCredentials;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nozama.nozama.domain.Item;
import com.nozama.nozama.domain.User;
import com.nozama.nozama.service.ItemService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//import com.amazonaws.AmazonClientException;
//import com.amazonaws.AmazonServiceException;
//import com.amazonaws.auth.profile.ProfileCredentialsProvider;
//import com.amazonaws.services.s3.AmazonS3;
//import com.amazonaws.services.s3.AmazonS3Client;
//import com.amazonaws.services.s3.model.PutObjectRequest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
            Collections.sort(items, Comparator.comparingInt(Item::getItemId));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(items, HttpStatus.OK);
    }

    @GetMapping(path="/search/{word}", produces= MediaType.APPLICATION_JSON_VALUE)  //v
    @ResponseBody
    public ResponseEntity<List<Item>> getSearchResult(@PathVariable("word") String word) {
        List<Item> items = service.findBySearchingWord(word);
        return new ResponseEntity(items, HttpStatus.OK);
    }

    @GetMapping(path="/seller/{id}", produces= MediaType.APPLICATION_JSON_VALUE)    //v
    @ResponseBody
    public ResponseEntity<List<Item>> getAllItemsBySellerId(@PathVariable("id") Integer id) {
        User user = new User();
        user.setId(id);
        List<Item> items = service.findBySellerId(user);
        return new ResponseEntity(items, HttpStatus.OK);
    }

    @GetMapping(path="/seller/sell/{id}", produces= MediaType.APPLICATION_JSON_VALUE)      //v
    @ResponseBody
    public ResponseEntity<List<Item>> getAllSellItemsBySellerId(@PathVariable("id") Integer id) {
        User user = new User();
        user.setId(id);
        List<Item> items = service.findBySellerIdAAndStatusId(user, 1);
        return new ResponseEntity(items, HttpStatus.OK);
    }

    @GetMapping(path="/seller/sold/{id}", produces= MediaType.APPLICATION_JSON_VALUE)   //v
    @ResponseBody
    public ResponseEntity<List<Item>> getAllSoldItemsBySellerId(@PathVariable("id") Integer id) {
        User user = new User();
        user.setId(id);
        List<Item> items = service.findBySellerIdAAndStatusId(user, 2);
        return new ResponseEntity(items, HttpStatus.OK);
    }

    @GetMapping(path="/buyer/bought/{id}", produces= MediaType.APPLICATION_JSON_VALUE)  //v
    @ResponseBody
    public ResponseEntity<List<Item>> getAllBoughtItemsByBuyerId(@PathVariable("id") Integer id) {
        User user = new User();
        user.setId(id);
        List<Item> items = service.findByBuyerId(user);
        return new ResponseEntity(items, HttpStatus.OK);
    }

    @PostMapping(path="/item/new/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE) //v
    @ResponseBody
    public ResponseEntity submitNewSellItem(@PathVariable("id") Integer id, @RequestBody Item item) {

        if (item.getPictureUrl() != null && item.getPicture() != null) {
            String encodingPrefix = "base64,";
            int contentStartIndex = item.getPicture().indexOf(encodingPrefix) + encodingPrefix.length();
            byte[] imageData = Base64.decodeBase64(item.getPicture().substring(contentStartIndex));

            String imgPrefix = "image/";
            int typeStartIndex = item.getPicture().indexOf(imgPrefix) + imgPrefix.length();
            String fileType = item.getPicture().substring(typeStartIndex).split(";")[0];

            try {
                BufferedImage inputImage = ImageIO.read(new ByteArrayInputStream(imageData));
                File file = new File(item.getPictureUrl());
                ImageIO.write(inputImage, fileType, file);
                uploadPicture(file, item.getPictureUrl());
                file.delete();
            } catch (IOException e) {
                e.printStackTrace();
            }

            item.setPictureUrl("https://s3.us-east-2.amazonaws.com/jeffrey-wu-test/" + item.getPictureUrl());
        } else {
            item.setPictureUrl("https://s3.us-east-2.amazonaws.com/jeffrey-wu-test/no-photo.jpg");
        }

        User user = new User();
        user.setId(id);
        item.setSellerId(user);
        service.save(item);
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

    // not checked
    @PostMapping(path="/item/update/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE) //v
    @ResponseBody
    public ResponseEntity updateSellItem(@PathVariable("id") Integer id, @RequestBody Item item) {
        item.setItemId(id);
        service.save(item);
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

    // not checked
    @PostMapping(path="/item/delete", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)   //v
    @ResponseBody
    public ResponseEntity removeSellItem(@RequestBody Item item) {
        service.deleteByItemId(item.getItemId());
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

//    private void uploadPicture (File file, String fileName) {
//        AWSCredentials credentials = new BasicAWSCredentials("AKIAJCJVDFNS4RVYZC6Q", "0j2c8aWcZWlZWSwtONG0JMyMY16aR/4dlYCz8B7S");
//        AmazonS3 s3client = new AmazonS3Client(credentials);
//        String bucketName     = "jeffrey-wu-test";
//
//        try {
//            System.out.println("uploading file to s3");
//            s3client.putObject(new PutObjectRequest(bucketName, fileName, file));
//            System.out.println("uploading file to s3, success");
//
//        } catch (AmazonServiceException ase) {
//            System.out.println("Caught an AmazonServiceException, which " +
//                    "means your request made it " +
//                    "to Amazon S3, but was rejected with an error response" +
//                    " for some reason.");
//            System.out.println("Error Message:    " + ase.getMessage());
//            System.out.println("HTTP Status Code: " + ase.getStatusCode());
//            System.out.println("AWS Error Code:   " + ase.getErrorCode());
//            System.out.println("Error Type:       " + ase.getErrorType());
//            System.out.println("Request ID:       " + ase.getRequestId());
//        } catch (AmazonClientException ace) {
//            System.out.println("Caught an AmazonClientException, which " +
//                    "means the client encountered " +
//                    "an internal error while trying to " +
//                    "communicate with S3, " +
//                    "such as not being able to access the network.");
//            System.out.println("Error Message: " + ace.getMessage());
//        }
//    }
}
