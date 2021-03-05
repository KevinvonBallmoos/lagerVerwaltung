package Storage;

public class ValidateMenuInput {


    public boolean validateSelection(String userCode) {

        int[] select = new int[userCode.length()];

        if (userCode.length() != 1) {
            System.out.println("Input not valid, try again!");
            return false;
        } else {

            for (int i = 0; i < 1; i++) {
                select[i] = Integer.parseInt(userCode);
            }
            if (select[0] > 5) {
                System.out.println("Input not valid");
                return false;
            }
        }
        return true;
    }
}
