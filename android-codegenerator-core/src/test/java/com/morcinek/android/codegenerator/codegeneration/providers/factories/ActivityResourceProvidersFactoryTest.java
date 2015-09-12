package com.morcinek.android.codegenerator.codegeneration.providers.factories;

import com.morcinek.android.codegenerator.codegeneration.providers.ResourceProvider;
import com.morcinek.android.codegenerator.codegeneration.providers.ResourceProvidersFactory;
import com.morcinek.android.codegenerator.codegeneration.providers.resources.ButtonProvider;
import com.morcinek.android.codegenerator.extractor.model.Resource;
import com.morcinek.android.codegenerator.extractor.model.ResourceId;
import com.morcinek.android.codegenerator.extractor.model.ResourceType;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class ActivityResourceProvidersFactoryTest {

    private ResourceProvidersFactory resourceProvidersFactory;

    @Before
    public void setUp() throws Exception {
        resourceProvidersFactory = new ActivityResourceProvidersFactory();
    }

    @Test
    public void provideButtonProviderTest() throws Exception {
        // given
        Resource resource = new Resource(new ResourceId("button"), new ResourceType("Button"));

        // when
        ResourceProvider resourceProvider = resourceProvidersFactory.createResourceProvider(resource);

        // then
        Assertions.assertThat(resourceProvider).isNotNull().isInstanceOf(ButtonProvider.class);
    }
}
