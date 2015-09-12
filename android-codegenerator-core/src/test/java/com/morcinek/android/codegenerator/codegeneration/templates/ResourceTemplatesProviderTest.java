package com.morcinek.android.codegenerator.codegeneration.templates;

import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class ResourceTemplatesProviderTest {

    private TemplatesProvider templatesProvider;

    @Before
    public void setUp() throws Exception {
        templatesProvider = new ResourceTemplatesProvider();
    }

    @Test
    public void provideAssignmentTemplateTest() throws Exception {
        String template = templatesProvider.provideTemplateForName("Assignment__template");
        Assertions.assertThat(template).isNotNull().isNotEmpty().isEqualTo(
                "        ${RESOURCE_PREFIX}${RESOURCE_NAME} = (${RESOURCE_TYPE}) ${CONTAINER_PREFIX}findViewById(${RESOURCE_ID});\n"
        );
    }
}
