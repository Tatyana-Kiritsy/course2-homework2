package org.skypro.skyshop.searchable;

public interface Searchable {

    String getSearchedTerm();

    String getContentType();

    String getName();

    default void getStringRepresentation() {
        System.out.println("Наименование: " + getSearchedTerm() + " тип:" + getContentType());
    }

}
