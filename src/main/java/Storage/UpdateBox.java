package Storage;

public class UpdateBox {

    UserEnterInput userInput = new UserEnterInput();
    int amountOfNumbers = 4;
    String boxId;

    /**
     * Update a box or go back to the menu
     *
     * @param array
     * @return
     */
    public boolean updateBox(Integer[][] array) {

        do {
            System.out.println("""
                    #A : Update your Box
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
                showBoxDetails(boxId, array);
            }
        } while (showUpdatedStorage(array));
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
    public void showBoxDetails(String serialID, Integer[][] storage) {
        int i;
        for (i = 0; i < storage.length; i++) {
            for (int j = 0; j < amountOfNumbers; j++) {
                if (String.valueOf(storage[i][0]).equals(serialID)) {
                    showStorage(storage);
                    break;
                }
            }
        }
        updateValuesInBox(storage, serialID);
    }

    /**
     * Which value of the box should be updated
     *
     * @param storage
     * @param serialID
     */
    public void updateValuesInBox(Integer[][] storage, String serialID) {

        boolean isInputValid;


        do {
            System.out.println("\n");
            System.out.println("""
                    Write to Update height, length or width
                    Write exit, If you are done updating your box, or want to update an other box
                    """);
            do {
                String boxDetails = userInput.enterInput();
                switch (boxDetails) {
                    case "height" -> {
                        isInputValid = true;
                        for (int i = 0; i < storage.length; i++) {
                            for (int j = 0; j < amountOfNumbers; j++) {
                                if (Integer.parseInt(serialID) == i - 1) {
                                    System.out.println("Old value: " + storage[Integer.parseInt(serialID) - 1][1]);
                                    System.out.println("Type in a new value");
                                    int newValue = Integer.parseInt(userInput.updateInput());
                                    System.out.println("New value: " + newValue);
                                    storage[Integer.parseInt(serialID) - 1][1] = newValue;
                                    showStorage(storage);
                                    break;
                                }
                            }
                        }
                    }
                    case "width" -> {
                        isInputValid = true;
                        for (int i = 0; i < storage.length; i++) {
                            for (int j = 0; j < amountOfNumbers; j++) {
                                if (Integer.parseInt(serialID) == i - 1) {
                                    System.out.println("Old value: " + storage[Integer.parseInt(serialID) - 1][2]);
                                    System.out.println("Type in a new value");
                                    int newValue = Integer.parseInt(userInput.updateInput());
                                    System.out.println("New value: " + newValue);
                                    storage[Integer.parseInt(serialID) - 1][2] = newValue;
                                    showStorage(storage);
                                    break;
                                }
                            }
                        }
                    }
                    case "length" -> {
                        isInputValid = true;
                        for (int i = 0; i < storage.length; i++) {
                            for (int j = 0; j < amountOfNumbers; j++) {
                                if (Integer.parseInt(serialID) == i - 1) {
                                    System.out.println("Old value: " + storage[Integer.parseInt(serialID) - 1][3]);
                                    System.out.println("Type in a new value");
                                    int newValue = Integer.parseInt(userInput.updateInput());
                                    System.out.println("New value: " + newValue);
                                    storage[Integer.parseInt(serialID) - 1][3] = newValue;
                                    showStorage(storage);
                                    break;
                                }
                            }
                        }
                    }
                    case "exit" -> {
                        return;
                    }
                    default -> {
                        isInputValid = false;
                        System.out.println("Input not valid" + "\n" + "Please type height, width or length");
                    }
                }
            } while (!isInputValid);
        } while (true);
    }

    public boolean showUpdatedStorage(Integer[][] storage) {

        int count = 0;

        for (int i = 0; i < storage.length; i++) {
            for (int j = 0; j < amountOfNumbers; j++) {
                if (storage[i][j] != null) {
                    if (storage[i][j].equals(storage[i][0])) {
                        System.out.print("\n" + "ID: " + (i + 1) + " -> " + storage[i][j] + "\s");
                    } else {
                        System.out.print(" " + storage[i][j] + "\s");
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
        System.out.println("Count of Boxes in the Storage : " + count / 4 + "\n");
        return true;
    }

    public void showStorage(Integer[][] storage) {
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
