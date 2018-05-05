package controllertest;

import controller.Json;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Created by zsolt on 5/25/17.
 *//*
public class JsonTest {
    @Test
    public void authenticate() throws Exception {

    }

}
*/

public class JsonTest {

    private Json object;

    public JsonTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    	//Logger slf4jLogger = LoggerFactory.getLogger(JsonTest.class);
    }

    @Before
    public void setUpJson() {
        String json = "  {\n" +
                "    \"users\": [\n" +
                "        {\"username\": \"Guest\", \"password\":\"835d6dc88b708bc646d6db82c853ef4182fabbd4a8de59c213f2b5ab3ae7d9be\"},\n" +
                "        {\"username\": \"SavetheWorld\", \"password\":\"185f8db32271fe25f561a6fc938b2e264306ec304eda518007d1764826381969\"},\n" +
                "    ]\n" +
                "}\n";
        this.object = new Json(new JsonDataSourceMock(json));

        //Json h = new Json();
    }

    @Test
    public void testSuccessfulLogin() {
        Assert.assertEquals(true, this.object.authenticate("Guest", "ADMIN"));
    }

}