package it.apuliadigital.mongoEs.mapper;

import it.apuliadigital.mongoEs.entity.GroceryItem;
import it.apuliadigital.mongoEs.model.GroceryItemDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-16T16:52:34+0200",
    comments = "version: 1.6.2, compiler: Eclipse JDT (IDE) 3.40.0.v20240919-1711, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class EntityToDtoMapperImpl implements EntityToDtoMapper {

    @Override
    public GroceryItemDTO groceryToDTO(GroceryItem g) {
        if ( g == null ) {
            return null;
        }

        GroceryItemDTO groceryItemDTO = new GroceryItemDTO();

        groceryItemDTO.setNome( g.getName() );
        groceryItemDTO.setId( g.getId() );
        groceryItemDTO.setQuantity( (long) g.getQuantity() );
        groceryItemDTO.setCategory( g.getCategory() );

        return groceryItemDTO;
    }

    @Override
    public List<GroceryItemDTO> groceryListToDTO(List<GroceryItem> groceryListItem) {
        if ( groceryListItem == null ) {
            return null;
        }

        List<GroceryItemDTO> list = new ArrayList<GroceryItemDTO>( groceryListItem.size() );
        for ( GroceryItem groceryItem : groceryListItem ) {
            list.add( groceryToDTO( groceryItem ) );
        }

        return list;
    }
}
