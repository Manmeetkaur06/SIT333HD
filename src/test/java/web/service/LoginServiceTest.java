package web.service;

import org.junit.Assert;
import org.junit.Test;

public class LoginServiceTest {

    @Test
    public void validLoginShouldReturnTrue() {
        Assert.assertTrue(LoginService.login("ahsan", "ahsan_pass", "2000-01-01"));
    }

    @Test
    public void wrongUsernameShouldReturnFalse() {
        Assert.assertFalse(LoginService.login("wrong", "ahsan_pass", "2000-01-01"));
    }

    @Test
    public void wrongPasswordShouldReturnFalse() {
        Assert.assertFalse(LoginService.login("ahsan", "wrong", "2000-01-01"));
    }

    @Test
    public void nullLoginShouldReturnFalse() {
        Assert.assertFalse(LoginService.login(null, null, null));
    }
}
