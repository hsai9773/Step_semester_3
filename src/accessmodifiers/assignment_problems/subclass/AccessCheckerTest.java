package accessmodifiers.assignment_problems.subclass;

public class AccessCheckerTest {

    public static void main(String[] args) {

        String[][] attempts = {
            {"public", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };

        System.out.println(AccessChecker.firstDeniedAttempt(attempts));
    }
}