package ua.ucu.edu.apps.second;

import com.mailjet.client.MailjetClient;
import ua.ucu.edu.apps.second.MailCodes.BDayLetter;

public class Main {
    public static void main(String[] args) {
        Client client = new Client("Victor", "muryn.pn@ucu.edu.ua", 19, Gender.MALE);
        MailInfo mailInfo = new MailInfo(client, new BDayLetter());
        MailBox mailBox = new MailBox();

        String API_KEY = System.getenv("API_KEY");
        String API_SECRET = System.getenv("API_SECRET");

        MailjetClient mailjetClient;
        mailjetClient = new MailjetClient(API_KEY, API_SECRET);

        MailSender mailSender = new MailSender(mailjetClient, API_KEY, API_SECRET);

        mailBox.addMailInfo(mailInfo);
        mailBox.sendAll(mailSender);
    }
}