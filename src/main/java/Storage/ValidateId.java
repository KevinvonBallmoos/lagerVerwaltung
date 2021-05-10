package Storage;

public class ValidateId {

    /**
     * validates the Input of the serial_ID
     *
     * @param enterInput
     * @param storage
     * @return
     */
    public boolean validateIdInput(String enterInput, Integer[][] storage) {

        Integer[] StringIntoInteger = new Integer[1];
        for (int i = 0; i < 1; i++) {
            StringIntoInteger[0] = Integer.parseInt(enterInput);
        }

        for (int i = 0; i < 1; i++) {
            if (StringIntoInteger[0] < 0 || StringIntoInteger[0] > 11) {
                System.out.println("Your Box ID must be between 1  and 10");
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

    public boolean validateNewId(String[] enterInput) {

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
}
