package pl.camp.it.library.services.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.camp.it.library.AppConfiguration;
import pl.camp.it.library.model.User;
import pl.camp.it.library.services.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfiguration.class})
public class UserServiceImplTest {

    @Autowired
    IUserService userService;

    @Test
    public void wrongPasswordAuthenticationTest() {
        User user = new User();
        user.setLogin("mateusz");
        user.setPassword("asydgfkyasgd");

        boolean result = userService.authenticate(user);

        Assert.assertFalse(result);
    }
}
