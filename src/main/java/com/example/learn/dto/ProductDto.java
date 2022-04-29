package com.example.learn.dto;

import java.io.Serializable;
import java.util.Objects;


public class ProductDto implements Serializable {
    private final Integer id;
    private final String name;
    private final String description;
    private final Float price;
    private final Integer quantity;
    private final String unit;
    private final Integer categoryId;
    private final String categoryName;
    private final String categoryDescription;

    public ProductDto(Integer id, String name, String description, Float price, Integer quantity, String unit, Integer categoryId, String categoryName, String categoryDescription) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.unit = unit;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Float getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto entity = (ProductDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.price, entity.price) &&
                Objects.equals(this.quantity, entity.quantity) &&
                Objects.equals(this.unit, entity.unit) &&
                Objects.equals(this.categoryId, entity.categoryId) &&
                Objects.equals(this.categoryName, entity.categoryName) &&
                Objects.equals(this.categoryDescription, entity.categoryDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, quantity, unit, categoryId, categoryName, categoryDescription);
    }


    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "description = " + description + ", " +
                "price = " + price + ", " +
                "quantity = " + quantity + ", " +
                "unit = " + unit + ", " +
                "categoryId = " + categoryId + ", " +
                "categoryName = " + categoryName + ", " +
                "categoryDescription = " + categoryDescription + ")";
    }
}
