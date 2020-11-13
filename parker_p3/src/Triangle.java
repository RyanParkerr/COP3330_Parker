class Triangle extends Shape2D {
    String name;
    double area;

    double sideLength1;
    double height;


    public Triangle(double sideLength1, double height) {
        super();
        this.sideLength1 = sideLength1;
        this.height = height;
    }

    @Override
    public String getName() {
        this.name = "triangle";
        return name;
    }

    @Override
    public double getArea() {
        this.area = sideLength1 * height * 0.5;
        return this.area;
    }
}
