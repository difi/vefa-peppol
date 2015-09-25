package no.difi.vefa.peppol.lookup;

import no.difi.vefa.peppol.lookup.api.LookupException;
import no.difi.vefa.peppol.lookup.model.DocumentIdentifier;
import no.difi.vefa.peppol.lookup.model.ParticipantIdentifier;
import static org.testng.Assert.*;

import no.difi.vefa.peppol.lookup.model.ServiceMetadata;
import org.testng.annotations.Test;

import java.util.List;

public class LookupClientTest {

    @Test
    public void simple() throws LookupException{
        LookupClient client = LookupClientBuilder.forProduction().build();
        List<DocumentIdentifier> documentIdentifiers = client.getDocumentIdentifiers(new ParticipantIdentifier("9908:991825827"));

        assertNotNull(documentIdentifiers);
        assertNotEquals(documentIdentifiers.size(), 0);

        ServiceMetadata serviceMetadata = client.getServiceMetadata(new ParticipantIdentifier("9908:991825827"), new DocumentIdentifier("urn:oasis:names:specification:ubl:schema:xsd:Invoice-2::Invoice##urn:www.cenbii.eu:transaction:biitrns010:ver2.0:extended:urn:www.peppol.eu:bis:peppol4a:ver2.0::2.1"));
        assertNotNull(serviceMetadata);
    }

}