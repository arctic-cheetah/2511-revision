package q8;

public class GitlabRunner {
    private static GitlabRunner curr = null;

    public static GitlabRunner createNewRunner() {
        if (curr == null) {
            curr = new GitlabRunner();
        }
        return curr;
    }

    // TODO : fix for q8e)
    public synchronized void run(Runnable runnable) {
        try {
            runnable.run();
        } catch (Exception e) {

        }
    }

}
