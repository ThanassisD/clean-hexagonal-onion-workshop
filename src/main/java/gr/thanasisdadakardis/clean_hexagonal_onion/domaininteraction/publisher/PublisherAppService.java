package gr.thanasisdadakardis.clean_hexagonal_onion.domaininteraction.publisher;

import java.util.List;

public interface PublisherAppService {
    List<PublisherDTO> getAllPublishers();
}
