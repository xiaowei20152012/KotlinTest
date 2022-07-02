package mxjava.test;

import com.oracle.tools.packager.Bundler;

public interface Bundleable {
    Bundler toBundler();

    interface CREATOR<T extends Bundleable> {
        T fromBundle(Bundler bundler);
    }

    /**
     * Bundle bundle = foo.toBunder();
     * Foo foo = FOO.CREATOR.fromBundle()
     */
}
