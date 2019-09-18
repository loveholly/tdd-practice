package args;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArgsParserTest {

    @Test
    public void should_parse_args() {
        String[] schema = new String[0];
        String[] args = new String[]{ "-l", "-p", "8080", "-d", "/usr/logs" };
        ArgsParser argsParser = new ArgsParser(schema);
        argsParser.parse(args);

        assertFalse((boolean) argsParser.getValue("l"));
        assertSame(argsParser.getValue("p"), "8080");
        assertSame(argsParser.getValue("d"), "/usr/logs");
    }
}
