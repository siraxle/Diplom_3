package Helpers;

import io.qameta.allure.Step;

public class UserFactory {
    private final UserHelper userHelper;

    public UserFactory(UserHelper userHelper) {
        this.userHelper = userHelper;
    }

    @Step("User Generation")
    public User createUser() {
        String email = userHelper.generateUniqueEmail();
        String password = userHelper.generatePassword();
        String name = userHelper.generateName();
        return new User(email, password, name);
    }
}
