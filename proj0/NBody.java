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
        

    }
}