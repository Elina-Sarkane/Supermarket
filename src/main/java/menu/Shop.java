package menu;

import product.Product;
import user.User;

import java.util.Scanner;

public class Shop {
    User user = new User();
    Scanner scanner = new Scanner(System.in);

    public void setActiveUser(User activeUser) {
        this.user = activeUser;
    }
    public User getActiveUser() {
        return this.user;
    }
}
