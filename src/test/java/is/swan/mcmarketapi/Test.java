package is.swan.mcmarketapi;

import is.swan.mcmarketapi.classes.Member;
import is.swan.mcmarketapi.request.Client;
import is.swan.mcmarketapi.request.Error;
import is.swan.mcmarketapi.request.Response;
import is.swan.mcmarketapi.request.requests.conversation.StartConversationRequest;
import is.swan.mcmarketapi.request.requests.member.RetrieveYourselfRequest;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        String token = System.getenv("MCMARKET_API_PRIVATE_TOKEN");
        Client client = new Client(new Token(token, Token.Type.PRIVATE));
        Response<Member> response = client.sendOrWait(new RetrieveYourselfRequest());

        if (response.getError() == null) {
            Member member = response.getValue();

            System.out.println(member.getUsername());
        } else {
            Error error = response.getError();

            System.out.println(error.getCode() + ": " + error.getMessage());
        }
    }
}
