package ch.noser.uek223.domain.purchase_product;

import ch.noser.uek223.domain.product.Product;
import ch.noser.uek223.domain.purchase.Purchase;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class PurchaseProduct {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "uuid_gen_strategy_class",
                            value = "org.hibernate.id.uuid.CustomVersionOneStrategy"
                    )
            }
    )
    @Column(updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Purchase purchase;

    @ManyToOne(fetch = FetchType.EAGER)
    private Product product;

    @Column(nullable = false)
    private int amount;

    public PurchaseProduct() {
    }

    public UUID getId() {
        return id;
    }

    public PurchaseProduct setId(UUID id) {
        this.id = id;
        return this;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public PurchaseProduct setPurchase(Purchase purchase) {
        this.purchase = purchase;
        return this;
    }

    public Product getProduct() {
        return product;
    }

    public PurchaseProduct setProduct(Product product) {
        this.product = product;
        return this;
    }

    public int getAmount() {
        return amount;
    }

    public PurchaseProduct setAmount(int amount) {
        this.amount = amount;
        return this;
    }
}
