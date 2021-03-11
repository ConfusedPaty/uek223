package ch.noser.uek223.domain.product;

import ch.noser.uek223.domain.product.dto.ProductDTOBasic;
import ch.noser.uek223.domain.product.dto.ProductDTOForSupplier;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTOBasic productToProductDTOCustomer(Product product);

    List<ProductDTOBasic> productsToProductDTOsCustomer(List<Product> product);

    ProductDTOForSupplier productToProductDTOForSupplier(Product product);

    List<ProductDTOForSupplier> productsToProductDTOsForSupplier(List<Product> product);
}
