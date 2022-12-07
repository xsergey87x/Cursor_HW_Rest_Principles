package com.cursor.service;

import com.cursor.entity.Shop;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ShopService {

    private final ArrayList<Shop> shopCollection = new ArrayList<>();

    public Shop createShop(Shop shop) {
        int lastId = 0;
        if (shopCollection.size() > 0) {
            lastId = shopCollection.get(shopCollection.size() - 1).getId();
        }
        Shop newShop = new Shop(lastId + 1, shop.getCity(), shop.getStreet(), shop.getShopName(), shop.getAmountWorkers(), shop.isExistSite());
        shopCollection.add(newShop);
        return newShop;
    }

    public void deleteShop(int id) {
        int position = getPositionShopById(id);
        if (position != -1) {
            shopCollection.remove(position);
        }
    }

    public ArrayList<Shop> getAllShop() {
        return shopCollection;
    }

    public Shop getShopById(int id) {
        int index = getPositionShopById(id);
        if (index != -1) return shopCollection.get(index);
        else return null;
    }

    public Shop editShop(int id, Shop newShop) {
        int index = getPositionShopById(id);
        Shop resultShop = new Shop(id, newShop.getCity(), newShop.getStreet(), newShop.getShopName(), newShop.getAmountWorkers(), newShop.isExistSite());
        shopCollection.set(index, resultShop);
        return resultShop;
    }

    private int getPositionShopById(int id) {
        int indexShop = -1;
        for (int i = 0; i < shopCollection.size(); i++) {
            if (shopCollection.get(i).getId() == id) {
                indexShop = i;
                break;
            }
        }
        return indexShop;
    }

}
