package geco;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LoginServiceTest {

    private static final String TOTO = "TOTO";
    private static final String TATA = "TATA";
    private  LoginService loginService;


    @Before
    public void setUp() throws Exception{
        String[] start = new String[1];
        start[0] = TATA;
        loginService = new LoginService(start);

    }
    @Test
    public void loginExists() throws Exception{
        boolean bool = loginService.loginExists("TOTO");
        Assert.assertTrue(bool);
        bool = loginService.loginExists("TATA");
        Assert.assertFalse(bool);

    }

    @Test
    public void addLogin() throws Exception{
        loginService.addLogin("CCC");
        loginService.addLogin("CCC");
        List<String> allLogins = loginService.findAllLogins();
        Assert.assertEquals(3,allLogins.size());

    }

    @Test
    public void findAllLoginsStartingWith() throws Exception{
        List<String> allLogins = loginService.findAllLoginsStartingWith("B");
        Assert.assertEquals(1,allLogins.size());
        loginService.addLogin("BBB");
        allLogins = loginService.findAllLoginsStartingWith("B");
        Assert.assertEquals(2,allLogins.size());
        allLogins = loginService.findAllLoginsStartingWith("BBB");
        Assert.assertEquals(0,allLogins.size());
    }

    @Test
    public void findAllLogins() throws Exception{
        List<String> allLogins = loginService.findAllLogins();
        Assert.assertEquals(1,allLogins.size());
        loginService.addLogin("B");
        allLogins = loginService.findAllLogins();
        Assert.assertEquals(2,allLogins.size());
    }
}