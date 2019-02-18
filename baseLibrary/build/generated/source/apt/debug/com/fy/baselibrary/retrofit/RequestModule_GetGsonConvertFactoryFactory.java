// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.fy.baselibrary.retrofit;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import retrofit2.converter.gson.GsonConverterFactory;

public final class RequestModule_GetGsonConvertFactoryFactory
    implements Factory<GsonConverterFactory> {
  private final RequestModule module;

  public RequestModule_GetGsonConvertFactoryFactory(RequestModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public GsonConverterFactory get() {
    return Preconditions.checkNotNull(
        module.getGsonConvertFactory(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<GsonConverterFactory> create(RequestModule module) {
    return new RequestModule_GetGsonConvertFactoryFactory(module);
  }
}