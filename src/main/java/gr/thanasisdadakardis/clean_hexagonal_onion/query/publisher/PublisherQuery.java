package gr.thanasisdadakardis.clean_hexagonal_onion.query.publisher;

import gr.thanasisdadakardis.clean_hexagonal_onion.domaininteraction.publisher.PublisherAppService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherQuery {

    private final PublisherAppService publisherAppService;

    public PublisherQuery(PublisherAppService publisherAppService) {
        this.publisherAppService = publisherAppService;
    }

    @GetMapping
    public List<PublisherView> getAllPublishers() {
        return publisherAppService.getAllPublishers()
                .stream()
                .map(PublisherView::new)
                .toList();
    }
}
