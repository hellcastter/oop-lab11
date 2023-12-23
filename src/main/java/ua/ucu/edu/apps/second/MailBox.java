package ua.ucu.edu.apps.second;

import java.util.List;
import java.util.ArrayList;

public class MailBox {
    private List<MailInfo> infos;

    public MailBox() {
        this.infos = new ArrayList<>();
    }

    public MailBox (List<MailInfo> infos) {
        this.infos = infos;
    }

    public void addMailInfo(MailInfo mailInfo) {
        infos.add(mailInfo);
    }

    public void sendAll(MailSender sender) {
        for (MailInfo info : infos) {
            try {
                sender.sendMail(info);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
