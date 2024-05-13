package gr.thanasisdadakardis.clean_hexagonal_onion.query.publisher;

import gr.thanasisdadakardis.clean_hexagonal_onion.domaininteraction.publisher.PublisherDTO;

import java.util.UUID;

public record PublisherView(UUID id, String name){
    public PublisherView(PublisherDTO publisherDTO) {
        this(publisherDTO.id(), publisherDTO.name());
    }
}
