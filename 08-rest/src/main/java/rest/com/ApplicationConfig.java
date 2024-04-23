package rest.com;

import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig {
    public ApplicationConfig() {
        // Register resources and features
        packages("rest.com");
        register(BookResource.class);

        // Initialize any data or perform startup tasks
        initData();
    }

    private void initData() {
        // Here you can populate the BookResource with initial data
        BookResource.initBooks();
    }
}
