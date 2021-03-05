package Storage;

/**
 * class EnterNewBox
 */
public class EnterNewBox {

    UserEnterInput userInput = new UserEnterInput();
    int maxBoxes = 10;
    int amountOfNumbers = 4;

    public boolean enterNewBox(Integer[][] storage) {
        final String[] boxDetails = new String[amountOfNumbers];

        do {
            System.out.println("""
                    #A : Enter the values for a new Box
                    #B : Go back to the Main Menu""");
            String input = userInput.enterInput().toUpperCase();
            if (input.equals("B")) {
                return false;
            } else if (input.equals("A")) {

                do {
                    System.out.println("""     
                            Enter following numbers :
                            Serial ID : between 1 and 10
                            height :
                            width :
                            length""");

                    for (int i = 0; i < 4; i++) {
                        if (i == 0) {
                            do {
                                boxDetails[i] = userInput.enterInput();
                            } while (!verificationInput(boxDetails[0], storage));
                            continue;
                        }
                        boxDetails[i] = userInput.enterInput();
                    }

                } while (!validateEnterInput(boxDetails));
            } else {
                System.out.println("Input not valid, either A or B");

            }
        } while (addBoxToStorage(boxDetails, storage));
        return true;
    }

    public boolean verificationInput(String input, Integer[][] storage) {

        for (int i = 0; i < maxBoxes; i++) {
            for (int k = 0; k < amountOfNumbers; k++) {
                if (storage[i][0] == null) {
                    break;
                } else if (storage[i][0].toString().equals(String.valueOf(input))) {
                    System.out.println("Serial ID is already given, please enter a new one");
                    return false;
                }
            }

        }
        return true;
    }

    public boolean validateEnterInput(String[] enterInput) {

        Integer[] StringIntoInteger = new Integer[enterInput.length];
        for (int i = 0; i < 4; i++) {
            StringIntoInteger[i] = Integer.parseInt(enterInput[i]);
        }

        for (int i = 0; i < enterInput.length; i++) {

            if (StringIntoInteger[0] < 0 || StringIntoInteger[0] > 11) {
                System.out.println("ID only from 1 to 10 allowed");
                return false;
            }
        }

        return true;
    }

    public boolean addBoxToStorage(String[] box, Integer[][] storage) {

        Integer[] StringIntoInteger = new Integer[box.length];
        for (int i = 0; i < 4; i++) {
            StringIntoInteger[i] = Integer.parseInt(box[i]);
        }

        int boxNumber = StringIntoInteger[0];
        int width = StringIntoInteger[1];
        int height = StringIntoInteger[2];
        int length = StringIntoInteger[3];
        int count = 0;

        for (int i = 0; i < storage.length; i++) {
            for (int j = 0; j < amountOfNumbers; j++) {
                if (i == boxNumber - 1) {
                    storage[i][0] = boxNumber;
                    storage[i][1] = width;
                    storage[i][2] = height;
                    storage[i][3] = length;
                }
            }
        }

        System.out.println("Storage: ");

        for (int i = 0; i < storage.length; i++) {
            for (int j = 0; j < amountOfNumbers; j++) {
                if (storage[i][j] != null) {
                    if (storage[i][j].equals(storage[i][0])) {
                        System.out.print("\n" + "ID: " + (i + 1) + " -> "
                                + "height: " + storage[i][1] + ", "
                                + "width: " + storage[i][2] + ", "
                                + "length: " + storage[i][3] + "\s");
                    } else {
                        System.out.print(" " + "\s");
                    }
                }
            }
        }

        for (Integer[] integers : storage) {
            for (int j = 0; j < amountOfNumbers; j++) {
                if (integers[j] != null) {
                    count++;
                }
            }
        }
        System.out.println("\n");
        System.out.print("Count of Boxes in the Storage : " + count / 4);
        System.out.println("\n");
        return true;
    }
}
