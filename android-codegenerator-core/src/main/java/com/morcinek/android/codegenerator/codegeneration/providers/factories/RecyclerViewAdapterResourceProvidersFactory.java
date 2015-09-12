package com.morcinek.android.codegenerator.codegeneration.providers.factories;

import com.morcinek.android.codegenerator.codegeneration.providers.ResourceProvider;
import com.morcinek.android.codegenerator.codegeneration.providers.ResourceProvidersFactory;
import com.morcinek.android.codegenerator.codegeneration.providers.resources.DefaultProvider;
import com.morcinek.android.codegenerator.extractor.model.Resource;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class RecyclerViewAdapterResourceProvidersFactory implements ResourceProvidersFactory {

    @Override
    public ResourceProvider createResourceProvider(Resource resource) {
        DefaultProvider defaultProvider = new DefaultProvider(resource);
        defaultProvider.putExtra("RESOURCE_PREFIX", "    ");
        defaultProvider.putExtra("CONTAINER_PREFIX", "view.");
        return defaultProvider;
    }
}
