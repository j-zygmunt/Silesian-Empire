import java.io.Serializable;

public class Building implements Serializable {
    private final String name;
    private final int price;
    private final int income;
    private final int payoutInterval;
    private int amount;

    public Building(final String name, final int price, final int income, final int payoutInterval, final int amount) {
        this.name = name;
        this.price = price;
        this.income = income;
        this.payoutInterval = payoutInterval;
        this.amount = amount;
    }

    public Building(final String name, final int price, final int income, final int payoutInterval) {
        this(name, price, income, payoutInterval, 0);
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }

    public int getIncome() {
        return income;
    }

    public int getPayoutInterval() {
        return payoutInterval;
    }

    public void incrementAmount() {
        amount += 1;
    }
}