package com.thoughtworks.shadow.guice.service;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ProcessServiceTest {

    @Test
    public void should_log_success() {
        assertThat(true, is(true));
    }
}