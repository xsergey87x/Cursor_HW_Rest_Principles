package com.cursor.rest;

import com.cursor.entity.Shop;
import com.cursor.service.ShopService;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/shops")
public class ShopController {

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
    public ResponseEntity deleteShopById(@PathVariable int shopId) {
        shopService.deleteShop(shopId);
        return new ResponseEntity<>("Shop was deleted", HttpStatus.OK);
    }

    @GetMapping("/allShops")
    public ResponseEntity getAllShop() {
        return new ResponseEntity<>(shopService.getAllShop(), HttpStatus.FOUND);
    }

    @PostMapping(value = "/modifyShop/{shopId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity modifyShop(@PathVariable int shopId, @RequestBody Shop shop) {
        return new ResponseEntity<>(shopService.editShop(shopId, shop), HttpStatus.ACCEPTED);
    }

    @PostMapping(value = "/addShop", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Shop> addShop(@RequestBody Shop shop) {
        return new ResponseEntity<>(shopService.createShop(shop), HttpStatus.valueOf(201));
    }
}

