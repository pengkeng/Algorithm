package com.ucas;

import java.util.ArrayList;

public class Point {
    private String name;
    private Point parent = null;
    private ArrayList<Point> children = null;
    public boolean isVisited = false;
    public int dfn;
    public int low;

    public Point(String name) {
        this(name, null, null);
    }

    public Point(String name, Point parent) {
        this(name, parent, null);
    }

    public Point(String name, Point parent, ArrayList<Point> children) {
        this.name = name;
        this.parent = parent;
        this.children = children;
    }

    public void addChild(Point child) {
        children.add(child);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Point getParent() {
        return parent;
    }

    public void setParent(Point parent) {
        this.parent = parent;
    }

    public ArrayList<Point> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Point> children) {
        this.children = children;
    }
}
