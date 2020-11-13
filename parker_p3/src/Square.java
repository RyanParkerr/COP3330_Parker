class Square extends Shape2D {

    String name;
    double area;

    double sideLength1;

    public Square(double sideLength1) {
        super();
        this.sideLength1 = sideLength1;
    }

    @Override
    public String getName() {
        this.name = "square";
        return name;
    }

    @Override
    public double getArea() {
        this.area = sideLength1 * sideLength1;
        return this.area;
    }
}