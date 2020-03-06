package atmcasestudy;

/**
 * BalanceInquiry class
 * @author ATS-2.0
 */
public class BalanceInquiry extends Transaction {
    private int account;
    private Screen screen;
    private BankDatabase database;

    public BalanceInquiry(int accountNumber, Screen atmScreen, BankDatabase atmDatabase) {
        super(accountNumber, atmScreen,atmDatabase);
        this.account = super.getAccountNumber();
        this.screen = super.getScreen();
        this.database = super.getBankDatabase();
    }

    // overridden, inherited abstract method from superclass
    // executes balance inquiry use case
    public void execute() {
        screen.displayMessageLine("Your account balance: ");
        screen.displayMessage("Available balance: ");
        screen.displayDollarAmount(bankDatabase.getAvailableBalance(this.account));
        screen.displayMessage("\nTotal balance: ");
        screen.displayDollarAmount(bankDatabase.getTotalBalance(this.account) + "\n");
    }
}
