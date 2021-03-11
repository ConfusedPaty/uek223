package ch.noser.uek223.domain.product.dto;

import ch.noser.uek223.domain.user.dto.UserDTOWithoutRoles;

import java.util.UUID;

public class ProductDTOForSupplier {

    private UUID id;

    private String description;

    private float retailPrice;

    private float buyingPrice;

    private UserDTOWithoutRoles supplier;

    private boolean archived;

    public ProductDTOForSupplier() {
    }

    public ProductDTOForSupplier(UUID id, String description, float retailPrice, float buyingPrice, UserDTOWithoutRoles supplier, boolean archived) {
        this.id = id;
        this.description = description;
        this.retailPrice = retailPrice;
        this.buyingPrice = buyingPrice;
        this.supplier = supplier;
        this.archived = archived;
    }

    public UUID getId() {
        return id;
    }

    public ProductDTOForSupplier setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductDTOForSupplier setDescription(String description) {
        this.description = description;
        return this;
    }

    public float getRetailPrice() {
        return retailPrice;
    }

    public ProductDTOForSupplier setRetailPrice(float retailPrice) {
        this.retailPrice = retailPrice;
        return this;
    }

    public float getBuyingPrice() {
        return buyingPrice;
    }

    public ProductDTOForSupplier setBuyingPrice(float buyingPrice) {
        this.buyingPrice = buyingPrice;
        return this;
    }

    public UserDTOWithoutRoles getSupplier() {
        return supplier;
    }

    public ProductDTOForSupplier setSupplier(UserDTOWithoutRoles supplier) {
        this.supplier = supplier;
        return this;
    }

    public boolean isArchived() {
        return archived;
    }

    public ProductDTOForSupplier setArchived(boolean archived) {
        this.archived = archived;
        return this;
    }
}
