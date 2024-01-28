class Route {
    String location;
    Route next;

    public Route(String location) {
        this.location = location;
        this.next = null;
    }
}

class Journey {
    Route origin;
    Route destination;

    public Journey() {
        origin = null;
        destination = null;
    }

    // Method to add a new stop to the journey
    public void addStop(String location) {
        Route newStop = new Route(location);
        if (origin == null) {
            origin = newStop;
            destination = newStop;
        } else {
            destination.next = newStop;
            destination = newStop;
        }
    }

    // Method to display the route
    public void displayRoute() {
        Route current = origin;
        System.out.println("Your route:");
        while (current != null) {
            System.out.println(current.location);
            current = current.next;
        }
    }
}

public class Q2 {
    public static void main(String[] args) {
        Journey myJourney = new Journey();

        // Add stops to the journey
        myJourney.addStop("Home");
        myJourney.addStop("Jamshoro Phatak");
        myJourney.addStop("indus highway");
        myJourney.addStop("Mehran UET");

        // Display the route
        myJourney.displayRoute();
    }
}
