package Storage;

import java.util.Scanner;

public class UserInput {

    Scanner scanner = new Scanner(System.in);

    public String userCodeInput() {
        return this.scanner.nextLine();
    }



}
