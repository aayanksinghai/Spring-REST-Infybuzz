package com.example.springRest.request;

import java.util.List;

public class InQueryRequest {
    private List<String> firstNames;

    public List<String> getFirstNames() {
        return firstNames;
    }

    public void setFirstNames(List<String> firstNames) {
        this.firstNames = firstNames;
    }
}
