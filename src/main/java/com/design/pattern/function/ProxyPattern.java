package com.design.pattern.function;

import java.util.function.Supplier;

public class ProxyPattern {
    public static int compute(int n)
    {
        System.out.println("Computing heavy task......");
        return n*n;
    }

    public static void main(String[] args) {
        int someValue=5;
        Lazy<Integer> lazy= new Lazy<Integer>(() -> compute(someValue));
        if(someValue>3 && lazy.get()>6)
            System.out.println("Is computing... ");
        else
            System.out.println("Is not computing...");

    }
}

class Lazy<T>
{
    private T instance;
    private Supplier<T> supplier;

    public Lazy(Supplier<T> lazySupplier)
    {
        this.supplier=lazySupplier;
    }

    public T get()
    {
        if(instance==null)
        {
            instance=supplier.get();
            supplier=null;
        }
        return instance;
    }
}
