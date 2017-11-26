package com.nozama.nozama;

import com.nozama.nozama.dao.ItemDao;
import com.nozama.nozama.dao.UserDao;
import com.nozama.nozama.domain.Item;
import com.nozama.nozama.domain.User;
import com.nozama.nozama.controller.ItemController;
import com.nozama.nozama.controller.ShoppingCartController;
import com.nozama.nozama.domain.ShoppingCart;
import com.nozama.nozama.service.ItemService;
import com.nozama.nozama.service.ShoppingCartService;
import com.nozama.nozama.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;

@SpringBootApplication
public class NozamaApplication {

	private ItemService itemService;
	private ShoppingCartService shoppingCartService;
	private UserService userService;

	@Autowired
	public void setService(ItemService itemService, ShoppingCartService shoppingCartService, UserService userService) {
		this.itemService = itemService;
		this.shoppingCartService = shoppingCartService;
		this.userService = userService;
	}
  
	public static void main(String[] args) {
		SpringApplication.run(NozamaApplication.class, args);
	}
  
//	@Bean
//	public CommandLineRunner runner() {
//		return args -> {
//			Item item = new Item();
//			item.setSellerId(31);
//			item.setProductName("Air Conditioner");
//			item.setDescription("Best AC Ever");
//			item.setPrice(99.99);
//			itemService.save(item);
//		};
//	}
//	private int itemId;
//	private User sellerId;
//	private User buyerId;
//	private String productName;
//	private String description;
//	private double price;
//	private Date timeToSell;
//	private ItemStatus statusId;
}
