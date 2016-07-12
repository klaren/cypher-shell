package org.neo4j.shell.commands;


import org.junit.Before;
import org.junit.Test;
import org.neo4j.shell.Command;
import org.neo4j.shell.CommandException;
import org.neo4j.shell.TestShell;

import java.util.Arrays;

import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.fail;

public class HelpTest {

    private TestShell shell;
    private Command cmd;

    @Before
    public void setup() {
        this.shell = new TestShell();
        this.cmd = new Help(shell);
    }

    @Test
    public void shouldNotAcceptTooManyArgs() {
        try {
            cmd.execute(Arrays.asList("bob", "alice"));
            fail("Should not accept too many args");
        } catch (CommandException e) {
            assertTrue("Unexepcted error", e.getMessage().startsWith("Too many arguments"));
        }
    }
}