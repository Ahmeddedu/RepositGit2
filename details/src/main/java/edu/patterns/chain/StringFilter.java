package edu.patterns.chain;

interface StringFilter {
    void setNext(StringFilter next);

    String process(String input);
}