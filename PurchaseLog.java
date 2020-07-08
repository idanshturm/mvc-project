import java.util.Date;
import java.util.List;

public class PurchaseLog {
    private int ticketsAmount;
    private int totalPaidAmount;
    private List<Ticket> TicketsList;
    private Date ticketsPurchaseDate;
    private Date ticketsUsageDate;

    public int getTicketsAmount() {
        return ticketsAmount;
    }

    public void setTicketsAmount(int ticketsAmount) {
        this.ticketsAmount = ticketsAmount;
    }

    public int getTotalPaidAmount() {
        return totalPaidAmount;
    }

    public void setTotalPaidAmount(int totalPaidAmount) {
        this.totalPaidAmount = totalPaidAmount;
    }

    public List<Ticket> getTicketsList() {
        return TicketsList;
    }

    public void setTicketsList(List<Ticket> ticketsList) {
        TicketsList = ticketsList;
    }

    public Date getTicketsPurchaseDate() {
        return ticketsPurchaseDate;
    }

    public void setTicketsPurchaseDate(Date ticketsPurchaseDate) {
        this.ticketsPurchaseDate = ticketsPurchaseDate;
    }

    public Date getTicketsUsageDate() {
        return ticketsUsageDate;
    }

    public void setTicketsUsageDate(Date ticketsUsageDate) {
        this.ticketsUsageDate = ticketsUsageDate;
    }
}


