package com.nozama.nozama;

import com.nozama.nozama.dao.UserDao;
import com.nozama.nozama.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NozamaApplication {



	public static void main(String[] args) {
		SpringApplication.run(NozamaApplication.class, args);
	}

}
