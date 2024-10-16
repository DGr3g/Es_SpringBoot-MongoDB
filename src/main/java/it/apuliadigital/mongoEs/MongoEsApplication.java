package it.apuliadigital.mongoEs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import it.apuliadigital.mongoEs.entity.GroceryItem;
import it.apuliadigital.mongoEs.repository.ItemRepository;

@EnableMongoRepositories
@SpringBootApplication
public class MongoEsApplication  {

	// @Autowired
	// ItemRepository groceryItemRepo;

	public static void main(String[] args) {
		SpringApplication.run(MongoEsApplication.class, args);
	}

    // @Override
    // public void run(String... args) throws Exception {
    //    createGroceryItems();
	// }

	// private void createGroceryItems(){
	// 	groceryItemRepo.save(new GroceryItem("1", "Prodotto1", 10, "Categoria1"));
	// 	groceryItemRepo.save(new GroceryItem("2", "Prodotto2", 5, "Categoria2"));
	// 	groceryItemRepo.save(new GroceryItem("2", "Prodotto3", 1, "Categoria3"));
	// }

}
