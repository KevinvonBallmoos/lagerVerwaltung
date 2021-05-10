package Storage;


public class Menu {

    EnterNewBox enter = new EnterNewBox();
    UpdateBox update = new UpdateBox();
    DeleteBox delete = new DeleteBox();
    ShowBox show = new ShowBox();
    Storage storage = new Storage();
    UserInput userInput = new UserInput();
    ValidateMenuInput validateMenuInput = new ValidateMenuInput();

    private final Integer[][] stock = storage.getStorage();


    public void selectAction(int[] userCode) throws InterruptedException {

        switch (userCode[0]) {
            case 1 -> {
                if (!enter.enterNewBox(stock)) {
                    PrintMenu();
                }
            }
            case 2 -> {
                if (!update.updateBox(stock)) {
                    PrintMenu();
                }
            }
            case 3 -> {
                if (!show.showBox(stock)) {
                    PrintMenu();
                }
            }
            case 4 -> {
                if (!delete.deleteBox(stock)) {
                    PrintMenu();
                }
            }
            case 5 -> {
                System.out.println("Thanks for using our program!");
                Thread.sleep(500);
                System.out.println("Have a wonderful Day!");
            }
        }
    }

    public void PrintMenu() throws InterruptedException {


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
            selectAction(select);
        }
    }
}
