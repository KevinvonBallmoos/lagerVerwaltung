package Storage;

import java.util.Scanner;

public class UserEnterInput {

    Scanner scanner = new Scanner(System.in);

    public String enterInput() {
        return this.scanner.nextLine();
    }

    public String updateInput(){
        return this.scanner.nextLine();
    }
}
