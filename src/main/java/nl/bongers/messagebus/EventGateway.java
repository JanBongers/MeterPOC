package nl.bongers.messagebus;

import nl.bongers.messagebus.dto.Asset;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface EventGateway {

    @Gateway(requestChannel = Channels.ASSET_INBOEKEN_VERZOEK)
    void inboeken(final Asset dto);

}
