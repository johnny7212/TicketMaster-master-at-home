import java.util.ArrayList;


public class TicketMasterDriver {

    public static void main(String[] args) {
        ArrayList <Show> venues = TicketMaster.buildShow();

        System.out.println("        ****Welcome to the Ticket Master Kiosk****");
        System.out.println("You may search shows by city as well as by performer and ticket price.");
        System.out.println("    Simply choose the option corresponding to your needs.");
        while (true){
            System.out.println("");
            System.out.println("1.Search by City\n" +
                    "2.Sort by Performer (A-Z)\n" +
                    "3.Sort by Performer (Z-A)\n" +
                    "4.Sort by Price (High - Low)\n" +
                    "5.Sort by Price (Low - High)\n" +
                    "6.Quit\n\n\n");
            System.out.println("Choose an option between 1 and 6");
            int input = Integer.parseInt(TicketMaster.scanner.nextLine());
            if (input > 6){
                System.out.println("Please choose an option between 1 and 6");
            }
            else {
                if (input == 1){
                    TicketMaster.citySearch(venues);
                }
                if (input == 2){
                    TicketMaster.sortByPerformerAZ(venues);
                }
                if (input == 3){
                    TicketMaster.sortByPerformerZA(venues);

                }
                if (input == 4){
                    TicketMaster.sortByPriceHL(venues);

                }
                if (input == 5){
                    TicketMaster.sortByPriceLH(venues);

                }
                if (input == 6){
                    System.out.println("Thank you for visiting our TicketMaster Kiosk");
                    System.out.println("Have a good day!");
                    break;
                }
            }
        }

    }
}
