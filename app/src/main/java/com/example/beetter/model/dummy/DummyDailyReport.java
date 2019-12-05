package com.example.beetter.model.dummy;

public class DummyDailyReport {
    private String name;
    private String lastWork;
    private String nextWork;
    private String obstacle;

    public DummyDailyReport(String name, String lastWork, String nextWork, String obstacle) {
        this.name = name;
        this.lastWork = lastWork;
        this.nextWork = nextWork;
        this.obstacle = obstacle;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastWork() {
        return lastWork;
    }

    public void setLastWork(String lastWork) {
        this.lastWork = lastWork;
    }

    public String getNextWork() {
        return nextWork;
    }

    public void setNextWork(String nextWork) {
        this.nextWork = nextWork;
    }

    public String getObstacle() {
        return obstacle;
    }

    public void setObstacle(String obstacle) {
        this.obstacle = obstacle;
    }
}
