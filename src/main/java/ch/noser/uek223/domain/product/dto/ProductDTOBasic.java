package ch.noser.uek223.domain.product.dto;

import java.util.UUID;

public class ProductDTOBasic {

    private UUID id;

    private String description;

    private float retailPrice;

    private boolean archived;

    public ProductDTOBasic() {
    }

    public ProductDTOBasic(UUID id, String description, float retailPrice, boolean archived) {
        this.id = id;
        this.description = description;
        this.retailPrice = retailPrice;
        this.archived = archived;
    }

    public UUID getId() {
        return id;
    }

    public ProductDTOBasic setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductDTOBasic setDescription(String description) {
        this.description = description;
        return this;
    }

    public float getRetailPrice() {
        return retailPrice;
    }

    public ProductDTOBasic setRetailPrice(float retailPrice) {
        this.retailPrice = retailPrice;
        return this;
    }

    public boolean isArchived() {
        return archived;
    }

    public ProductDTOBasic setArchived(boolean archived) {
        this.archived = archived;
        return this;
    }
}
