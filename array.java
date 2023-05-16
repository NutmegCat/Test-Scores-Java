public class array {

    //initialize vars
    static int score;
    static int[] markScores;
    static double PRECISION = 10.0;
    static int totalOccurrences;


    public static void main(String[] args) {

        //initial array capacity
        final int INITIAL_CAPACITY = 11;

        //initial array
        markScores = new int[INITIAL_CAPACITY];
        totalOccurrences = 0;

        //ask for scores
        while (true) {
            System.out.print("\nEnter a score (or a negative value to exit): ");
            score = In.getInt();

            //exit loop
            if (score < 0) {
                break;
            }

            //ignore values over 11
            if (score < INITIAL_CAPACITY) {
                // Expand the scores array if it gets full
                if (totalOccurrences == markScores.length) {
                    markScores = expandArray(markScores);
                }

                markScores[score]++;
                totalOccurrences++;
            }
        }

        //print table headers
        System.out.println("\nScore\t\t# of Occurrences");

        //calculate average
        double sum = 0.0;
        double mean;
        for (int i = 0; i < markScores.length; i++) {
            if (markScores[i] != 0) {
                System.out.println(i + "\t\t" + markScores[i]);
                sum += i * markScores[i];
            }
        }
        mean = sum / totalOccurrences;

        // print average
        System.out.println("\nMean score: " + Math.round(mean * PRECISION) / PRECISION + "\n");
    }

    //expand array
    private static int[] expandArray(int[] array) {
        int newCapacity = array.length * 2;
        int[] newArray = new int[newCapacity];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
}