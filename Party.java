public class Party {
    private int guests;
    public void setGuests(int guests){
        this.guests = guests;
    }
    public int getGuests(){
        return guests;
    }
    public String displayInvitation(DinnerParty dp, Party party ){
        String x = "The party has " + party.getGuests() +
                " guests.";
        String y = "The dinner party has " + dp.getGuests() +
                " guests.";
        String z = "Menu option " + dp.getDinnerChoice() +
                " will be served.";
        String w = "Please come to my party!";
        String all = x + "\n" + y + "\n" + z + "\n" + w;
        return(all);
    }
}