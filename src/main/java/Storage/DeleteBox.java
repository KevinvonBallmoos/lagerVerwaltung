package Storage;

public class DeleteBox {

    UserEnterInput userInput = new UserEnterInput();
    ValidateId validateId = new ValidateId();
    int amountOfNumbers = 4;
    String boxId;
    boolean isDeleteConfirmed = false;

    public boolean deleteBox(Integer[][] array) {

        do {
            System.out.println("""
                    #A : Enter the values to Delete a Box
                    #B : Go back to the Main Menu""");
            String input = userInput.updateInput().toUpperCase();
            if (input.equals("B")) {
                return false;
            } else if (input.equals("A")) {
                do {
                    System.out.println("""     
                            Enter the Box ID, which you want to Delete""");
                    boxId = userInput.enterInput();

                } while (!validateId.validateIdInput(boxId, array));

                do {
                    System.out.println("Are u sure to delete this box ?");
                    System.out.println("Type \"Yes\" or \"No\"");
                    String answer = userInput.updateInput();
                    if (answer.equals("Yes")) {
                        isDeleteConfirmed = true;
                    } else if (answer.equals("No")) {
                        break;
                    } else {
                        System.out.println("Answer not valid, either \"Yes\" or \"No\" !");
                    }
                } while (!isDeleteConfirmed);
            }

        } while (showBoxDetails(boxId, array));
        return true;
    }


    /**
     * Shows the details of the box
     *
     * @param boxId
     * @param storage
     */
    public boolean showBoxDetails(String boxId, Integer[][] storage) {

        for (int i = 0; i < storage.length; i++) {
            for (int j = 0; j < amountOfNumbers; j++) {
                if (String.valueOf(storage[i][0]).equals(boxId)) {
                    System.out.print("\n" + "ID: " + (boxId) + " -> "
                            + "height: " + storage[i][1] + ", "
                            + "width: " + storage[i][2] + ", "
                            + "length: " + storage[i][3] + "\s" + "\n");
                    System.out.println("\n");
                    break;
                }

            }
        }
        deleteBoxID(boxId, storage);
        return true;
    }

    public void deleteBoxID(String boxId, Integer[][] storage) {

        for (int i = 0; i < storage.length; i++) {
            for (int j = 0; j < amountOfNumbers; j++) {
                if (String.valueOf(storage[i][0]).equals(boxId)) {
                    storage[i][0] = null;
                    storage[i][1] = null;
                    storage[i][2] = null;
                    storage[i][3] = null;
                    System.out.print("ID: " + (boxId) + " -> "
                            + "height: " + storage[i][1] + ", "
                            + "width: " + storage[i][2] + ", "
                            + "length: " + storage[i][3] + "\s");
                    System.out.println("\n");
                    break;
                }
            }
        }
    }
}
