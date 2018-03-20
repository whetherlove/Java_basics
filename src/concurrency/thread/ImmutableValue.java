package concurrency.thread;

import jdk.nashorn.internal.ir.annotations.Immutable;

import java.lang.annotation.Annotation;

/**
 * @author Jacob Zhang
 * @ProjectName: java_basics
 * @Package: concurrency.thread
 * @Description:
 * @date 19/03/2018 10:39 AM
 */
public class ImmutableValue {

    //We can make sure that objects shared between threads are never updated
    //by any of the threads by making the shared objects immutable, and thereby
    //thread safe.
    //e.g.
    private int value = 0;

    public ImmutableValue(int i) {
    }

    public void immutableValue(int value){
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    //Notice that the value does not have set method. If you need to
    //perform operations on the ImmutableValue instance you can do so
    //by returning a new instance with the value resulting from the operation.
    public ImmutableValue add(int valueToAdd){
        return new ImmutableValue(this.value + valueToAdd);
    }
}

//The ImmutableValue class is thread safe, but the use of it is not
//e.g.
class Calculator{
    private ImmutableValue currentValue = null;

    public ImmutableValue getValue(){
        return currentValue;
    }

    public void setValue(ImmutableValue newValue){
        this.currentValue = newValue;
    }

    public void add(int newValue){
        this.currentValue = this.currentValue.add(newValue);
    }
}
//it is possible to change that reference through both the setValue() and add() methods.
