package com.kodilla.testing.shape;

import java.util.*;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Shape Collector Test Suite")
public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterAll
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }


    @Nested
    @DisplayName("Tests for existing geometrical figures")
    class A {

        @DisplayName("Add figure test")
        @Test
        public void testAddFigure() {

            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Square(4);
            //When
            shapeCollector.addFigure(shape);
            //Then
            assertEquals(1, shapeCollector.getShapeCollection().size());
        }

        @DisplayName("Remove figure test")
        @Test
        public void testRemoveFigure() {

            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Circle(4);
            shapeCollector.addFigure(shape);
            //When
            boolean result = shapeCollector.removeFigure(shape);
            //Then
            assertTrue(result);
            assertEquals(0, shapeCollector.getShapeCollection().size());
        }

        @DisplayName("Get number of existing figure test")
        @Test
        public void testGetFigureExistNumber() {

            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Square(4);
            shapeCollector.addFigure(shape);
            //When
            Shape shapeResult = shapeCollector.getFigure(0);
            //Then
            assertEquals(shape, shapeResult);
        }

        @DisplayName("Show figures test")
        @Test
        public void testShowFigures() {

            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            Shape shape = new Triangle(3, 2, 5);
            shapeCollector.addFigure(shape);
            ArrayList<Shape> shapeList = new ArrayList<>();
            shapeList.add(shape);
            //When
            List<Shape> shapeResultList = shapeCollector.getShapeCollection();
            //Then
            assertEquals(shapeList.toString(), shapeResultList.toString());
        }
    }

    @Nested
    @DisplayName("Tests for the non-existing geometrical figures")
    class B {

        @DisplayName("Remove figure which does not exist test")
        @Test
        public void testRemoveFigureWhichDoesNotExist() {

            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(new Square(5));
            //When
            boolean result = shapeCollector.removeFigure(new Square(4));
            //Then
            assertFalse(result);
            assertEquals(1, shapeCollector.getShapeCollection().size());
        }

        @DisplayName("Get figure number out of range test")
        @Test
        public void testGetFigureNumberOutOfRange() {

            //Given
            ShapeCollector shapeCollector = new ShapeCollector();
            //When
            Shape shapeResult = shapeCollector.getFigure(0);
            //Then
            assertNull(shapeResult);
        }
    }
}