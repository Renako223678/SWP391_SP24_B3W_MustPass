/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cart;

import dto.Book;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 */
public class Cart {

    private Map<String, Book> cart;

    public Cart() {
    }

    public Cart(Map<String, Book> cart) {
        this.cart = cart;
    }

    //Lấy giỏ hàng
    public Map<String, Book> getCart() {
        return cart;
    }

    //Thiết đặt giỏ hàng
    public void setCart(Map<String, Book> cart) {
        this.cart = cart;
    }

    //Thêm sản phẩm mới vào giỏ hàng
    public boolean add(Book book, Cart cart) {
    boolean check = false;

    if (cart.getCart() == null) {
        cart.setCart(new HashMap<>());
    }

    String bookIdStr = Integer.toString(book.getBookId());

    if (cart.getCart().containsKey(bookIdStr)) {
        // Nếu sách đã có trong giỏ, cập nhật lại số lượng
        Book existingBook = cart.getCart().get(bookIdStr);
        int newQuantity = existingBook.getQuantity() + book.getQuantity(); // Tính toán số lượng mới
        existingBook.setQuantity(newQuantity); // Cập nhật số lượng
    } else {
        // Nếu sách chưa có trong giỏ, thêm vào giỏ
        cart.getCart().put(bookIdStr, book);
    }

    check = true;
    return check;
}


    //Xóa sản phẩm khỏi giỏ hàng
    public boolean remove(int productID) {
        boolean check = false;
        if (this.cart != null) {
            if (this.cart.containsKey(Integer.toString(productID))) {
                this.cart.remove(Integer.toString(productID));
                check = true;
            }
        }
        return check;
    }

    //Chỉnh sửa số lượng sản phẩm
    public boolean edit(int productID, Book product) {
        boolean check = false;
        if (this.cart != null) {
            if (this.cart.containsKey(Integer.toString(productID))) {
                this.cart.replace(Integer.toString(productID), product);
                check = true;
            }
        }
        return check;
    }

    //Lấy tổng thành tiền của giỏ hàng
    public float getTotalMoney() {
        float total = 0;
        for (Book book : cart.values()) {
            total += book.getQuantity() * book.getUnitPrice();
        }
        return total;
    }

    //Xóa tất cả sản phẩm trong giỏ hàng
    public boolean removeAll() {
        boolean check = false;
        if (this.cart != null) {
            this.cart.clear();
            check = true;
        }
        return check;
    }
    // Lấy tổng số lượng các đơn hàng trong giỏ hàng
    public int getTotalQuantity() {
        int totalQuantity = 0;
        if (cart != null) {
            for (Book book : cart.values()) {
                totalQuantity += book.getQuantity();
            }
        }
        return totalQuantity;
    }
    
}
//<<<<<<<<<<