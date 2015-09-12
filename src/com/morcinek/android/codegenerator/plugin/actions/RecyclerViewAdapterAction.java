package com.morcinek.android.codegenerator.plugin.actions;

import com.morcinek.android.codegenerator.codegeneration.providers.ResourceProvidersFactory;
import com.morcinek.android.codegenerator.codegeneration.providers.factories.AdapterResourceProvidersFactory;
import com.morcinek.android.codegenerator.codegeneration.providers.factories.RecyclerViewAdapterResourceProvidersFactory;

/**
 * Copyright 2014 Tomasz Morcinek. All rights reserved.
 */
public class RecyclerViewAdapterAction extends LayoutAction {

    @Override
    protected String getResourceName() {
        return "RecyclerViewAdapter";
    }

    @Override
    protected String getTemplateName() {
        return "RecyclerViewHolder_template";
    }

    @Override
    protected ResourceProvidersFactory getResourceProvidersFactory() {
        return new RecyclerViewAdapterResourceProvidersFactory();
    }
}
