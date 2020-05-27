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
			
			initForCategoryTest();
					
			initForItemTest();
		};
	}
	
	private void initForCategoryTest() {

		Category c1 = new Category("C100");
		Category c11 = new Category("C110");
		c1.addChild(c11);
		Category c12 = new Category("C120");
		c1.addChild(c12);
		
		// c111
		Category c111 = new Category("C111");
		c11.addChild(c111);
		
		// c112
		Category c112 = new Category("C112");
		c11.addChild(c112);
		// c113
		Category c113 = new Category("C113");
		c11.addChild(c113);

		// c121
		Category c121 = new Category("C121");
		c12.addChild(c121);

		// c122
		Category c122 = new Category("C122");
		c12.addChild(c122);

		Category c2 = new Category("C200");
		Category c21 = new Category("C210");
		// c21
		c2.addChild(c21);
		Category c22 = new Category("C220");
		// c22
		c2.addChild(c22);
		
		catRepo.save(c1);
		catRepo.save(c2);
		
	}

	private void initForItemTest() {
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
	}
}
