package Storage;

public class UpdateBox {

    UserEnterInput userInput = new UserEnterInput();
    ValidateId validateId = new ValidateId();
    Storage storageOut = new Storage();
    int amountOfNumbers = 4;
    String boxId;

    /**
     * Update a box or go back to the menu
     *
     * @param array
     * @return true
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
                            Enter the Box ID from your Box""");
                    boxId = userInput.enterInput();

                } while (!validateId.validateIdInput(boxId, array));
                showBoxDetails(boxId, array);
            }
        } while (showUpdatedStorage(array));
        return true;
    }

    /**
     * Shows the details of the box
     *
     * @param boxID gets the id from the box to update
     * @param storage storage
     */
    public void showBoxDetails(String boxID, Integer[][] storage) {
        int i;
        for (i = 0; i < storage.length; i++) {
            for (int j = 0; j < amountOfNumbers; j++) {
                if (String.valueOf(storage[i][0]).equals(boxID)) {
                    System.out.print("\n" + "ID: " + (boxID) + " -> "
                            + "height: " + storage[i][1] + ", "
                            + "width: " + storage[i][2] + ", "
                            + "length: " + storage[i][3] + "\s");
                    break;
                }

            }
        }
        updateValuesInBox(storage, boxID);
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
                                    storageOut.StorageOutput(storage);
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
                                    storageOut.StorageOutput(storage);
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
                                    storageOut.StorageOutput(storage);
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
        System.out.println("\n");
        System.out.println("Count of Boxes in the Storage : " + count / 4 + "\n");
        return true;
    }

}
