import java.util.Date;

public class Ticket {
    enum eTicketType {
        Regular,
        Child,
        SeniorCitizen,
        Handicapped,
        Soldier
    }
    public eTicketType TicketType;
    private int price;

    public eTicketType getTicketType() {
        return TicketType;
    }

    public void setTicketType(eTicketType ticketType) {
        TicketType = ticketType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
