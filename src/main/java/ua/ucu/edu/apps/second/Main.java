package ua.ucu.edu.apps.second;

import com.mailjet.client.MailjetClient;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import ua.ucu.edu.apps.second.codes.BDayLetter;

public class Main {
    public static void main(String[] args) throws MailjetSocketTimeoutException, MailjetException {
        Client client = new Client("Victor", "muryn.pn@ucu.edu.ua", 19, Gender.MALE);
        MailInfo mailInfo = new MailInfo(client, new BDayLetter());
        MailBox mailBox = new MailBox();

        String apiKey = System.getenv("API_KEY");
        String apiSecret = System.getenv("API_SECRET");

        MailjetClient mailjetClient;
        mailjetClient = new MailjetClient(apiKey, apiSecret);

        MailSender mailSender = new MailSender(mailjetClient, apiKey, apiSecret);

        mailBox.addMailInfo(mailInfo);
        mailBox.sendAll(mailSender);
    }
}