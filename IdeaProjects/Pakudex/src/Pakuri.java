public class Pakuri {
    private String pakuriSpecies;
    private int pakuriAttack;
    private int pakuriDefense;
    private int pakuriSpeed;
    public Pakuri(String species) {
        this.setSpecies(species);
        this.setAttack((this.getSpecies().length() * 7) + 9);
        this.setDefenseLevel((this.getSpecies().length() * 5) + 17);
        this.setSpeed((this.getSpecies().length() * 6) + 13);
    }
    /* the following are getters and setters of the pakuri object

     */
    public String getSpecies() {//Returns the species of this critter
        return pakuriSpecies;
    }
    public void setSpecies (String species) {
        this.pakuriSpecies = species;
    }
    public int getAttack() {
        return this.pakuriAttack; //Returns the attack value for this critter
    }
    public void setPakuriAttack (int attack) {
        this.pakuriAttack = attack;
    }
    public int getDefense() {
        return this.pakuriDefense; //Returns the defense value for this critter
    }
    public void setDefenseLevel (int defenseLevel) {
        this.pakuriDefense = defenseLevel;
    }
    public int getSpeed() {//Returns the speed of this critter
        return pakuriSpeed;
    }
    public void setSpeed (int speed) {
        this.pakuriSpeed = speed;
    }
    public void setAttack(int newAttack) {//Changes the attack value for this critter to newAttack
        this.pakuriAttack = newAttack;
    }
    public void evolve() { //Will evolve the critter as follows: a) double the attack; b) quadruple the defense; and c) triple the speed
        this.setPakuriAttack(this.getAttack() * 2);
        this.setDefenseLevel(this.getDefense() * 4);
        this.setSpeed(this.getSpeed() * 3);
    }
}