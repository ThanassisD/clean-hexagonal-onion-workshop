package gr.thanasisdadakardis.clean_hexagonal_onion;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import gr.thanasisdadakardis.clean_hexagonal_onion.data.book.BookJPA;
import gr.thanasisdadakardis.clean_hexagonal_onion.domain.DomainEvent;
import gr.thanasisdadakardis.clean_hexagonal_onion.domain.book.Book;
import gr.thanasisdadakardis.clean_hexagonal_onion.process.EventProcessor;
import gr.thanasisdadakardis.clean_hexagonal_onion.process.book.PublishBookDelegate;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "gr.thanasisdadakardis.clean_hexagonal_onion", importOptions = {ImportOption.DoNotIncludeTests.class})
public class CleanHexagonalOnionArchitectureTest {
    @ArchTest
    static final ArchRule layer_dependencies_are_respected =
            layeredArchitecture().consideringAllDependencies()
                .layer("acl").definedBy("gr.thanasisdadakardis.clean_hexagonal_onion.acl..")
                .layer("data").definedBy("gr.thanasisdadakardis.clean_hexagonal_onion.data..")
                .layer("command").definedBy("gr.thanasisdadakardis.clean_hexagonal_onion.command..")
                .layer("query").definedBy("gr.thanasisdadakardis.clean_hexagonal_onion.query..")
                .layer("process").definedBy("gr.thanasisdadakardis.clean_hexagonal_onion.process..")
                .layer("domain interaction").definedBy("gr.thanasisdadakardis.clean_hexagonal_onion.domaininteraction..")
                .layer("domain").definedBy("gr.thanasisdadakardis.clean_hexagonal_onion.domain..")

                .whereLayer("acl").mayNotBeAccessedByAnyLayer()
                .whereLayer("command").mayNotBeAccessedByAnyLayer()
                .whereLayer("query").mayNotBeAccessedByAnyLayer()
                .whereLayer("data").mayNotBeAccessedByAnyLayer()
                .whereLayer("process").mayNotBeAccessedByAnyLayer()
                .whereLayer("domain interaction").mayOnlyBeAccessedByLayers("acl","command", "query", "data", "process")
                .whereLayer("domain").mayOnlyBeAccessedByLayers("domain interaction")
                .ignoreDependency(EventProcessor .class, Book.RequestPublishingEvent.class)
                .ignoreDependency(PublishBookDelegate .class, Book.RequestPublishingEvent.class)
                .ignoreDependency(BookJPA .class, DomainEvent.class);
}
