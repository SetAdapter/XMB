// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.fy.baselibrary.retrofit;

import dagger.internal.Factory;
import dagger.internal.Preconditions;
import okhttp3.Interceptor;

public final class RequestModule_GetHeaderFactory implements Factory<Interceptor> {
  private final RequestModule module;

  public RequestModule_GetHeaderFactory(RequestModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public Interceptor get() {
    return Preconditions.checkNotNull(
        module.getHeader(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<Interceptor> create(RequestModule module) {
    return new RequestModule_GetHeaderFactory(module);
  }
}