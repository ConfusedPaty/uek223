package ch.noser.uek223.domain.product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    List<Product> findByArchived(boolean archived);

    List<Product> findAll();

    Product findById(UUID id);

    List<Product> findByPriceWithBounds(float lower, float upper);

    Product archiveById(UUID id);
}
