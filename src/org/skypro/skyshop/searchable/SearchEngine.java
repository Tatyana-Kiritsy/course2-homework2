package org.skypro.skyshop.searchable;


import java.util.Arrays;

public class SearchEngine {
    private final Searchable[] searches;
    int size;

    public SearchEngine(int size) {
        searches = new Searchable[size];
    }


    public Searchable[] search(String text) {
        Searchable[] searchable = new Searchable[size];
        for (int i = 0; i < searches.length; i++) {
            if (searches[i] != null && searches[i].getSearchedTerm().toLowerCase().contains(text)) {
                if (i <= size) {
                    searchable[i] = searches[i];
                }
            }
        }
        return searchable;
    }

    public void add(Searchable search) {
        if (searches[size] == null) {
            searches[size] = search;
            size++;
        }
    }


    @Override
    public String toString() {
        return "SearchEngine{" +
                "searches=" + Arrays.toString(searches) +
                '}';
    }
}



