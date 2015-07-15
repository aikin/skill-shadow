package com.thoughtworks.shadow.guice.bindings;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ProcessTest {

    @Test
    public void should_log_success() {
        assertThat(true, is(true));
    }
}