public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private final static double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }
    public double calcDistance (Planet p) {
        if(this.equals(p)) {
            return 0.0;
        }
        double xDist = xxPos-p.xxPos;
        double yDist = yyPos-p.yyPos;
        return Math.sqrt(xDist*xDist + yDist*yDist);
    }

    public double calcForceExertedBy(Planet p) {
        if(this.equals(p)) {
            return 0.0;
        }
        double dist = calcDistance(p);
        double m_1 = this.mass;
        double m_2 = p.mass;
        return G*m_1*m_2 / (dist * dist);
    }

    public double calcForceExertedByX(Planet p) {
        if(this.equals(p)) {
            return 0.0;
        }
        double totalForce = calcForceExertedBy(p);
        double xDistance =  p.xxPos - this.xxPos;
        double totalDistance = calcDistance(p);
        return totalForce*xDistance / totalDistance;
    }

    public double calcForceExertedByY(Planet p) {
        if(this.equals(p)) {
            return 0.0;
        }
        double totalForce = calcForceExertedBy(p);
        double yDistance = p.yyPos - this.yyPos;
        double totalDistance = calcDistance(p);
        return totalForce*yDistance / totalDistance;
    }

    public double calcNetForceExertedByX(Planet[] planets) {
        double sum = 0.0;
        for(Planet p:planets) {
            sum += calcForceExertedByX(p);
       }
       return sum;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double sum = 0.0;
        for(Planet p:planets) {
            sum += calcForceExertedByY(p);
       }
       return sum;
    }

    public void update(double dt, double fX, double fY) {
        double m = mass;
        double a_x = fX/ m;
        double a_y = fY / m;

        //Update velocities in the time interval
        xxVel = xxVel + dt* a_x;
        yyVel = yyVel + dt*a_y;

        //Updates positions in the time interval
        xxPos = xxPos + dt*xxVel;
        yyPos = yyPos + dt*yyVel;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos,  "./images/" + imgFileName);
    }



}
