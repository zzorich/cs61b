public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;

    private static final double G_coff = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Planet(Planet p) {
        this(p.xxPos, p.yyPos, p.xxVel, p.yyVel, p.mass, p.imgFileName);        
    }

    public double calcDistance(Planet p) {
        double distance;
        distance = Math.sqrt(Math.pow(this.xxPos - p.xxPos, 2) + Math.pow(this.yyPos - p.yyPos, 2));
        
        return distance;
    }

    public double calcForceExertedBy(Planet p) {
        double distance = this.calcDistance(p);
        double force = (G_coff * this.mass * p.mass)/ Math.pow(distance, 2);
        
        return force;
    }

    public double calcForceExertedByX(Planet p) {
        double distance = this.calcDistance(p);
        double x_force = this.calcForceExertedBy(p) * (p.xxPos - this.xxPos) / distance;

        return x_force;
    }

    public double calcForceExertedByY(Planet p) {
        double distance = this.calcDistance(p);
        double y_force = this.calcForceExertedBy(p) * (p.yyPos - this.yyPos) / distance;

        return y_force;
    }

    public double calcNetForceExertedByX(Planet[] planets) {
        double x_net_force = 0;
        for (Planet p : planets) {
            if(this.equals(p)) {
                continue;
            }
            x_net_force += this.calcForceExertedByX(p);
        }
        
        return x_net_force;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double y_net_force = 0;
        for (Planet p : planets) {
            if(this.equals(p)) {
                continue;
            }
            y_net_force += this.calcForceExertedByY(p);
        }
        
        return y_net_force;
    }

    public void update(double dt, double x_f, double y_f) {
        double a_x = x_f / this.mass;
        double a_y = y_f / this.mass;
        this.xxVel += a_x * dt;
        this.yyVel += a_y * dt;
        this.xxPos += this.xxVel * dt;
        this.yyPos += this.yyVel * dt;
    }

    public void draw() {
        StdDraw.picture(this.xxPos, this.yyPos, "images/" + this.imgFileName);
    }
}