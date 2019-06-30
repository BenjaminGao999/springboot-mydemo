package com.example.base.java.demobasejava.reference;

/**
 * @author benjamin
 * created at 2019/6/30
 * OOM
 */
public class SlowFinalizer {
    public static void main(String[] argv) throws Exception {
        while (true) {
            Object foo = new SlowFinalizer();
        }
    }

    // some member variables to take up space -- approx 200 bytes
    double a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z;

    // and the finalizer, which does nothing by take time
    protected void finalize() throws Throwable {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException ignored) {
        }
        super.finalize();
    }
}

