package org.skypro.skyshop.searchable;


import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final List<Searchable> searches;
    int count;

    public SearchEngine() {
        searches = new ArrayList<>();
    }

    public List<Searchable> search(String text) {
        List<Searchable> searchable = new ArrayList<>();
        for (int i = 0; i < searches.size(); i++) {
            if (searches.get(i) != null &&
                    searches.get(i).getSearchedTerm().equalsIgnoreCase(text)) {
                    searchable.set(i, searches.get(i));
            }
        }
        return searchable;
    }

    public void add(Searchable search) {
        searches.add(search);
        }


    public Searchable getSuitableSearchedItem(String item) throws BestResultNotFoundException {
        Searchable searchedItem = null;
        int countMatches = 0;
        for (Searchable search : searches) {
            if (search != null) {
                int currentCountMatches = countMatches(search.getSearchedTerm(), item);
                if (currentCountMatches > countMatches) {
                    searchedItem = search;
                    countMatches = currentCountMatches;
                }
            }
        }
        if (searchedItem == null) {
            throw new BestResultNotFoundException("Совпадений для '" + item + "' не найдено!");
        }
        return searchedItem;
    }

    private int countMatches(String text, String item) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(item, index)) >= 0) {
            count++;
            index = index + item.length();
        }

        return count;
    }

    @Override
    public String toString() {
        return "SearchEngine{" +
                "searches=" + searches +
                '}';
    }
}




