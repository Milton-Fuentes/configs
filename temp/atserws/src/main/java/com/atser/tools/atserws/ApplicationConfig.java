/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.atser.tools.atserws;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;

/**
 *
 * @author droldan
 */
@javax.ws.rs.ApplicationPath("rs")
public class ApplicationConfig extends Application {

    @Inject
    private InitializeEnv env;

    public ApplicationConfig() {
    }

    public ApplicationConfig(@Context ServletConfig servletConfig) {
        /*super();
        OpenAPI oas = new OpenAPI();
        Info info = new Info()
                .title("ATSER Restful API Swagger bootstrap code")
                .description("This is a sample server Petstore server.  You can find out more about Swagger " +
                        "at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/).  For this sample, " +
                        "you can use the api key `special-key` to test the authorization filters.")
                .termsOfService("http://swagger.io/terms/")
                .contact(new Contact()
                        .email("droldan@atser.com"))
                .license(new License()
                        .name("Apache 2.0")
                        .url("http://www.apache.org/licenses/LICENSE-2.0.html"));

        oas.info(info);
        SwaggerConfiguration oasConfig = new SwaggerConfiguration()
                .openAPI(oas)
                .prettyPrint(true)
                .resourcePackages(Stream.of("io.swagger.sample.resource").collect(Collectors.toSet()));
        try {
            new JaxrsOpenApiContextBuilder()
                    .servletConfig(servletConfig)
                    .application(this)
                    .openApiConfiguration(oasConfig)
                    .buildContext(true);
        } catch (OpenApiConfigurationException e) {
            throw new RuntimeException(e.getMessage(), e);
        }*/
    }

    /*@Override
    public Set<Class<?>> getClasses() {
        return Stream.of(OpenApiResource.class, AcceptHeaderOpenApiResource.class).collect(Collectors.toSet());
    }*/
}
