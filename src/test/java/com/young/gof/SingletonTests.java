package com.young.gof;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import com.young.gof.singleton.NotSingleton;
import com.young.gof.singleton.Singleton;
import com.young.gof.singleton.SingletonNotSafe;
import com.young.gof.singleton.SingletonThreadDoubleCheckedLocking;
import com.young.gof.singleton.SingletonThreadEagerInit;
import com.young.gof.singleton.SingletonThreadStaticInnerClass;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class SingletonTests {
    @Test
    void singleton_test_by_comparing_instances() {
        NotSingleton notSingleton1 = new NotSingleton();
        NotSingleton notSingleton2 = new NotSingleton();
        assertNotSame(notSingleton1, notSingleton2);
    }

    @Test
    void singleton_test_by_comparing_singleton_instance() {
        SingletonNotSafe instance1 = SingletonNotSafe.getInstance();
        SingletonNotSafe instance2 = SingletonNotSafe.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    void singleton_test_by_Eager_initialization() {
        SingletonThreadEagerInit instance1 = SingletonThreadEagerInit.getInstance();
        SingletonThreadEagerInit instance2 = SingletonThreadEagerInit.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    void singleton_test_by_double_checked_locking() {
        SingletonThreadDoubleCheckedLocking instance1 = SingletonThreadDoubleCheckedLocking.getInstance();
        SingletonThreadDoubleCheckedLocking instance2 = SingletonThreadDoubleCheckedLocking.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    void singleton_test_by_static_inner_class() {
        SingletonThreadStaticInnerClass instance1 = SingletonThreadStaticInnerClass.getInstance();
        SingletonThreadStaticInnerClass instance2 = SingletonThreadStaticInnerClass.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    void breaking_singleton_pattern_by_reflection()
            throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        SingletonThreadStaticInnerClass instance1 = SingletonThreadStaticInnerClass.getInstance();
        Constructor<SingletonThreadStaticInnerClass> declaredConstructor = SingletonThreadStaticInnerClass.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        SingletonThreadStaticInnerClass instance2 = declaredConstructor.newInstance();
        assertNotSame(instance1, instance2);

        SingletonThreadDoubleCheckedLocking instance3 = SingletonThreadDoubleCheckedLocking.getInstance();
        Constructor<SingletonThreadDoubleCheckedLocking> declaredConstructor1 = SingletonThreadDoubleCheckedLocking.class.getDeclaredConstructor();
        declaredConstructor1.setAccessible(true);
        SingletonThreadDoubleCheckedLocking instance4 = declaredConstructor1.newInstance();
        assertNotSame(instance3, instance4);
    }

    @Test
    void breaking_singleton_pattern_by_serialize() throws IOException, ClassNotFoundException {
        SingletonThreadStaticInnerClass instance1 = SingletonThreadStaticInnerClass.getInstance();
        SingletonThreadStaticInnerClass instance2;

        //serialized
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("SingletonThreadStaticInnerClass.obj"))) {
            out.writeObject(instance1);
        }
        //deserialized
        try (ObjectInput in = new ObjectInputStream(new FileInputStream("SingletonThreadStaticInnerClass.obj"))) {
            instance2 = (SingletonThreadStaticInnerClass) in.readObject();
        }
        assertNotSame(instance1, instance2);
    }

    @Test
    void singleton_pattern_by_enum() throws IOException, ClassNotFoundException {
        Singleton instance1 = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        assertSame(instance1, instance2);
        Constructor<?>[] constructors = Singleton.class.getDeclaredConstructors();
        Arrays.stream(constructors).forEach(constructor -> {
            constructor.setAccessible(true);
            IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class, () -> {
                constructor.newInstance("INSTANCE");
            }, "should throw IllegalArgumentException, since refection won't work for enum");
        });

        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("SingletonThreadStaticInnerClass.obj"))) {
            out.writeObject(instance1);
        }
        //deserialized
        try (ObjectInput in = new ObjectInputStream(new FileInputStream("SingletonThreadStaticInnerClass.obj"))) {
            instance2 = (Singleton) in.readObject();
        }
        assertSame(instance1, instance2);
    }

    @Test
    void singleton_example_on_spring(){
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.maxMemory());
    }

}
