package com.caiopivetta6;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.caiopivetta6.domain.Category;
import com.caiopivetta6.domain.Product;
import com.caiopivetta6.repositories.CategoryRepository;
import com.caiopivetta6.repositories.ProductRepository;

@SpringBootApplication
public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	@Override
	public void run (String... args) throws Exception {
	
		Category cat1 = new Category(null, "Informatic");
		Category cat2 = new Category(null, "Office");
		
		Product p1 = new Product(null, "Computer", 2000);
		Product p2 = new Product(null, "Printer", 200);
		Product p3 = new Product(null, "Mouse", 20);
		
		cat1.getProducts().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProducts().addAll(Arrays.asList(p2,p3));
		
		p1.getCategories().add(cat1);
		p2.getCategories().add(cat2);
		p3.getCategories().add(cat2);
		
		
		categoryRepository.saveAll(Arrays.asList(cat1,cat2));
		productRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		
		
	}
	
	
}
