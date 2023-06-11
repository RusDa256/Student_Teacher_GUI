package client;

import frame.ChooseRoleFrame;
import server.IAutomaticTest;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import java.util.Scanner;

public class Client {
    private static final int port = 8080;
    private static final String url = "http://localhost:%d/AutomaticTest?wsdl";

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Service service = Service.create(new URL(String.format(url, port)), new QName("http://server/","AutomaticTestService"));
        IAutomaticTest proxy = service.getPort(new QName("http://server/", "AutomaticTestPort"),IAutomaticTest.class);

        ChooseRoleFrame frame = new ChooseRoleFrame(proxy);
    }
}
