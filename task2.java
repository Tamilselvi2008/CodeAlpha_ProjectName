import java.util.*;

class Stock {
    String symbol;
    double price;

    Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }
}

class User {
    String name;
    double balance;
    Map<String, Integer> portfolio = new HashMap<>();

    User(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    void buyStock(Stock stock, int quantity) {
        double totalCost = stock.price * quantity;

        if (balance >= totalCost) {
            balance -= totalCost;
            portfolio.put(stock.symbol,
                    portfolio.getOrDefault(stock.symbol, 0) + quantity);
            System.out.println("Stock purchased successfully!");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void sellStock(Stock stock, int quantity) {
        if (portfolio.containsKey(stock.symbol)
                && portfolio.get(stock.symbol) >= quantity) {

            balance += stock.price * quantity;
            portfolio.put(stock.symbol,
                    portfolio.get(stock.symbol) - quantity);

            System.out.println("Stock sold successfully!");
        } else {
            System.out.println("Not enough shares to sell!");
        }
    }

    void showPortfolio() {
        System.out.println("\n--- Portfolio ---");
        for (String key : portfolio.keySet()) {
            System.out.println(key + " : " + portfolio.get(key) + " shares");
        }
        System.out.println("Available Balance: " + balance);
    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Stock apple = new Stock("AAPL", 150);
        Stock tesla = new Stock("TSLA", 200);

        User user = new User("Investor", 10000);

        while (true) {
            System.out.println("\n1. Buy AAPL");
            System.out.println("2. Buy TSLA");
            System.out.println("3. Sell AAPL");
            System.out.println("4. Sell TSLA");
            System.out.println("5. Show Portfolio");
            System.out.println("6. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            if (choice == 6) break;

            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();

            switch (choice) {
                case 1 -> user.buyStock(apple, qty);
                case 2 -> user.buyStock(tesla, qty);
                case 3 -> user.sellStock(apple, qty);
                case 4 -> user.sellStock(tesla, qty);
                case 5 -> user.showPortfolio();
                default -> System.out.println("Invalid option");
            }
        }

        sc.close();
    }
}