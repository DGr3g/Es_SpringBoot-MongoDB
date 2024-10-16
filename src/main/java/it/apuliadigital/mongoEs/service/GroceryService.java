package it.apuliadigital.mongoEs.service;

import java.util.List;

import it.apuliadigital.mongoEs.model.GroceryItemDTO;

public interface GroceryService {

    GroceryItemDTO getById (String id);

    GroceryItemDTO createGrocery(GroceryItemDTO newGrocery);

    List<GroceryItemDTO> getAll();

    Boolean deleteById(String id);

    GroceryItemDTO updateGrocery (GroceryItemDTO updateGrocery, String id);
}
