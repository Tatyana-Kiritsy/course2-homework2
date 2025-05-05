package org.skypro.skyshop.searchable;

public interface Searchable {

    String getSearchedTerm();

    String getContentType();

    default void getStringRepresentation() {
        System.out.println("Наименование: " + getSearchedTerm() + " тип:" + getContentType());
    }

}
