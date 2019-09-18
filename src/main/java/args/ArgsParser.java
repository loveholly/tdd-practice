package args;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

public class ArgsParser {

    private Map<String, Object> argsMap;

    public ArgsParser(String[] schema) {
        argsMap = new HashMap<>();
    }

    public void parse(String[] args) {
        ListIterator<String> argsIterator = Arrays.asList(args).listIterator();
        while (argsIterator.hasNext()) {
            String flag = argsIterator.next().substring(1);
            String maybeValue = argsIterator.next();
            if (!isFlag(maybeValue)) {
                argsMap.put(flag, maybeValue);
            } else {
                argsMap.put(flag, false);
                argsIterator.previous();
            }
        }

    }

    private boolean isFlag(String argString) {
        return argString.startsWith("-");
    }

    public Object getValue(String flag) {
        return argsMap.get(flag);
    }
}
