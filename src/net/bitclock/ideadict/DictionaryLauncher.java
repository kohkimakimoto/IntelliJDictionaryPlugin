package net.bitclock.ideadict;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.notification.Notifications;

public class DictionaryLauncher {
    public void lookup(String word) {
        GeneralCommandLine commandLine = new GeneralCommandLine("open");
        commandLine.addParameter("dict://" + word);

        try {
            Process process = commandLine.createProcess();
        } catch (ExecutionException e) {
            Notifications.Bus.notify(new Notification("Dictionary Plugin Error", "Dictionary Plugin Error", e.getMessage(), NotificationType.ERROR));
        }
    }
}
