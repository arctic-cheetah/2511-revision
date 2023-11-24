package q8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class GitlabAuthorisationException extends Exception {
    Set<User> t = new TreeSet<>();
    Collection<User> c = new ArrayList<>();

    public GitlabAuthorisationException(String msg) {
        super(msg);
    }
}
