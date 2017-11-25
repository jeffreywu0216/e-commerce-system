package com.nozama.nozama;

import com.nozama.nozama.controller.ItemController;
import com.nozama.nozama.controller.ShoppingCartController;
import com.nozama.nozama.domain.ShoppingCart;
import com.nozama.nozama.service.ItemService;
import com.nozama.nozama.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NozamaApplication {

	private ItemService itemService;
	private ShoppingCartService shoppingCartService;

	@Autowired
	public void setService(ItemService itemService, ShoppingCartService shoppingCartService) {
		this.itemService = itemService;
		this.shoppingCartService = shoppingCartService;
	}

	public static void main(String[] args) {
		SpringApplication.run(NozamaApplication.class, args);
	}

	@Bean
	public CommandLineRunner runner() {
		return args -> {

		};
	}
}
