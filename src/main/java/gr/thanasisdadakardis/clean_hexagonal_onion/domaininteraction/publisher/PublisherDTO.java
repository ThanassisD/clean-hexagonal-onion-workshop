package gr.thanasisdadakardis.clean_hexagonal_onion.domaininteraction.publisher;

import gr.thanasisdadakardis.clean_hexagonal_onion.domain.publisher.Publisher;

import java.util.UUID;

public record PublisherDTO(UUID id, String name) {
    public PublisherDTO(Publisher publisher) {
        this(publisher.id(), publisher.name());
    }
}
