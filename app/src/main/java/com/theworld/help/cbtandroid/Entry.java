package com.theworld.help.cbtandroid;

import java.io.Serializable;

public class Entry implements Serializable {
    private String
            title,
            situation,
            feelings,
            thoughts,
            support,
            against,
            alt,
            outcome;

    public Entry(String title, String situation, String feelings, String thoughts, String support, String against, String alt, String outcome) {
        this.title = title;
        this.situation = situation;
        this.feelings = feelings;
        this.thoughts = thoughts;
        this.support = support;
        this.against = against;
        this.alt = alt;
        this.outcome = outcome;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getFeelings() {
        return feelings;
    }

    public void setFeelings(String feelings) {
        this.feelings = feelings;
    }

    public String getThoughts() {
        return thoughts;
    }

    public void setThoughts(String thoughts) {
        this.thoughts = thoughts;
    }

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }

    public String getAgainst() {
        return against;
    }

    public void setAgainst(String against) {
        this.against = against;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    @Override
    public String toString() {
        return title;
    }
}
