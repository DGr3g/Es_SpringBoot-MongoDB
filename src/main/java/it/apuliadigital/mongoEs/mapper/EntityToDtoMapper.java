package it.apuliadigital.mongoEs.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.apuliadigital.mongoEs.entity.GroceryItem;
import it.apuliadigital.mongoEs.model.GroceryItemDTO;

@Mapper(componentModel = "spring")
public interface EntityToDtoMapper {

    @Mapping(target="nome", source="g.name")
    GroceryItemDTO groceryToDTO (GroceryItem g);

    List<GroceryItemDTO> groceryListToDTO(List<GroceryItem> groceryListItem);

}
