package accessmodifiers.assignment_problems.subclass;

public class AccessChecker {

    static String classifyAccess(String fieldModifier, String accessorContext) {

        if (accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {
            if (fieldModifier.equals("public") || fieldModifier.equals("protected")) {
                return "ALLOWED";
            }
            return "DENIED";
        }

        if (accessorContext.equals("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE")) {
            if (fieldModifier.equals("public")) {
                return "ALLOWED";
            }
            return "DENIED";
        }

        return "DENIED";
    }

    static String firstDeniedAttempt(String[][] attempts) {

        for (int i = 0; i < attempts.length; i++) {

            String modifier = attempts[i][0];
            String context = attempts[i][1];

            String result = classifyAccess(modifier, context);

            if (result.equals("DENIED")) {
                return modifier + " via " + context + " (attempt #" + (i + 1) + ")";
            }
        }

        return "None Denied";
    }
}