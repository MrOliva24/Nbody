public class NBodySimulator {

    //Private atributes of the design
    private Universe universe;
    private double timeStep;
    private int pauseTime;
    private boolean trace;


    public NBodySimulator(Universe universe, double dt, int pt, boolean doTrace) {

        this.universe = universe;
        timeStep = dt;
        pauseTime = pt;
        trace = doTrace;

    }

    @SuppressWarnings("InfiniteLoopStatement") //Evitar el warning que salta por el while infinito
    public void simulate() {
        createCanvas();
        while (true) {
            if (trace) {
                StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                drawUniverse();
            } else {
                StdDraw.clear(StdDraw.BLACK);
            }
            StdDraw.setPenColor(StdDraw.WHITE);
            universe.update(timeStep);
            drawUniverse();
            StdDraw.show();
            StdDraw.pause(pauseTime);
        }
    }

    private void createCanvas() {
        StdDraw.setCanvasSize(1000, 900);
        StdDraw.enableDoubleBuffering();
        double radius = universe.getRadius();
        StdDraw.setXscale(-radius, +radius);
        StdDraw.setYscale(-radius, +radius);
        StdDraw.clear(StdDraw.BLACK);
    }

    private void drawUniverse() {
        Vector[] positions = universe.getAllPositions();
        StdDraw.setPenRadius(0.01);
        for (int i = 0; i < universe.getNumBodies(); i++) {
            StdDraw.point(positions[i].cartesian(0), positions[i].cartesian(1));
        }
    }

}
