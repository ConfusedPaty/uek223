package ch.noser.uek223.domain.product;

import ch.noser.uek223.domain.product.dto.ProductDTOBasic;
import ch.noser.uek223.domain.product.dto.ProductDTOForSupplier;
import ch.noser.uek223.domain.user.User;
import ch.noser.uek223.domain.user.dto.UserDTOWithoutRoles;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-03-11T16:41:41+0100",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.8.2.jar, environment: Java 15 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDTOBasic productToProductDTOCustomer(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTOBasic productDTOBasic = new ProductDTOBasic();

        productDTOBasic.setId( product.getId() );
        productDTOBasic.setDescription( product.getDescription() );
        productDTOBasic.setRetailPrice( product.getRetailPrice() );
        productDTOBasic.setArchived( product.isArchived() );

        return productDTOBasic;
    }

    @Override
    public List<ProductDTOBasic> productsToProductDTOsCustomer(List<Product> product) {
        if ( product == null ) {
            return null;
        }

        List<ProductDTOBasic> list = new ArrayList<ProductDTOBasic>( product.size() );
        for ( Product product1 : product ) {
            list.add( productToProductDTOCustomer( product1 ) );
        }

        return list;
    }

    @Override
    public ProductDTOForSupplier productToProductDTOForSupplier(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDTOForSupplier productDTOForSupplier = new ProductDTOForSupplier();

        productDTOForSupplier.setId( product.getId() );
        productDTOForSupplier.setDescription( product.getDescription() );
        productDTOForSupplier.setRetailPrice( product.getRetailPrice() );
        productDTOForSupplier.setBuyingPrice( product.getBuyingPrice() );
        productDTOForSupplier.setSupplier( userToUserDTOWithoutRoles( product.getSupplier() ) );
        productDTOForSupplier.setArchived( product.isArchived() );

        return productDTOForSupplier;
    }

    @Override
    public List<ProductDTOForSupplier> productsToProductDTOsForSupplier(List<Product> product) {
        if ( product == null ) {
            return null;
        }

        List<ProductDTOForSupplier> list = new ArrayList<ProductDTOForSupplier>( product.size() );
        for ( Product product1 : product ) {
            list.add( productToProductDTOForSupplier( product1 ) );
        }

        return list;
    }

    protected UserDTOWithoutRoles userToUserDTOWithoutRoles(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTOWithoutRoles userDTOWithoutRoles = new UserDTOWithoutRoles();

        userDTOWithoutRoles.setId( user.getId() );
        userDTOWithoutRoles.setEmail( user.getEmail() );
        userDTOWithoutRoles.setFirstName( user.getFirstName() );
        userDTOWithoutRoles.setLastName( user.getLastName() );

        return userDTOWithoutRoles;
    }
}
