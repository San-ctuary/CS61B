public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;


    private static final double G = 6.67e-11;
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
        return calcForceExertedBy(p) * (- this.xxPos + p.xxPos) /  calcDistance(p);
    }

    public double calcForceExertedByY(Planet p) {
        return calcForceExertedBy(p) * (- this.yyPos + p.yyPos) /  calcDistance(p);
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
        this.xxVel = vx;
        this.yyVel = vy;
    }
    

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, this.imgFileName);
    }

    
}