package Sygma.Model;

public class UserSession {
    private static ModelUser currentUser;

    public static void setCurrentUser(ModelUser user) {
        currentUser = user;
    }

    public static ModelUser getCurrentUser() {
        return currentUser;
    }

    public static String getCurrentUserId() {
        return currentUser != null ? currentUser.getUserId() : null;
    }
}
