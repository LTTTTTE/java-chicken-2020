package domain;

import java.util.HashMap;
import java.util.Map;

public class Table {
    private final int number;
    private final Map<Menu, Integer> orders;

    public Table(final int number) {
        this.number = number;
        this.orders = new HashMap<>();
    }

    public void addMenu(Menu menu, int count) {
        orders.put(menu, count);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
