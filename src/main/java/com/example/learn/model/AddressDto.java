package com.example.learn.model;

import java.io.Serializable;
import java.util.Objects;

public class AddressDto implements Serializable {
    private final Integer id;
    private final String street;
    private final String city;
    private final String state;
    private final String zip;

    public AddressDto(Integer id, String street, String city, String state, String zip) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public Integer getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip() {
        return zip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddressDto entity = (AddressDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.street, entity.street) &&
                Objects.equals(this.city, entity.city) &&
                Objects.equals(this.state, entity.state) &&
                Objects.equals(this.zip, entity.zip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, street, city, state, zip);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "street = " + street + ", " +
                "city = " + city + ", " +
                "state = " + state + ", " +
                "zip = " + zip + ")";
    }
}
