import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class TicketMaster {

    public static void main(String[] args) {
        buildShow();
    }
    public static Scanner scanner = new Scanner(System.in);

    public static ArrayList<Show> buildShow() {
        ArrayList<Show> venues = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("showData.txt"))) {
            String venue;
            while ((venue = br.readLine()) != null) {
                String[] parts = venue.split("");
                Show show = new Show(parts[0], Double.parseDouble(parts[1]), Integer.parseInt(parts[2]), parts[3].replace("-","").replace(",",""), parts[4].replace("-",""));
                venues.add(show);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return venues;
    }


    public static void citySearch(ArrayList<Show> venues){
        System.out.println("\n Which city are you looking for?");
        String city = scanner.nextLine();
        ArrayList<Show> cities = new ArrayList<>();
        for (Show search: venues){
            if (search.getCity().equalsIgnoreCase(city)){
                cities.add(search);
            }
        }
        if (cities.isEmpty()){
            System.out.println("\n It appears that there are no shows in " + city + ".");
        }
        Show.printedArray(venues);
    }

    public static void sortByPriceHL(ArrayList<Show> venues){
        for (int i = 1; i < venues.size(); i++){
            Show p = venues.get(i);
            int k = i - 1;

            while (k >= 0 && venues.get(k).getPrice() < p.getPrice()){
                venues.set(k + 1, venues.get(k));
                k = k - 1;
            }
            venues.set(k + 1, p);
        }
        Show.printedArray(venues);
    }

    public static void sortByPriceLH(ArrayList<Show> venues){
        for (int i = 1; i < venues.size(); i++){
            Show p = venues.get(i);
            int k = i - 1;

            while (k >= 0 && venues.get(k).getPrice() > p.getPrice()){
                venues.set(k + 1, venues.get(k));
                k = k - 1;
            }
            venues.set(k + 1, p);
        }
        Show.printedArray(venues);
    }

    public static void sortByPerformerAZ(ArrayList<Show> venues){
        for (int i = 0; i < venues.size() - 1; i++){
            int minIndex = i;
            for (int m = i + 1; m < venues.size(); i++){
                if (venues.get(m).getPreformer().compareToIgnoreCase(venues.get(minIndex).getPreformer()) < 0){
                    minIndex = m;
                }
            }
            Show temp = venues.get(minIndex);
            venues.set(minIndex,venues.get(i));
            venues.set(i, temp);
        }
        Show.printedArray(venues);
    }

    public static void sortByPerformerZA(ArrayList<Show> venues){
        for (int i = 0; i < venues.size() - 1; i++){
            int maxIndex = i;
            for (int n = i + 1; n < venues.size(); i++){
                if (venues.get(n).getPreformer().compareToIgnoreCase(venues.get(maxIndex).getPreformer()) > 0){
                    maxIndex = n;
                }
            }
            Show temp = venues.get(maxIndex);
            venues.set(maxIndex,venues.get(i));
            venues.set(i, temp);
        }
        Show.printedArray(venues);
    }
}
