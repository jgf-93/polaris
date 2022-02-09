package com.polaris.common.demo.designModel.ObserverDesign;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> observerList = new ArrayList<>();

    int state;

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllOb();
    }

    public void add(Observer ob) {
        observerList.add(ob);
    }

    private void notifyAllOb() {
        for (Observer ob : observerList) {
            ob.update();
        }
    }
}
