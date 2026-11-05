package pl.askalki;

public class AskalkiConfig {
    private static boolean enabled = true;
    private static String customMessage = "Askalki Mod Aktywny!";

    public static boolean isEnabled() {
        return enabled;
    }

    public static void setEnabled(boolean enabled) {
        AskalkiConfig.enabled = enabled;
    }

    public static String getCustomMessage() {
        return customMessage;
    }

    public static void setCustomMessage(String customMessage) {
        AskalkiConfig.customMessage = customMessage;
    }
}
