package core;

import java.util.List;

public interface Assignment {
    void run(String... args);
    Group getGroup();
    String getName();
    String getDetails();
    String getUsage();
    List<Argument> getArguments();
}
