package ua.ucu.edu.apps.second;

import lombok.Getter;
import ua.ucu.edu.apps.second.codes.MailCode;

@Getter
public class MailInfo {
    private Client client;
    private MailCode mailCode;

    public MailInfo(Client client, MailCode mailCode) {
        this.client = client;
        this.mailCode = mailCode;
    }
}
