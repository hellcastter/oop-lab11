package ua.ucu.edu.apps.second;

import com.mailjet.client.ClientOptions;
import com.mailjet.client.MailjetClient;
import com.mailjet.client.MailjetRequest;
import com.mailjet.client.MailjetResponse;
import com.mailjet.client.errors.MailjetException;
import com.mailjet.client.errors.MailjetSocketTimeoutException;
import com.mailjet.client.resource.Emailv31;
import org.json.JSONArray;
import org.json.JSONObject;

public class MailSender {
    private MailjetClient client;

    private final String apiKey;
    private final String apiSecret;

    public MailSender(MailjetClient client, String apiKey, String apiSecret) {
        this.client = client;
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
    }

    public void sendMail(MailInfo mailInfo) throws MailjetSocketTimeoutException, MailjetException {
        MailjetRequest request;
        MailjetResponse response;

        client = new MailjetClient(apiKey, apiSecret, new ClientOptions("v3.1"));
        request = new MailjetRequest(Emailv31.resource)
            .property(
                Emailv31.MESSAGES,
                new JSONArray().put(
                    new JSONObject()
                        .put(
                            Emailv31.Message.FROM,
                            new JSONObject()
                                .put("Email", "muryn.pn@ucu.edu.ua")
                                .put("Name", "Victor")
                        )
                        .put(
                            Emailv31.Message.TO,
                            new JSONArray().put(
                                new JSONObject()
                                    .put("Email", mailInfo.getClient().getEmail())
                                    .put("Name", mailInfo.getClient().getName())
                            )
                        )
                        .put(Emailv31.Message.SUBJECT, mailInfo.getMailCode().getMailSubject())
                        .put(Emailv31.Message.TEXTPART, mailInfo.getMailCode().getMailText())
                        .put(Emailv31.Message.HTMLPART, mailInfo.getMailCode().getMailHTML())
                        .put(Emailv31.Message.CUSTOMID, "AppGettingStartedTest")));

        response = client.post(request);
        System.out.println(response.getStatus());
        System.out.println(response.getData());
    }
}
