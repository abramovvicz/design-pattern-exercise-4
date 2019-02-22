package main;

import model.*;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        Customer seller = new Customer("Jan Kowalski");
        Auction auction = new Auction(1, "Coffee", null,
                LocalDateTime.now().plusDays(2L), seller, 0, null);

        Customer buyer = new Customer("Zdzisław Dyrda");
        Customer buyer2 = new Customer("Żona Zofia");

        Auction auction2 = new Auction.AuctionBuilder(2, "some new auction item")
                .withBuyer(buyer)
                .withDescription("some item description")
                .withDueDate(LocalDateTime.of(2019, 02, 28, 12, 02, 33))
                .withHighestBid(0.45)
                .withSeller(seller).build();
        AuctionService auctionService = AuctionService.getInstance();

        IClientNotifier iClientNotifier = new ClientNotifierImp();
        iClientNotifier.registerObserver(buyer);
        iClientNotifier.registerObserver(buyer2);
        auctionService.bid(auction, new Customer("Anna Kowalik"), 20);
        iClientNotifier.notifiedObservers();
        auctionService.bid(auction, new Customer("Krzysztof Adamowicz"), 25);
        iClientNotifier.notifiedObservers();


        buyer.printNotifications();
        buyer2.printNotifications();
        System.out.println("Auction with id: " + auction.getId() + " finished. Highest bid: " + auction.getHighestBid() + " PLN.");
    }
}
