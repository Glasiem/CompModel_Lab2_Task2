public class Main {

    public static double f3(double x, double y0){
        return Math.sqrt(x)*y0+1;
    }

    public static double f2(double y2){
        return y2;
    }

    public static double f1(double y1){
        return y1;
    }

    public static void eulerKoshi(){
        double h = 0.1;
        double a = 1;
        double b = 2;
        int dots = (int) ((b-a)/h + 1);
        double[] x = new double[dots];
        x[0] = 1;
        for (int i = 1; i < dots; i++) {
            x[i] = x[i-1] + h;
        }
        double[] y0 = new double[dots];
        y0[0] = 0;
        double y0_alter;
        double[] y1 = new double[dots];
        y1[0] = -2;
        double y1_alter;
        double[] y2 = new double[dots];
        y2[0] = 3;
        double y2_alter;
        System.out.println("x" + 0 + " = " + x[0] + " " + "\t\t\t" + "y" + 0 + " = " + y0[0]);
        for (int i = 0; i < dots-1; i++) {
            y0_alter = y0[i] + h*f1(y1[i]);
            y1_alter = y0[i] + h*f1(y2[i]);
            y2_alter = y0[i] + h*f3(x[i],y0[i]);
            y0[i+1] = y0[i] + h*(f1(y1[i]) + f1(y1_alter))/2;
            y0[i+1] = y0[i] + h*(f2(y2[i]) + f1(y2_alter))/2;
            y0[i+1] = y0[i] + h*(f3(x[i],y0[i]) + f3(x[i+1],y0_alter))/2;
            System.out.println("x" + (i+1) + " = " + String.format("%,.4f", x[i+1]) + " " + "\t\t" + "y" + (i+1) + " = " + String.format("%,.4f", y0[i+1]));
        }
    }

    public static void main(String[] args) {
        System.out.println("Ейлера Коші");
        eulerKoshi();
    }
}