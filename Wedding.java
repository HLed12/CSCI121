import java.time.LocalDate;

public class Wedding extends Couple{
    private LocalDate date;
    private Couple cup;
    private String location;

    public void setWedding(Couple cup, LocalDate date, String location) {
        this.cup = cup;
        this.date = date;
        this.location = location;
    }

    public Couple getCouple() {
        return cup;
    }
    public LocalDate getDate() {
        return date;
    }
    public String getLocation() {
        return location;
    }

    public void printWeddingDetails() {
        System.out.println("WE ARE GETTING MARRIED");
        System.out.println(this.getCouple().getBride().getFirstName() + " " +
                this.getCouple().getBride().getLastName() );
        System.out.println("and");
        System.out.println(this.getCouple().getGroom().getFirstName() +
                " " + this.getCouple().getGroom().getLastName());
        System.out.println("Date: " + this.getDate() + " at " + this.getLocation());
    }

}