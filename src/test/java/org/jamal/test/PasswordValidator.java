package org.jamal.test;

import java.util.Objects;
public class PasswordValidator {
    public boolean validate(String password) {
        if (Objects.equals(password, "jamal")) {
            return true;
        }
        return false;
    }
}
