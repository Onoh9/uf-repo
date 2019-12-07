import java.util.*;
class Pakudex { // the code in this class builds the pakudex according to its functions and limitations explained in the project pdf
    private int size;
    private List<String> pakuriArray = new ArrayList<>();
    private HashMap<String, Pakuri> pakuriHashMap = new HashMap<>();
    private int[] stats = new int[3];
    public Pakudex() {
        setCapacity(20); // Default constructor; if called, the default size for the Pakudex should be 20
    }
    /* the following are setters and getters for the pakudex when it"s called in the main pakuri program

     */
    public Pakudex(int capacity) {
        setCapacity(capacity); //Initializes this object to contain exactly capacity objects when completely full
    }
    public int getSize() {
        return this.pakuriArray.size(); // Returns the number of critters currently being stored in the Pakudex
    }
    public int getCapacity() {
        return this.size; // Returns the number of critters that the Pakudex has the capacity to hold at most
    }
    public void setCapacity (int capacity) {
        this.size = capacity;
    }
    public String[] getSpeciesArray() { // Returns a String array containing the species of the critters as ordered in the Pakudex; if there are no species added yet, this method should return null
        if (this.pakuriArray.size() == 0) {
            return null;
        }
        String[] stringArray = new String[this.pakuriArray.size()];
        return this.pakuriArray.toArray(stringArray);
    }
    public void setSpeciesArray (String species) {
        Pakuri pakuri = new Pakuri(species);
        this.pakuriHashMap.put(species, pakuri);
        this.pakuriArray.add(species);
    }
    public int[] getStats(String species) { //Returns  an  int  array  containing  the  attack,  defense,  and  speed  statistics  of  species  at  indices  0,  1,  and  2  respectively; if species is not in the Pakudex, returns null
        if (pakuriHashMap.containsKey(species)) {
            Pakuri pakuri = pakuriHashMap.get(species);
            this.stats[0] = pakuri.getAttack();
            this.stats[1] = pakuri.getDefense();
            this.stats[2] = pakuri.getSpeed();
            return this.stats;
        } else {
            return null;
        }
    }
    /* the following are pakudex menuOptions that can be called through the main pakuri program

     */
    public boolean addPakuri(String species) { //Adds species to the Pakudex; if successful, return true, and false otherwise
        if (this.getSpeciesArray() == null || !Arrays.asList(this.getSpeciesArray()).contains(species)) {
            this.setSpeciesArray(species);
            return true;
        }
        return false;
    }
    public boolean evolveSpecies(String species) { //Attempts to evolve species within the Pakudex; if successful, return true, and false otherwise
        if (this.getSpeciesArray() != null && Arrays.asList(this.getSpeciesArray()).contains(species)) {
            Pakuri pakObject = new Pakuri(species);
            pakObject.evolve();
            pakuriHashMap.put(species, pakObject);
            return true;
        }
        return false;
    }
    public void sortPakuri() { //Sorts the Pakuri objects in thisPakudex according to Java standard lexicographical ordering of species name
        Collections.sort(this.pakuriArray);
    }
}
