package Storage;


public class Console {

    UserInput userInput = new UserInput();
    ValidateMenuInput validateMenuInput = new ValidateMenuInput();
    Menu menu = new Menu();


    public void ConsoleOutput() throws InterruptedException {
        Thread.sleep(500);
        System.out.println("""
                MENU      
                #1 : Enter a new Box
                #2 : Update a Box
                #3 : Show details of a Box
                #4 : Delete a Box
                #5 : End Program""");
        String userCode = "0";
        while (!userCode.equals("5")) {
            do {
                userCode = userInput.userCodeInput();
            } while (!validateMenuInput.validateSelection(userCode));

            int[] select = new int[userCode.length()];
            for (int i = 0; i < 1; i++) {
                select[i] = Integer.parseInt(userCode);
            }
            menu.selectAction(select);
        }
    }
}
