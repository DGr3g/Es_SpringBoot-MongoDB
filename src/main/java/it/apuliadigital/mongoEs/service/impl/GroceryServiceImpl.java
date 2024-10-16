package it.apuliadigital.mongoEs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.apuliadigital.mongoEs.entity.GroceryItem;
import it.apuliadigital.mongoEs.mapper.DtoToEntityMapper;
import it.apuliadigital.mongoEs.mapper.EntityToDtoMapper;
import it.apuliadigital.mongoEs.model.GroceryItemDTO;
import it.apuliadigital.mongoEs.repository.ItemRepository;
import it.apuliadigital.mongoEs.service.GroceryService;

@Service
public class GroceryServiceImpl implements GroceryService {

    @Autowired
    ItemRepository repo;

    @Autowired
    DtoToEntityMapper mapperToEntity;

    @Autowired
    EntityToDtoMapper mapperToDto;

    @Override
    public GroceryItemDTO getById(String id) {

        GroceryItem groceryEntity = repo.findById(id).get();

        GroceryItemDTO groceryDTO = mapperToDto.groceryToDTO(groceryEntity);

        return groceryDTO;
    }

    @Override
    public GroceryItemDTO createGrocery(GroceryItemDTO newGrocery) {

        GroceryItem entity = mapperToEntity.groceryToEntity(newGrocery);
        entity = repo.save(entity);
        newGrocery.setId(entity.getId());

        return newGrocery;

    }

    @Override
    public List<GroceryItemDTO> getAll() {
        List<GroceryItem> listItem = repo.findAll();

        List<GroceryItemDTO> listDto = mapperToDto.groceryListToDTO(listItem);

        return listDto;
    }

    @Override
    public Boolean deleteById(String id) {
        if (!repo.existsById(id)) {

            throw new UnsupportedOperationException("Id Non esistestente");
        } else {
            repo.deleteById(id);
            return true;
        }
    }

    @Override
    public GroceryItemDTO updateGrocery(GroceryItemDTO updateGrocery, String id) {
        if (!repo.existsById(id)) {

            throw new UnsupportedOperationException("Id Non esistestente");
        } else {
            GroceryItem entity = mapperToEntity.groceryToEntity(updateGrocery);
            entity = repo.save(entity);
            updateGrocery.setId(entity.getId());

            return updateGrocery;
        }
    }

}
