package ua.ucu.edu.apps.second.MailCodes;

import lombok.Getter;

@Getter
public class BDayLetter implements MailCode {
    private final String mailSubject = "Happy Birthday";
    private final String mailText = "Happy Birthday, bro!";
    private final String mailHTML = "<h1>Happy Birthday, bro!</h1>";
}
