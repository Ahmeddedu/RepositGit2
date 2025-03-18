package edu.patterns.chain;

abstract class BaseStringFilter implements StringFilter {
    protected StringFilter next;

    @Override
    public void setNext(StringFilter next) {
        this.next = next;
    }

    @Override
    public String process(String input) {
        String result = handle(input);
        if (next !=null)
            return  next.process(result);
        else
            return result;
    }

    protected abstract String handle(String input);
}