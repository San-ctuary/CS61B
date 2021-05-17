public class NBody{
    public static double readRadius(String filename){
        In in = new In(filename);
        int planetNum = in.readInt();
        double PlanetRadius = in.readDouble();
        return PlanetRadius;
    }

    public static Planet[] readPlanets(String filename){
        In in = new In(filename);
        int planetNum = in.readInt();
        Planet[] planets = new Planet[planetNum];
        double PlanetRadius = in.readDouble();
        for(int i = 0;i < planetNum;i++){
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            Planet p = new Planet(xP,yP,xV,yV,m,img);
            planets[i] = p;
        }
        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);
        StdDraw.setScale(-radius,radius);
        StdDraw.picture(0, 0, "images/starfield.jpg");
        for(Planet planet : planets){
            planet.imgFileName = "images/" + planet.imgFileName;
            planet.draw();
        }
        StdDraw.enableDoubleBuffering();
        double time = 0;
        int n = planets.length;
        while(time < T){
            double[] xForces = new double[n];
            double[] yForces = new double[n];
            double xf = 0;
            double yf = 0;
            for(int j = 0;j < n;j++){
                xf = planets[j].calcNetForceExertedByX(planets);
                yf = planets[j].calcNetForceExertedByY(planets);
                xForces[j] = xf;
                yForces[j] = yf;
            }
            for(int i = 0;i < n;i++){
                planets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, "images/starfield.jpg");
            for(Planet planet : planets){
                planet.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
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