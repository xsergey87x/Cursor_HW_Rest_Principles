package com.cursor.rest;

import com.cursor.entity.Shop;
import com.cursor.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;

@RestController
public class ShopController {

    @Autowired
    private ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/getShop/{shopId}")
    public ResponseEntity getShopById(@PathVariable int shopId) {
        Shop resShop = shopService.getShopById(shopId);
        if (resShop == null) {
            return ResponseEntity.status(HttpStatus.valueOf(404)).body("Shop with this Id doesn't exist");
        }
        return new ResponseEntity<>(resShop, HttpStatus.OK);
    }

    @GetMapping("/deleteShop/{shopId}")
    public String deleteShopById(@PathVariable int shopId) {
        shopService.deleteShop(shopId);
        return "Shop was deleted";
    }

    @GetMapping("/allShops")
    public ArrayList<Shop> getAllShop() {
        return shopService.getAllShop();
    }

    @PostMapping(value = "/modifyShop/{shopId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Shop modifyShop(@PathVariable int shopId, @RequestBody Shop shop) {
        return shopService.editShop(shopId, shop);
    }

    @PostMapping(value = "/addShop", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Shop> addShop(@RequestBody Shop shop) {
        return new ResponseEntity<>(shopService.createShop(shop), HttpStatus.valueOf(201));
    }
}

