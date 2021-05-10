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

    public void StorageOutput(Integer[][] storage) {

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
            for (int i = 0; i < storage.length; i++) {
                for (int j = 0; j < amountOfNumbers; j++) {
                    if (storage[i][j] != null) {
                        if (storage[i][j].equals(storage[i][0])) {
                            System.out.print("\n" + "ID: " + (i + 1) + " -> "
                                    + "height: " + storage[i][1] + ", "
                                    + "width: " + storage[i][2] + ", "
                                    + "length: " + storage[i][3] + "\s");
                            break;
                        }
                    }
                }
            }
        }
    }
}
