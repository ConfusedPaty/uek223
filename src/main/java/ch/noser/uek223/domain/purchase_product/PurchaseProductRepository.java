package ch.noser.uek223.domain.purchase_product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PurchaseProductRepository extends JpaRepository<PurchaseProduct, UUID> {
}
