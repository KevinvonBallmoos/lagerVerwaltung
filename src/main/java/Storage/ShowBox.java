package Storage;

import java.util.Arrays;

public class ShowBox {

    UserEnterInput userInput = new UserEnterInput();
    int amountOfNumbers = 4;
    String boxId;

    public boolean showBox(Integer[][] array) {

        do {
            System.out.println("""
                    #A : Enter the values to Show a Box
                    #B : Go back to the Main Menu""");
            String input = userInput.updateInput().toUpperCase();
            if (input.equals("B")) {
                return false;
            } else if (input.equals("A")) {
                do {
                    System.out.println("""     
                            Enter the Serial ID from your Box""");
                    boxId = userInput.enterInput();

                } while (!validateUpdateInput(boxId, array));
            }
        } while (showBoxDetails(boxId, array));
        return true;
    }

    /**
     * validates the Input of the serial_ID
     *
     * @param enterInput
     * @param storage
     * @return
     */
    public boolean validateUpdateInput(String enterInput, Integer[][] storage) {

        Integer[] StringIntoInteger = new Integer[1];
        for (int i = 0; i < 1; i++) {
            StringIntoInteger[0] = Integer.parseInt(enterInput);
        }

        for (int i = 0; i < 1; i++) {
            if (StringIntoInteger[0] < 0 || StringIntoInteger[0] > 11) {
                System.out.println("Numbers only from 1 to 10");
                return false;
            } else {
                for (i = 0; i < storage.length; i++) {
                    if (Integer.parseInt(enterInput) == i - 1) {
                        return true;
                    }
                    if (i == 9 && !(Integer.parseInt(enterInput) == i - 1)) {
                        System.out.println("No ID found matching your input");
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Shows the details of the box
     *
     * @param serialID
     * @param storage
     */
    public boolean showBoxDetails(String serialID, Integer[][] storage) {

        for (int i = 0; i < storage.length; i++) {
            for (int j = 0; j < amountOfNumbers; j++) {
                if (Integer.parseInt(Arrays.deepToString(storage)) == i - 1) {
                    System.out.print(storage[i][j] + "\s");
                    return true;
                }
            }
        }
        return true;
    }
}
