package Storage;

public class ShowBox {

    UserEnterInput userInput = new UserEnterInput();
    ValidateId validateId = new ValidateId();
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
                            Enter the Box ID from your Box""");
                    boxId = userInput.enterInput();

                } while (!validateId.validateIdInput(boxId, array));
            }
        } while (showBoxDetails(boxId, array));
        return true;
    }

    /**
     * Shows the details of the box
     *
     * @param boxID
     * @param storage
     */
    public boolean showBoxDetails(String boxID, Integer[][] storage) {
        int i;
        for (i = 0; i < storage.length; i++) {
            for (int j = 0; j < amountOfNumbers; j++) {
                if (String.valueOf(storage[i][0]).equals(boxID)) {
                    System.out.print("\n" + "ID: " + (boxID) + " -> "
                            + "height: " + storage[i][1] + ", "
                            + "width: " + storage[i][2] + ", "
                            + "length: " + storage[i][3] + "\s" + "\n");
                    System.out.println("\n");
                    break;
                }

            }
        }
        return true;
    }
}
