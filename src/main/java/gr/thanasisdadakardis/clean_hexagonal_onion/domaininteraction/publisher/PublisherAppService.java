package gr.thanasisdadakardis.clean_hexagonal_onion.domaininteraction.publisher;

import java.util.List;
import java.util.UUID;

public interface PublisherAppService {
    List<PublisherDTO> getAllPublishers();

    PublisherDTO getPublisherById(String publisherId);

    String requestPublishing(UUID publisherId, String fullName, String title);
}
