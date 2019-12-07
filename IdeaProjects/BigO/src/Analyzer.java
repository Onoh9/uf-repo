import java.util.Scanner;
public class Analyzer {
    public static void main(String[] args) {
        String string;
        String [] data = StringData.getData();
        int binarySearch;
        int linearSearch;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        string = scanner.next();
        linearSearch = linearSearch(data, string);
        binarySearch = binarySearch(data, string);
        if (linearSearch == -1 && binarySearch == -1) {
            System.out.println(string + " was not found!");
        } else {
            System.out.println("Linear search string " + string + " found at index " + linearSearch + ".");
            System.out.println("Binary search string " + string + " found at index " + binarySearch + ".");
        }
    }
    // This code was built with help from a partner. She said the code was an example on zyBooks.
    public static int linearSearch(String[]dataSet, String element) {
        double beginningTime = System.nanoTime();
        for (int i = 0; i < dataSet.length; i++) {
            if (dataSet[i].equals(element)) {
                double finalTime = System.nanoTime();
                double fullTime = finalTime - beginningTime;
                System.out.println("Linear search time: " + fullTime);
                return i;
            }
        }
        double finalTime = System.nanoTime();
        double fullTime = finalTime - beginningTime;
        System.out.println("Linear search time: " + fullTime);
        return -1;
    }
    // This is also code with help from my partner
    public static int binarySearch(String[]dataSet, String element) {
        double beginningTime = System.nanoTime();
        int middle;
        int bottom = 0;
        int top = dataSet.length - 1;
        while (bottom <= top) {
            middle = (bottom + (top - 1)) / 2;
            int compare = element.compareTo(dataSet[middle]);
            if (compare == 0) {
                double finalTime = System.nanoTime();
                double fullTime = finalTime - beginningTime;
                System.out.println("Binary search time: " + fullTime);
                return middle;
            }
            else if (compare > 0) {
                bottom = middle + 1;
            }
            else {
                top = middle - 1;
            }
        }
        double finalTime = System.nanoTime();
        double fullTime = finalTime - beginningTime;
        System.out.println("Binary search time: " + fullTime);
        return -1;
    }
}

