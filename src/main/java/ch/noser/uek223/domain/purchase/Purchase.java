package ch.noser.uek223.domain.purchase;

import ch.noser.uek223.domain.purchase_product.PurchaseProduct;
import ch.noser.uek223.domain.user.User;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
public class Purchase {

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

    @OneToMany(mappedBy = "purchase", fetch = FetchType.EAGER)
    private Set<PurchaseProduct> purchaseProducts;

    @ManyToOne(fetch = FetchType.EAGER)
    private User customer;

    public Purchase() {
    }

    public UUID getId() {
        return id;
    }

    public Purchase setId(UUID id) {
        this.id = id;
        return this;
    }

    public Set<PurchaseProduct> getPurchaseProducts() {
        return purchaseProducts;
    }

    public Purchase setPurchaseProducts(Set<PurchaseProduct> purchaseProducts) {
        this.purchaseProducts = purchaseProducts;
        return this;
    }

    public User getCustomer() {
        return customer;
    }

    public Purchase setCustomer(User customer) {
        this.customer = customer;
        return this;
    }
}
