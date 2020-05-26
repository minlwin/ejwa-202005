package com.jdc.custom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jdc.custom.model.entity.Category;
import com.jdc.custom.model.entity.Item;
import com.jdc.custom.model.entity.Item.State;
import com.jdc.custom.model.repo.CategoryRepo;
import com.jdc.custom.model.repo.ItemRepo;

@Configuration
public class DataInitializerForTest {

	@Autowired
	private ItemRepo itemRepo;
	@Autowired
	private CategoryRepo catRepo;
	
	@Bean
	public CommandLineRunner runner() {
		return args -> {
			
			// create category
			Category cat = new Category();
			cat.setName("Drinks");
			catRepo.save(cat);
			
			Category cat1 = new Category();
			cat1.setName("Phones");
			catRepo.save(cat1);
			
			// create item 1
			Item item1  = new Item();
			item1.setBrend("Max");
			item1.setName("Lemon");
			item1.setCategory(cat);
			item1.setState(State.New);
			item1.setPrice(300);
			itemRepo.save(item1);
			
			
			// create item 2
			Item item2  = new Item();
			item2.setBrend("iPhone");
			item2.setName("iPhone 8");
			item2.setCategory(cat1);
			item2.setState(State.New);
			item2.setPrice(1_200_000);
			itemRepo.save(item2);
			
			
			// create item 3
			Item item3  = new Item();
			item3.setBrend("iPhone");
			item3.setName("iPhone 8");
			item3.setCategory(cat1);
			item3.setState(State.Used);
			item3.setPrice(600_000);
			itemRepo.save(item3);
		};
	}
}
