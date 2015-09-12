package com.morcinek.android.codegenerator.extractor;

import com.morcinek.android.codegenerator.util.InputStreamProvider;
import org.fest.assertions.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class XMLPackageExtractorTest {

    private InputStreamProvider inputStreamProvider = new InputStreamProvider();

    private PackageExtractor packageExtractor;

    @Before
    public void setUp() throws Exception {
        packageExtractor = new XMLPackageExtractor();
    }

    @Test
    public void extractPackageFromManifestStreamTest() throws Exception {
        // given
        InputStream inputStream = inputStreamProvider.getStreamFromResource("extractor/manifests/AndroidManifest.xml");

        // when
        String packageName = packageExtractor.extractPackageFromManifestStream(inputStream);

        // then
        Assertions.assertThat(packageName).isNotNull().isEqualTo("com.morcinek.grouplaying");
    }

    @Test
    public void extractPackageFromManifestWhereIsNoPackageStreamTest() throws Exception {
        // given
        InputStream inputStream = inputStreamProvider.getStreamFromResource("extractor/manifests/AndroidManifestWithoutPackage.xml");

        // when
        String packageName = packageExtractor.extractPackageFromManifestStream(inputStream);

        // then
        Assertions.assertThat(packageName).isNotNull().isEmpty();
    }
}