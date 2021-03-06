package org.gameontext.mediator.room;

import static org.junit.Assert.fail;

import java.text.MessageFormat;
import java.util.logging.Level;

import org.gameontext.mediator.Log;
import org.gameontext.mediator.MapClient;
import org.gameontext.mediator.MediatorNexus;
import org.gameontext.mediator.PlayerClient;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;

@Ignore
public class RemoteRoomTest {

    @Mocked MediatorNexus.View nexus;
    @Mocked MapClient mapClient;
    @Mocked PlayerClient playerClient;

    String playerJwt = "testJwt";
    String userId = "dummy.DevUser";
    String userName = "DevUser";

    @Rule
    public TestName testName = new TestName();

    @Before
    public void before() {
        System.out.println("-- " + testName.getMethodName() + " --------------------------------------");


        new MockUp<Log>()
        {
            @Mock
            public void log(Level level, Object source, String msg, Object[] params) {
                System.out.println("Log: " + MessageFormat.format(msg, params));
            }

            @Mock
            public void log(Level level, Object source, String msg, Throwable thrown) {
                System.out.println("Log: " + msg + ": " + thrown.getMessage());
                thrown.printStackTrace(System.out);
            }
        };
    }

    @Test
    public void testBuildClientMediator() {
        fail("Not yet implemented");
    }

}
