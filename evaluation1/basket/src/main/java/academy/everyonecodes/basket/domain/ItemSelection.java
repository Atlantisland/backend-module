package academy.everyonecodes.basket.domain;

import java.util.Objects;

public class ItemSelection {

    private String userEmail;
    private String itemName;
    private double itemPrice;

    ItemSelection() {
    }

    public ItemSelection(String userEmail, String itemName, double itemPrice) {
        this.userEmail = userEmail;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public String getUserEmail() {
        return userEmail;
    }

    void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getItemName() {
        return itemName;
    }

    void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemSelection that = (ItemSelection) o;
        return Double.compare(that.itemPrice, itemPrice) == 0 &&
                Objects.equals(userEmail, that.userEmail) &&
                Objects.equals(itemName, that.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userEmail, itemName, itemPrice);
    }
}
