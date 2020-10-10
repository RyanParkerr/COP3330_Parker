class Circle extends Shape2D {

    public Circle(double radius) {
        super();
        this.radius = radius;
    }
    @Override
    public String getName() {
        this.name = "circle";
        return this.name;
    }

    @Override
    public double getArea() {
        this.area = Math.pow(radius, 2) * Math.PI;
        return area;
    }
}
