package com.managenament_sys.mapper;

import com.managenament_sys.dto.ProductDTO;
import com.managenament_sys.modules.Produto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-07-09T20:17:06-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 21.0.7 (Ubuntu)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTO toDTO(Produto product) {
        if ( product == null ) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();

        productDTO.setName( product.getName() );
        productDTO.setPrice( product.getPrice() );

        return productDTO;
    }

    @Override
    public Produto toEntity(ProductDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Produto produto = new Produto();

        produto.setName( dto.getName() );
        produto.setPrice( dto.getPrice() );

        return produto;
    }
}
