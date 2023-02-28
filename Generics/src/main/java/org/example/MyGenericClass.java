package org.example;

public class MyGenericClass<T> {
    public T obj;
    public MyGenericClass(T obj)
    {
        this.obj = obj;
        if (obj instanceof ClassA) {
            ClassA a = (ClassA) obj;
            a.methodA();
        }
    }

    public T getObj() {
        return obj;
    }
}
