import java.util.List;

public class Park {
    private String name;
    private String location;
    private List<Ride> ridesList;

    public Park(String i_name, String i_location) {
        name = i_name;
        location = i_location;
        ridesList = null;
    }

    public void addRide(Ride ride){
        ridesList.add(ride);
    }

    public void removeRide(Ride ride){
        ridesList.remove(ride);
    }

    public void addPark()
}

