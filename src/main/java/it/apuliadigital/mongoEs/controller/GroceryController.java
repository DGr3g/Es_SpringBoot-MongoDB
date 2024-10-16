package it.apuliadigital.mongoEs.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import it.apuliadigital.mongoEs.api.GroceryApi;
import it.apuliadigital.mongoEs.model.GroceryItemDTO;
import it.apuliadigital.mongoEs.service.GroceryService;
import jakarta.validation.Valid;

@RestController
public class GroceryController implements GroceryApi {

    Logger logger = LoggerFactory.getLogger(GroceryController.class);

    @Autowired
    GroceryService groceryService;

    public ResponseEntity<GroceryItemDTO> createGrocery(
            @Parameter(name = "GroceryItemDTO", description = "Data for the new grocery", required = true) @Valid @RequestBody GroceryItemDTO groceryItemDTO
    ) {
        GroceryItemDTO newGrocery = groceryService.createGrocery(groceryItemDTO);

        return new ResponseEntity<>(newGrocery, HttpStatus.CREATED);

    }

    public ResponseEntity<List<GroceryItemDTO>> getAllGrocery() {

        List<GroceryItemDTO> listItem = groceryService.getAll();

        return new ResponseEntity<>(listItem, HttpStatus.OK);

    }

    public ResponseEntity<GroceryItemDTO> getGroceryById(
            @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") String id
    ) {

        GroceryItemDTO newGrocery = groceryService.getById(id);

        return new ResponseEntity<>(newGrocery, HttpStatus.OK);

    }

    public ResponseEntity<Boolean> deleteGroceryById(
            @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") String id
    ) {
        Boolean esito = groceryService.deleteById(id);

        return new ResponseEntity<>(esito, HttpStatus.OK);

    }

    public ResponseEntity<GroceryItemDTO> updateGrocery(
            @Parameter(name = "id", description = "", required = true, in = ParameterIn.PATH) @PathVariable("id") String id,
            @Parameter(name = "GroceryItemDTO", description = "Data for the update grocery", required = true) @Valid @RequestBody GroceryItemDTO groceryItemDTO
    ) {

        GroceryItemDTO updateGrocery = groceryService.updateGrocery(groceryItemDTO, id);

        return new ResponseEntity<>(updateGrocery, HttpStatus.OK);

    }

}
