class Pyramid extends Shape3D {

    String name;
    double area;
    double volume;

    double sideLength1;
    double sideLength2;
    double height;


    public Pyramid(double sideLength1, double sideLength2, double height) {
        super();
        this.sideLength1 = sideLength1;
        this.sideLength2 = sideLength2;
        this.height = height;
    }

    @Override
    public double getVolume() {
        this.volume = (sideLength1 * sideLength2 * height) / 3;
        return volume;
    }

    @Override
    public String getName() {
        this.name = "pyramid";
        return name;
    }

    @Override
    public double getArea() {
        double sqRt1;
        double sqRt2;

        sqRt1 = Math.sqrt(Math.pow(sideLength2 / 2, 2) + Math.pow(height, 2));
        sqRt2 = Math.sqrt(Math.pow(sideLength1 / 2, 2) + Math.pow(height, 2));

        this.area = (sideLength1 * sideLength2) + (sideLength1 * sqRt1) + (sideLength2 * sqRt2);
        return area;
    }
}
