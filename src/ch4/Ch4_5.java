package ch4;

import java.util.Objects;

public class Ch4_5 {
    public static void main(String[] args) {
        Item item1 = new Item("a", 1);
        Item item2 = new Item("a", 1);

        System.out.println(item1.equals(item2));
    }
}

class Item {
    private String description;
    private double price;

    public Item(String description, double price){
        this.description = description;
        this.price = price;
    }

    @Override
    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (!(other instanceof Item)) {
            return false;
        }

        Item otherItem = (Item) other;

        return price == otherItem.price && description.equals(otherItem.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, description);
    }
}

