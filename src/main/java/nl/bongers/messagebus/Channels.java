package nl.bongers.messagebus;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Channels {

    String ASSET_INBOEKEN_VERZOEK = "asset_inboeken_verzoek";
    String ASSET_GEPLAATST_VERZOEK = "asset_geplaatst_verzoek";

    @Output(Channels.ASSET_INBOEKEN_VERZOEK)
    MessageChannel inboekenVerzoek();

    @Input(Channels.ASSET_GEPLAATST_VERZOEK)
    MessageChannel geplaatstVerzoek();
}
