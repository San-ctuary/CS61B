public class Planet{
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;


    public static final double G = 6.67e-11;
    public Planet(double xP, double yP, double xV,double yV, double m, String img){
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet b){
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }

    public double calcDistance(Planet b) {
        double xx = (this.xxPos - b.xxPos) * (this.xxPos - b.xxPos);
        double yy = (this.yyPos - b.yyPos) * (this.yyPos - b.yyPos);
        double dis = Math.sqrt(xx + yy);
        return dis;
    }

    public double calcForceExertedBy(Planet p) {
        return Planet.G  * this.mass * p.mass / calcDistance(p) / calcDistance(p);
    }

    public double calcForceExertedByX(Planet p) {
        return calcForceExertedBy(p) * Math.abs(this.xxPos - p.xxPos) /  calcDistance(p);
    }

    public double calcForceExertedByY(Planet p) {
        return calcForceExertedBy(p) * Math.abs(this.yyPos - p.yyPos) /  calcDistance(p);
    }


    public double calcNetForceExertedByX(Planet[] planets){
        double ans = 0;
        for(Planet p : planets){
            if(!this.equals(p)){
                ans += calcForceExertedByX(p);
            }
        }
        return ans;
    }


    public double calcNetForceExertedByY(Planet[] planets){
        double ans = 0;
        for(Planet p : planets){
            if(!this.equals(p)){
                ans += calcForceExertedByY(p);
            }
        }
        return ans;
    }

    public void update(double dt,double fX,double fY){
        double ax = fX / this.mass;
        double ay = fY / this.mass;
        double vx = this.xxVel + dt * ax;
        double vy = this.yyVel + dt * ay;
        double px = this.xxPos + dt * vx;
        double py = this.yyPos + dt * vy;
        this.xxPos = px;
        this.yyPos = py;
    }
    
    public static void main(String[] args) {
        Planet p1 = new Planet(1e12,2e11,0,0,2e30,"p1");
        Planet p2 = new Planet(2.3e12,9.5e11,0,0,6e26,"p2");
        System.out.println(p1.calcForceExertedBy(p2));
    }
}