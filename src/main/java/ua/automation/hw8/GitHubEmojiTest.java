package ua.automation.hw8;

import org.apache.http.impl.client.CloseableHttpClient;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.http.HttpEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;

import java.io.IOException;

public class GitHubEmojiTest {
    @Test
    public void githubEmojiContainsArticulatedLorryTest() throws IOException {
        String url = "https://api.github.com/emojis";

        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet getAllEmojis = new HttpGet(url);
        CloseableHttpResponse response = httpClient.execute(getAllEmojis);

        System.out.println("Status code:" + response.getStatusLine().getStatusCode());
        System.out.println("Status phrase:" + response.getStatusLine().getReasonPhrase());
        HttpEntity entity = response.getEntity();

        String json = EntityUtils.toString(entity);
        JSONObject jsonObject = new JSONObject(json);
        Assert.assertTrue(jsonObject.has("articulated_lorry"), "Key 'articulated_lorry' is missing in the response JSON");

        System.out.println(jsonObject.get("articulated_lorry"));

    }
}