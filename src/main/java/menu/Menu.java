package menu;

import product.Product;
import product.ProductController;
import user.User;
import user.UserType;

import java.util.Scanner;

public class Menu {
    Shop shop = new Shop();
    Scanner scanner = new Scanner(System.in);
    OwnerMenu ownerMenu = new OwnerMenu();
    UserMenu userMenu = new UserMenu();
    Product product = new Product();
    ProductController productController = new ProductController();
    public void start(){
        System.out.println("WELCOME TO THE SUPERMARKET!\n");
        System.out.println("Please enter your user type: \n1. Buyer \n2. Owner \n3. Exit");
        String userChoice = scanner.nextLine();
        User activeUser = createUser(userChoice);

        if(activeUser == null){
            handleExit();
        }
        shop.setActiveUser(activeUser);
        showUserMenu(activeUser.getUserType());
    }
    private void handleExit() {
        System.out.println("Enter 1 to exit or 2 to show main menu");
        if (scanner.nextLine().equals("1")){
            System.exit(0);
        }
        start();
    }
    private User createUser(String userChoice) {
        switch (Integer.parseInt(userChoice)) {
            case 1:
                System.out.println("Enter your budget: ");
                double userBalance = Double.parseDouble(scanner.nextLine());
                return new User(UserType.BUYER, userBalance);
            case 2:
                return new User(UserType.OWNER);
            default:
                break;
        }

        return null;
    }
    private void showUserMenu(UserType userType) {
        switch (userType) {
            case OWNER:
                System.out.println(getOwnerMenu());
                break;
            case BUYER:
                System.out.println(getBuyerMenu());
                break;
            default:
                start();
        }
        String userChoice = scanner.nextLine();
        handleMenuChoice(userType, userChoice);
    }
    private void handleMenuChoice(UserType userType, String userChoice) {
        switch (userType) {
            case OWNER:
                handleOwnerChoice(userChoice);
                break;
            case BUYER:
                handleBuyerChoice(userChoice);
                break;
            default:
                start();
        }
    }
    private void handleBuyerChoice(String userChoice) {
        switch (userChoice){
            case "1":
                userMenu.buyProducts();
                break;
            case "2":
                userMenu.viewProducts();
                break;
            case "3":
                handleExit();
                break;
            default:
                break;
        }
        showUserMenu(shop.getActiveUser().getUserType());
    }
    private void handleOwnerChoice(String userChoice) {
        switch (userChoice){
            case "1":
                ownerMenu.addProduct();
                break;
            case "2":
                ownerMenu.updateProducts();
                break;
            case "3":
                ownerMenu.viewAllProducts();
                break;
            case "4":
                System.out.println("Enter product Id: ");
                ownerMenu.removeProduct(Integer.parseInt(scanner.nextLine()));
                break;
            case "5":
                ownerMenu.viewSalesHistory();
                break;
            case "6":
                handleExit();
                break;
            default:
                break;
        }
        showUserMenu(shop.getActiveUser().getUserType());
    }
    private String getBuyerMenu() {
        return "Choose option: \n1. Buy products \n2. View products \n3. Exit";
    }
    private String getOwnerMenu() {
        return "Choose option: \n1. Add products \n2. Update products \n3. View all products \n4. Remove products \n5. Sales history \n6. Exit";
    }
}
