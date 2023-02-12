import java.util.ArrayList;

public class Show {
    private String date;
    private double price;
    private int qty;
    private String performer;
    private String city;


    public Show(String date, double price, int qty, String performer, String city) {
        this.date = date;
        this.price = price;
        this.qty = qty;
        this.performer = performer;
        this.city = city;
    }


    public String getDate() {
        return date;
    }


    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public String getPreformer() {
        return performer;
    }

    public String getCity() {
        return city;
    }

    public static void printedArray(ArrayList<Show> venues) {
        System.out.println("Date \t\tPrice \t  Qty \tPerformer \t\t   City");
        System.out.println("--------------------------------------------------------------------------");
        for (Show v : venues) {
            System.out.println(v.toString());
        }
    }
    @Override
    public String toString() {
        return this.getDate() + "\t\t$" + this.getPrice() + "\t\t" + this.getQty() + "\t\t" + this.getPreformer() + "\t\t\t" + this.getCity();
    }
}
