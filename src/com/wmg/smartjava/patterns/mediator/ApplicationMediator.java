package com.wmg.smartjava.patterns.mediator;

public class ApplicationMediator {

    private WelcomePage welcomePage;
    private ListPage listPage;
    private CheckoutPage checkoutPage;
    private ConfirmPage confirmPage;

    public ApplicationMediator() {
        this.welcomePage = new WelcomePage(this);
        this.listPage = new ListPage(this);
        this.checkoutPage = new CheckoutPage(this);
        this.confirmPage = new ConfirmPage(this);
    }

    public void handle(String action) {
        switch (action) {
            case "shop.list":
                listPage.navigate();
                break;
            case "shop.checkout":
                checkoutPage.navigate();
                break;
            case "shop.confirm":
                confirmPage.navigate();
                break;
            case "shop.exit":
                System.exit(0);
        }
    }

    public WelcomePage getWelcomePage() {
        return welcomePage;
    }
}
