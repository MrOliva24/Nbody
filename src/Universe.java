
abstract class Universe {

    //Private attributes of the design
    protected double radius;
    protected int numBodies;


    public Body[] bodies;

    void update(double dt) {

        //Inici de forces a 0
        Vector[] f = new Vector[numBodies];
        for (int i = 0; i < numBodies; i++) {
            f[i] = new Vector(new double[2]);
        }

        //Calcul de les forces que fa cada cos sobre els altres
        for (int i = 0; i < numBodies; i++) {
            for (int j = 0; j < numBodies; j++) {
                if (i != j) { //Condicio per evitar calcular la força que es fa un cos sobre ell mateix
                    f[i] = f[i].plus(bodies[i].forceFrom(bodies[j]));
                }
            }
        }

        //Moviment dels cossos en funcio del temps
        for (int i = 0; i < numBodies; i++) {
            bodies[i].move(f[i], dt);
        }
    }

    public double getRadius() {
        return radius;
    }

    public Vector[] getAllPositions() {
        Vector[] positions = new Vector[numBodies];
        for (int i = 0; i < numBodies; i++) {
            positions[i] = bodies[i].getPosition();
        }
        return positions;
    }

    public int getNumBodies() {
        return numBodies;
    }
}
