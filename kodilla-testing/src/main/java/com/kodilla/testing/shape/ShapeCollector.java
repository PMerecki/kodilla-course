package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private final List<Shape> shapeCollection = new ArrayList<>();

    public List<Shape> getShapeCollection() {
        return shapeCollection;
    }

    public void addFigure(Shape shape){
        shapeCollection.add(shape);
    }

    public boolean removeFigure(Shape shape){
        return shapeCollection.remove(shape);
    }

    public Shape getFigure(int n){
        if(n<shapeCollection.size() && n>=0){
            return shapeCollection.get(n);
        } else {
            return null;
        }

    }

    public void showFigures(){
        System.out.println(shapeCollection.toString());
    }
}