package ua.ucu.edu.apps.second;

import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;

import java.util.List;
import java.util.ArrayList;

public class MailBox {
    private List<MailInfo> infos;

    public MailBox() {
        this.infos = new ArrayList<>();
    }

    public MailBox(List<MailInfo> infos) {
        this.infos = infos;
    }

    public void addMailInfo(MailInfo mailInfo) {
        infos.add(mailInfo);
    }

    public void sendAll(MailSender sender) throws MailjetSocketTimeoutException, MailjetException {
        for (MailInfo info : infos) {
            sender.sendMail(info);
        }
    }
}
