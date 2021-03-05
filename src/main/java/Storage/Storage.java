package Storage;

import java.util.Arrays;

/**
 * class Storage
 *
 * @author Kevin
 */
public class Storage {

    int count = 0;
    int maxBoxes = 10;
    int amountOfNumbers = 4;
    private final Integer[][] storage = new Integer[maxBoxes][amountOfNumbers];

    public Integer[][] getStorage() {
        return Arrays.copyOf(storage, storage.length);
    }

    public void StorageOutput(Integer[][] array) {

        for (Integer[] integers : storage) {
            for (int j = 0; j < amountOfNumbers; j++) {
                if (integers[j] == null) {
                    count++;
                }
            }
        }
        if (count == 0) {
            System.out.println("Sorry but the Storage is full, please delete a box you dont need anymore");
        }
        if (count != 40) {
            System.out.println(Arrays.deepToString(array)
                    .replace("[[", " ")
                    .replace(",", " ")
                    .replace("]", "\n")
                    .replace("[", " ")
                    .replace("]]", " "));
        }
    }
}
