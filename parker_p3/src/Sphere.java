class Sphere extends Shape3D {
    public Sphere(double radius) {
        super();
        this.radius = radius;
    }

    @Override
    public double getVolume() {
        this.volume = (Math.pow(radius, 3) * 4) / 3 * Math.PI;
        return this.volume;
    }

    @Override
    public String getName() {
        this.name = "sphere";
        return this.name;
    }

    @Override
    public double getArea() {
        this.area = radius * radius * 4 * Math.PI;
        return this.area;
    }
}