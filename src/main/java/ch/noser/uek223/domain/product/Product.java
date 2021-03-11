package ch.noser.uek223.domain.product;

import ch.noser.uek223.domain.purchase_product.PurchaseProduct;
import ch.noser.uek223.domain.user.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
public class Product {

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

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private float retailPrice;

    @Column(nullable = false)
    private float buyingPrice;

    @ManyToOne(fetch = FetchType.EAGER)
    private User supplier;

    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    private Set<PurchaseProduct> purchaseProducts;

    @Column(nullable = true)
    private boolean archived;

    public Product() {
    }

    public Product(UUID id, String description, float retailPrice, float buyingPrice, User supplier, Set<PurchaseProduct> purchaseProducts, boolean archived) {
        this.id = id;
        this.description = description;
        this.retailPrice = retailPrice;
        this.buyingPrice = buyingPrice;
        this.supplier = supplier;
        this.purchaseProducts = purchaseProducts;
        this.archived = archived;
    }

    public UUID getId() {
        return id;
    }

    public Product setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public float getRetailPrice() {
        return retailPrice;
    }

    public Product setRetailPrice(float retailPrice) {
        this.retailPrice = retailPrice;
        return this;
    }

    public float getBuyingPrice() {
        return buyingPrice;
    }

    public Product setBuyingPrice(float buyingPrice) {
        this.buyingPrice = buyingPrice;
        return this;
    }

    public User getSupplier() {
        return supplier;
    }

    public Product setSupplier(User supplier) {
        this.supplier = supplier;
        return this;
    }

    public Set<PurchaseProduct> getPurchaseProducts() {
        return purchaseProducts;
    }

    public Product setPurchaseProducts(Set<PurchaseProduct> purchaseProducts) {
        this.purchaseProducts = purchaseProducts;
        return this;
    }

    public boolean isArchived() {
        return archived;
    }

    public Product setArchived(boolean archived) {
        this.archived = archived;
        return this;
    }
}
