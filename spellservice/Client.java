package net.yandex.speller.services.spellservice;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.ws.Service;
import java.io.IOException;
import java.net.URL;

public class Client {
    private static String ADDRESS = "http://speller.yandex.net/services/spellservice?WSDL";

    public static void main(String[] args) throws SOAPException, IOException {
        Client client = new Client();
        client.init();
    }

    private Client() {
        System.out.println("Starting client...");
    }

    private void init() throws SOAPException, IOException {
        URL url = new URL(ADDRESS);
        QName qName = new QName("http://speller.yandex.net/services/spellservice", "SpellService");

        Service service = Service.create(url, qName);

        SpellServiceSoap hello = service.getPort(SpellServiceSoap.class);

        CheckTextRequest checkTextRequest = new CheckTextRequest();
        checkTextRequest.setText("Caat");
        checkTextRequest.setLang("en");
        checkTextRequest.setFormat("plain");

        CheckTextsResponse checkTextsResponse = new CheckTextsResponse();
        hello.checkText(checkTextRequest);
        System.out.println(hello.checkText(checkTextRequest));

    }
}
