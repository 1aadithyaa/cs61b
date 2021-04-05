public class NBody {
    public static double readRadius(String filepath) {
        In in = new In(filepath);
        in.readDouble();
        double radius = in.readDouble();
        return radius;
    }
 

    public static Planet[] readPlanets(String filepath) {
        In in = new In(filepath);
        int num_planets = in.readInt();
        in.readDouble();
        Planet[] planets = new Planet[num_planets];
        for(int i = 0; i < num_planets; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileString = in.readString();
            planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileString);
        } 
        return planets;
    }
    
    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets("./data/planets.txt");
        StdDraw.setScale(-radius, radius);
        StdDraw.enableDoubleBuffering();

        for(double t = 0.0; t < T; t += dt) {
            int numPlanets = planets.length;
            double[] xForces = new double[numPlanets];
            double[] yForces = new double[numPlanets];

            //Calculates all net forces
            for(int i = 0; i < numPlanets; i++) {
                Planet p = planets[i];
                xForces[i] = p.calcNetForceExertedByX(planets);
                yForces[i] = p.calcNetForceExertedByY(planets);
            }

            //Update all the planets
            for (int i = 0; i < numPlanets; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.picture(0, 0, "./images/starfield.jpg");

            for(Planet p: planets) {
                p.draw();
                }
            StdDraw.show();
            StdDraw.pause(10);

            }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for (int i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }

    }
    
}
