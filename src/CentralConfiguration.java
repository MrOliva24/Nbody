public class CentralConfiguration extends Universe {

    public CentralConfiguration(int n) {
        numBodies = n;
        radius = 1e11;
        bodies = new Body[numBodies];
        double mass = 1e33;
        double distance = 0.4*radius;
        double gamma = 5e-5;
        double angleVelPos = Math.PI/4.;
        double velocityMagnitude = gamma*distance;
        for (int i = 0; i<numBodies; i++) {
            double anglePos = (2*Math.PI*i)/numBodies;
            double rx = distance*Math.cos(anglePos);
            double ry = distance*Math.sin(anglePos);
            double vx = velocityMagnitude*Math.cos(anglePos + angleVelPos);
            double vy = velocityMagnitude*Math.sin(anglePos + angleVelPos);
            bodies[i] = new Body(new Vector(new double[]{rx,ry}), new Vector(new double[]{vx,vy}), mass);
        }
    }
}
