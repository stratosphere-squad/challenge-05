package org.stratosphere.squad.planets;

import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
@OpenAPIDefinition(
        info = @Info(title = "Planet API",
                description = "This API allows CRUD operations on an internal Planet registry",
                version = "1.0",
                contact = @Contact(name = "Quarkus", url = "https://github.com/stratosphere-squad")),

        externalDocs = @ExternalDocumentation(url = "https://github.com/stratosphere-squad", description = "All the RedHat Challenges"),
        tags = {
                @Tag(name = "api", description = "Public that can be used by anybody"),
                @Tag(name = "planets", description = "Anybody interested in documentation")
        }
)
public class PlanetApplication extends Application {
}
