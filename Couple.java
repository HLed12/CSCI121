public class Couple extends Person{
    private Person bride;
    private Person groom;


    public void setCouple(Person bride, Person groom) {
        this.bride = bride;
        this.groom = groom;
    }

    public Person getBride() {
        return bride;
    }
    public Person getGroom() {
        return groom;
    }

}
