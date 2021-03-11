package ch.noser.uek223.domain.product;

import ch.noser.uek223.domain.product.dto.ProductDTOForSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductWeb {

    private ProductService productService;
    private ProductMapper productMapper;

    @Autowired
    public ProductWeb(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    // Customer

//    @GetMapping({"", "/"})
//    public ResponseEntity<List<ProductDTOCustomer>> findNonArchived() {
//        return ResponseEntity.ok().body(productMapper.productsToProductDTOCustomers(productService.findByArchived(false)));
//    }
//
//    @GetMapping(value = {"", "/"}, params = {"inclArchived=true"})
//    public ResponseEntity<List<ProductDTOCustomer>> findAll() {
//        return ResponseEntity.ok().body(productMapper.productsToProductDTOCustomers(productService.findAll()));
//    }
//
//    @GetMapping({"/{id}", "/{id}/"})
//    public ResponseEntity<ProductDTOCustomer> findById(@PathVariable("id") UUID id) {
//        return ResponseEntity.ok().body(productMapper.productToProductDTOCustomer(productService.findById(id)));
//    }
//
//    @GetMapping({"/{lower}/{upper}", "/{lower}/{upper}/"})
//    public ResponseEntity<List<ProductDTOCustomer>> findByPriceWithBounds(@PathVariable("lower") float lower, @PathVariable("upper") float upper) {
//        return ResponseEntity.ok().body(productMapper.productsToProductDTOCustomers(productService.findByPriceWithBounds(lower, upper)));
//    }
//
//    @DeleteMapping({"/{id}", "/{id}/"})
//    public ResponseEntity<ProductDTOCustomer> archiveById(@PathVariable("id") UUID id) {
//        return ResponseEntity.ok().body(productMapper.productToProductDTOCustomer(productService.archiveById(id)));
//    }

    // Supplier

    @GetMapping({"", "/"})
    @PreAuthorize("hasAnyAuthority('CAN_RETRIEVE_ALL_PRODUCTS')")
    public ResponseEntity<List<ProductDTOForSupplier>> findNonArchivedForSupplier() {
        return ResponseEntity.ok().body(productMapper.productsToProductDTOsForSupplier(productService.findByArchived(false)));
    }

    @GetMapping(value = {"", "/"}, params = {"inclArchived=true"})
    public ResponseEntity<List<ProductDTOForSupplier>> findAllForSupplier() {
        return ResponseEntity.ok().body(productMapper.productsToProductDTOsForSupplier(productService.findAll()));
    }

    @GetMapping({"/{id}", "/{id}/"})
    public ResponseEntity<ProductDTOForSupplier> findByIdForSupplier(@PathVariable("id") UUID id) {
        return ResponseEntity.ok().body(productMapper.productToProductDTOForSupplier(productService.findById(id)));
    }

    @GetMapping({"/{lower}/{upper}", "/{lower}/{upper}/"})
    public ResponseEntity<List<ProductDTOForSupplier>> findByPriceWithBoundsForSupplier(@PathVariable("lower") float lower, @PathVariable("upper") float upper) {
        return ResponseEntity.ok().body(productMapper.productsToProductDTOsForSupplier(productService.findByPriceWithBounds(lower, upper)));
    }

    @DeleteMapping({"/{id}", "/{id}/"})
    public ResponseEntity<ProductDTOForSupplier> archiveByIdForSupplier(@PathVariable("id") UUID id) {
        return ResponseEntity.ok().body(productMapper.productToProductDTOForSupplier(productService.archiveById(id)));
    }
}
