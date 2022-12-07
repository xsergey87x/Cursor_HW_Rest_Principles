package com.cursor.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Shop {

    int id;
    String city;
    String street;
    String shopName;
    int amountWorkers;
    boolean existSite;

    public Shop() {
    }

    public Shop(String city, String street, String shopName, int amountWorkers, boolean existSite) {
        this.city = city;
        this.street = street;
        this.shopName = shopName;
        this.amountWorkers = amountWorkers;
        this.existSite = existSite;
    }

    public Shop(int id, String city, String street, String shopName, int amountWorkers, boolean existSite) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.shopName = shopName;
        this.amountWorkers = amountWorkers;
        this.existSite = existSite;
    }
}
