package academy.learnprogramming;

public interface ShapeInterface {
    public double area();
}

interface SolidShapeInterface {
    public double volume();
}

interface ManageShapeInterface {
    public double calculate();
}

class Cube implements ShapeInterface, SolidShapeInterface, ManageShapeInterface {

    public double area() {
        // calculate the surface area of the cuboid
        return 1.0;
    }

    public double volume() {
        // calculate the volume of the cuboid
        return 1.0;
    }

    public double calculate() {
        return this.area() + this.volume();
    }
}

class Square implements ShapeInterface, ManageShapeInterface {
    public double area() {
        return 2.0;
    }

    public double calculate() {
        return this.area();
    }
}