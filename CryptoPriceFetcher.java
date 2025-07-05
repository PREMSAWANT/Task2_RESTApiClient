import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

/**
 * CryptoPriceFetcher - Fetches real-time cryptocurrency prices from CoinGecko API.
 * Demonstrates HTTP requests and JSON parsing in Java.
 */
public class CryptoPriceFetcher {
    // List of cryptocurrencies to fetch
    private static final String[] COINS = {"bitcoin", "ethereum", "dogecoin"};
    private static final String API_URL = "https://api.coingecko.com/api/v3/simple/price?ids=%s&vs_currencies=usd";

    public static void main(String[] args) {
        System.out.println("Fetching real-time cryptocurrency prices (USD)...\n");
        try {
            String joinedCoins = String.join("%2C", COINS);
            String urlStr = String.format(API_URL, joinedCoins);
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                System.out.println("Failed to fetch data. HTTP error code: " + conn.getResponseCode());
                return;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            StringBuilder sb = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                sb.append(output);
            }
            conn.disconnect();

            // Parse and display prices
            Map<String, Double> prices = parsePrices(sb.toString());
            displayPrices(prices);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Parse JSON manually (since we avoid external libraries)
    private static Map<String, Double> parsePrices(String json) {
        Map<String, Double> prices = new LinkedHashMap<>();
        for (String coin : COINS) {
            String search = String.format("\"%s\":{\"usd\":", coin);
            int idx = json.indexOf(search);
            if (idx != -1) {
                int start = idx + search.length();
                int end = json.indexOf("}", start);
                String priceStr = json.substring(start, end);
                try {
                    double price = Double.parseDouble(priceStr);
                    prices.put(coin, price);
                } catch (NumberFormatException e) {
                    prices.put(coin, null);
                }
            } else {
                prices.put(coin, null);
            }
        }
        return prices;
    }

    // Display prices in a table
    private static void displayPrices(Map<String, Double> prices) {
        System.out.println("+------------+----------+");
        System.out.println("| Coin       | Price($) |");
        System.out.println("+------------+----------+");
        for (Map.Entry<String, Double> entry : prices.entrySet()) {
            String coin = capitalize(entry.getKey());
            String price = (entry.getValue() != null) ? String.format("%.2f", entry.getValue()) : "N/A";
            System.out.printf("| %-10s | %8s |\n", coin, price);
        }
        System.out.println("+------------+----------+");
    }

    // Capitalize first letter
    private static String capitalize(String s) {
        if (s == null || s.isEmpty()) return s;
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }
} 