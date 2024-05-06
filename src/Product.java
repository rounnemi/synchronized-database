
import java.util.Arrays;
import java.util.UUID;

public class Product {

    public String id;
    public String product;
    public int qty;
    public float cost;
    public float amt;
    public float tax;
    public float total;
    public String region;

    public static Product parseObjectFromString(String s) {
        try {
            String[] fields = s.split(" ");
            System.out.println(Arrays.toString(fields));


            String id = String.format(fields[0]);
            String productName = fields[1];
            int qty = Integer.parseInt(fields[2]);
            float cost = Float.parseFloat(fields[3]);
            float amt = Float.parseFloat(fields[4]);
            float tax = Float.parseFloat(fields[5]);
            float total = Float.parseFloat(fields[6]);
            String region = String.format(fields[7]);
            return new Product(id, productName, qty, cost, amt, tax, total, region);
        } catch ( IllegalArgumentException e) {
            // Handle parsing errors
            System.out.println("Error parsing string to Product object: " + e.getMessage());
            return null; // Or handle the error in a different way
        }
    }


    @Override
    public String toString() {
        return this.id + " " + this.product + " " + this.qty + " " + this.cost + " " + this.amt + " " + this.tax
                + " " + this.total + " " + this.region ;
    }

    public Product(String id, String product, int qty, float cost, float amt, float tax, float total,
                   String region){
        this.id = id;
        this.product = product;
        this.qty = qty;
        this.cost = cost;
        this.amt = amt;
        this.tax = tax;
        this.total = total;
        this.region = region;
    }

    public Product(String product, int qty, float cost, float amt, float tax, float total,
                   String region){
        id = UUID.randomUUID().toString();
        this.product = product;
        this.qty = qty;
        this.cost = cost;
        this.amt = amt;
        this.tax = tax;
        this.total = total;
        this.region = region;
    }
}
