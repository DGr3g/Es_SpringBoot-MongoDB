package it.apuliadigital.mongoEs.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import it.apuliadigital.mongoEs.entity.GroceryItem;
import it.apuliadigital.mongoEs.model.GroceryItemDTO;

@Mapper(componentModel = "spring")
public interface DtoToEntityMapper {

    @Mapping(target = "name", source = "g.nome")
    GroceryItem groceryToEntity(GroceryItemDTO g);

    List<GroceryItem> groceryToEntityList(List<GroceryItemDTO> listG);

}
