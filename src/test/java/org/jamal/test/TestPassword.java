package org.jamal.test;

import org.junit.Assert;
import org.junit.Test;
public class TestPassword {

    @Test
    public void testPassword() {
        PasswordValidator pv = new PasswordValidator();
        Assert.assertTrue(pv.validate("jamal"));
    }
}
