public class Nplus1 extends Universe {


    public Nplus1(int n) {

        final double MAX_VELOCITY = 1e05;
        final double MIN_VELOCITY = 1e04;
        final double MIN_MASS = 1e22;
        final double MAX_MASS = 1e24;
        final double BIGGEST_MASS = 1e39;

        numBodies = n + 1;
        radius = 1e12;
        bodies = new Body[numBodies];
        bodies[0] = new Body(new Vector(new double[2]), new Vector(new double[2]), BIGGEST_MASS);
        for (int i = 1; i < numBodies; i++) {
            double angle = (2 * (Math.random()-0.5))*Math.PI;
            double rho = (radius/4)*(Math.random() +1);
            double rx = Math.cos(angle)*rho;
            double ry = Math.sin(angle)*rho;
            double vx = -ry/1000. + MIN_VELOCITY + 2 * (Math.random() - 0.5) * (MAX_VELOCITY - MIN_VELOCITY);
            double vy = rx/1000. + MIN_VELOCITY + 2 * (Math.random() - 0.5) * (MAX_VELOCITY - MIN_VELOCITY);
            double mass = MIN_MASS + Math.random() * (MAX_MASS - MIN_MASS);
            double[] velocity = {vx,vy};
            double[] position = {rx, ry};
            Vector r = new Vector(position);
            Vector v = new Vector(velocity);
            bodies[i] = new Body(r, v, mass);

        }
    }
}
