/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class cartObject implements Serializable {

    private Map<String, Integer> items;

    /**
     * @return the items
     */
    public Map<String, Integer> getItems() {
        return items;
    }

    public void addItemToCart(String bookId) {
//1. Check item's id is existed
        if (bookId == null) {
            return;
        }
        if (bookId.trim().isEmpty()) {
            return;
        }
//2. when item is existed, checking existed items
        if (this.items == null) {
            this.items = new HashMap<>();
        }
//3. when items has existed, checking existed id
        int quantity = 1;
        if (this.items.containsKey(bookId)) {
            quantity = this.items.get(bookId) + 1;
        }
//4. update items
        this.items.put(bookId, quantity);
    }

    
 
    public void removeItemFromCart(String bookId) {
        if (bookId == null) {
            return;
        }
        if (bookId.trim().isEmpty()) {
            return;
        }
//        1. check existed items (kiem tra gio co hay chua)
        if (this.items == null) {
            return;
        }
//        2. check existed item name 
        if (this.items.containsKey(bookId)) {
            this.items.remove(bookId);
            if (this.items.isEmpty()) {
                this.items = null;
            }
        }
    }
}
