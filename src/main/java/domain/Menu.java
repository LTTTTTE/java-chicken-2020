package domain;

public class Menu {
    private final int number;
    private final String name;
    private final Category category;
    private final int price;

    public Menu(final int number, final String name, final Category category, final int price) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public boolean isSameMenuNumber(int number) {
        return this.number == number;
    }

    public int getPriceByMultiple(int multipleValue) {
        return price * multipleValue;
    }

    public boolean isChickenCategory() {
        return category.isChicken();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }
}
