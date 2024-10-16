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
public class DtoToEntityMapperImpl implements DtoToEntityMapper {

    @Override
    public GroceryItem groceryToEntity(GroceryItemDTO g) {
        if ( g == null ) {
            return null;
        }

        GroceryItem groceryItem = new GroceryItem();

        groceryItem.name( g.getNome() );
        groceryItem.id( g.getId() );
        if ( g.getQuantity() != null ) {
            groceryItem.quantity( g.getQuantity().intValue() );
        }
        groceryItem.category( g.getCategory() );

        return groceryItem;
    }

    @Override
    public List<GroceryItem> groceryToEntityList(List<GroceryItemDTO> listG) {
        if ( listG == null ) {
            return null;
        }

        List<GroceryItem> list = new ArrayList<GroceryItem>( listG.size() );
        for ( GroceryItemDTO groceryItemDTO : listG ) {
            list.add( groceryToEntity( groceryItemDTO ) );
        }

        return list;
    }
}
