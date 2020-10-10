class Cube extends Shape3D {
    public Cube(double sideLength1) {
        super();
        this.sideLength1 = sideLength1;
    }

    @Override
    public double getVolume() {
        this.volume = sideLength1 * sideLength1 * sideLength1;
        return volume;
    }

    @Override
    public String getName() {
        this.name = "cube";
        return name;
    }

    @Override
    public double getArea() {
        this.area = 6 * sideLength1 * sideLength1;
        return area;
    }
}
