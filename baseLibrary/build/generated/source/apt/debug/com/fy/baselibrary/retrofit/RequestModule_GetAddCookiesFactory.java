// Generated by dagger.internal.codegen.ComponentProcessor (https://google.github.io/dagger).
package com.fy.baselibrary.retrofit;

import com.fy.baselibrary.retrofit.cookie.AddCookiesInterceptor;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

public final class RequestModule_GetAddCookiesFactory implements Factory<AddCookiesInterceptor> {
  private final RequestModule module;

  public RequestModule_GetAddCookiesFactory(RequestModule module) {
    assert module != null;
    this.module = module;
  }

  @Override
  public AddCookiesInterceptor get() {
    return Preconditions.checkNotNull(
        module.getAddCookies(), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static Factory<AddCookiesInterceptor> create(RequestModule module) {
    return new RequestModule_GetAddCookiesFactory(module);
  }
}
