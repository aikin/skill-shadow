package com.thoughtworks.shadow.jersey.HelloWorld;


import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.glassfish.jersey.test.util.runner.ConcurrentRunner;
import org.glassfish.jersey.test.util.runner.RunSeparately;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


/**
 * Created by aikin on 7/17/15.
 */

@RunWith(ConcurrentRunner.class)
public class AppTest extends JerseyTest {

    @Override
    protected ResourceConfig configure() {

        enable(TestProperties.LOG_TRAFFIC);
        return new ResourceConfig(HelloWorldResource.class);
    }

    @Test
    @Ignore("not compatible with test framework (doesn't use client())")
    public void should_return_status_200() throws Exception {
        URL getUrl = UriBuilder.fromUri(getBaseUri()).path(App.ROOT_PATH).build().toURL();
        HttpURLConnection connection = (HttpURLConnection) getUrl.openConnection();
        try {
            connection.setDoOutput(true);
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "text/plain");
            assertThat(connection.getResponseCode(), is(HttpURLConnection.HTTP_OK));
        } finally {
            connection.disconnect();
        }
    }

    @Test
    public void should_connection_ok() {
        Response response = target().path(App.ROOT_PATH).request("text/plain").get();
        assertThat(response.getStatus(), is(200));
    }

    @Test
    public void should_client_string_response() {
        String respondContent = target().path(App.ROOT_PATH).request().get(String.class);
        assertThat(respondContent, is(HelloWorldResource.CLICHED_MESSAGE));
    }

    @Test
    @RunSeparately
    public void testLoggingFilterClientClass() {
        Client client = client();
        client.register(CustomLoggingFilter.class).property("foo", "bar");
        CustomLoggingFilter.preFilterCalled = CustomLoggingFilter.postFilterCalled = 0;
        String respondContent = target().path(App.ROOT_PATH).request().get(String.class);
        assertThat(respondContent, is(HelloWorldResource.CLICHED_MESSAGE));
        assertThat(CustomLoggingFilter.preFilterCalled, is(1));
        assertThat(CustomLoggingFilter.postFilterCalled, is(1));
    }
}