package com.espectro93;

import net.bytebuddy.build.Plugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.SuperMethodCall;
import net.bytebuddy.matcher.ElementMatchers;

import java.io.IOException;

public class CounterWeavingPlugin implements Plugin {

    @Override
    public boolean matches(TypeDescription target) {
        return true; // Apply to all classes
    }

    @Override
    public void close() throws IOException {}

    @Override
    public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        return builder.constructor(ElementMatchers.any())
                .intercept(MethodDelegation.to(ConstructorInterceptor.class)
                        .andThen(SuperMethodCall.INSTANCE));
    }
}