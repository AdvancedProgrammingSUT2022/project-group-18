package model.Resource;

import model.Resource.Resources;

public class StrategicResources extends Resources {
    private String note;

    public StrategicResources(String name, Integer food, Integer production, Integer gold, String canBeFound, String improvementNeeded, String note) {
        super(name, food, production, gold, canBeFound, improvementNeeded);
        this.note = note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }
}
