package edu.patterns.chain;

class TrimFilter extends BaseStringFilter {
    @Override
    protected String handle(String input) {
        return input.trim();
    }
}
