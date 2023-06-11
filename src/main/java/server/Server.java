package server;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService
public class Server {
    private static final int port = 8080;
    private static final String url = "http://localhost:%d/AutomaticTest";


    public static void main(String[] args) {
        AutomaticTest server = new AutomaticTest();
        Endpoint.publish(String.format(url,port),server);
    }
}
