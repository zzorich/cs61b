public class NBody{

    public static double readRadius(String file_name) {
        In in_universe = new In(file_name);

        int num_planets = in_universe.readInt();
        double radius = in_universe.readDouble();
        
        return radius;
    }

    public static Planet[] readPlanets(String file_name) {
        In in_universe = new In(file_name);

        int num_planets = in_universe.readInt();
        double radius = in_universe.readDouble();

        Planet[] planets = new Planet[num_planets];

        for (int i = 0; i < num_planets; i++) {
            double xP = in_universe.readDouble();
            double yP = in_universe.readDouble();
            double xV = in_universe.readDouble();
            double yV = in_universe.readDouble();
            double m = in_universe.readDouble();
            String img = in_universe.readString();

            planets[i] = new Planet(xP, yP, xV, yV, m, img);
        }

        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        Planet[] planets = readPlanets(filename);
        double radius = readRadius(filename);

        StdDraw.enableDoubleBuffering();
        StdAudio.play("audio/2001.mid");

        /**Set the canvas */
        StdDraw.setScale(-radius, radius);
        /**Draw the backgroud.*/
        StdDraw.picture(0, 0, "images/starfield.jpg", 2 * radius, 2 * radius);

        /*Draw all planets*/
        for (Planet p : planets) {
            p.draw();
        }

        StdDraw.show();

        int num_planets = planets.length;
        double[] xForces = new double[num_planets];
        double[] yForces = new double[num_planets];
        double t = 0;
        while (t <= T) {
            StdDraw.clear();

            for (int i = 0; i < num_planets; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }

            /*Update planets.*/
            for (int i = 0; i < num_planets; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.picture(0, 0, "images/starfield.jpg", 2 * radius, 2 * radius);
            for (Planet p : planets) {
                p.draw();
            }
            
            StdDraw.show();
            StdDraw.pause(10);
            t += dt;
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