package com.morcinek.android.codegenerator.codegeneration;

import com.google.common.collect.Lists;
import com.morcinek.android.codegenerator.codegeneration.providers.factories.AdapterResourceProvidersFactory;
import com.morcinek.android.codegenerator.codegeneration.templates.ResourceTemplatesProvider;
import com.morcinek.android.codegenerator.codegeneration.templates.TemplatesProvider;
import com.morcinek.android.codegenerator.extractor.model.Resource;
import com.morcinek.android.codegenerator.extractor.model.ResourceId;
import com.morcinek.android.codegenerator.extractor.model.ResourceType;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class AdapterTemplateCodeGeneratorTest {

    private TemplatesProvider templatesProvider = new ResourceTemplatesProvider();

    private TemplateCodeGenerator templateCodeGenerator;

    @Before
    public void setUp() throws Exception {
        templateCodeGenerator = new TemplateCodeGenerator("Adapter_template", new AdapterResourceProvidersFactory(), new ResourceTemplatesProvider());
    }

    @Test
    public void produceMainActivityCodeTest() throws Exception {
        // given
        List<Resource> resources = Lists.newArrayList(new Resource(new ResourceId("button"), new ResourceType("Button")));

        // when
        String generatedCode = templateCodeGenerator.generateCode(resources, "main");

        // then
        String expectedCode = templatesProvider.provideTemplateForName("results/adapters/MainAdapter.java");
        Assertions.assertThat(generatedCode).isNotNull().isEqualTo(expectedCode);
    }

    @Test
    public void produceTermsActivityCodeTest() throws Exception {
        // given
        List<Resource> resources = Lists.newArrayList(
                new Resource(new ResourceId("button"), new ResourceType("Button")),
                new Resource(new ResourceId("accepts_terms"), new ResourceType("CheckBox"))
        );

        // when
        String generatedCode = templateCodeGenerator.generateCode(resources, "terms");

        // then
        String expectedCode = templatesProvider.provideTemplateForName("results/adapters/TermsAdapter.java");
        Assertions.assertThat(generatedCode).isNotNull().isEqualTo(expectedCode);
    }

    @Test
    public void produceFormActivityCodeTest() throws Exception {
        // given
        List<Resource> resources = Lists.newArrayList(
                new Resource(new ResourceId("button"), new ResourceType("ImageButton")),
                new Resource(new ResourceId("edit_text_name"), new ResourceType("EditText")),
                new Resource(new ResourceId("edit_text_city"), new ResourceType("EditText")),
                new Resource(new ResourceId("header_text"), new ResourceType("TextView")),
                new Resource(new ResourceId("list", "android"), new ResourceType("List"))
        );

        // when
        String generatedCode = templateCodeGenerator.generateCode(resources, "form");

        // then
        String expectedCode = templatesProvider.provideTemplateForName("results/adapters/FormAdapter.java");
        Assertions.assertThat(generatedCode).isNotNull().isEqualTo(expectedCode);
    }
}