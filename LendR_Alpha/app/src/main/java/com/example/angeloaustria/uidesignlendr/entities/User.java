package com.example.angeloaustria.uidesignlendr.entities;

/**
 * Created by angeloaustria on 2016-12-26.
 */

public class User {

    private String name, goodKarma, badKarma, borrowedAmount;

    public User() { }

    public User(String name, String goodKarma, String badKarma, String borrowedAmount) {
        this.name = name;
        this.goodKarma = goodKarma;
        this.badKarma = badKarma;
        this.borrowedAmount = borrowedAmount;
    }

    public String getName() { return this.name; }

    public String getGoodKarma() { return this.goodKarma; }

    public String getBadKarma() { return this.badKarma; }

    public String getBorrowedAmount() { return this.borrowedAmount; }

    public void setName(String name) { this.name = name; }

    public void setGoodKarma(String goodKarma) { this.goodKarma = goodKarma; }

    public void setBadKarma(String badKarma) { this.badKarma = badKarma; }

    public void setBorrowedAmount(String borrowedAmount) { this.borrowedAmount = borrowedAmount; }
}
