public class Main {
    public static void main(String[] args) {

        String typeUniverse = args[3];
        double dt = Double.parseDouble(args[0]);
        int pauseTime = Integer.parseInt(args[1]);
        boolean trace = args[2].toLowerCase().equals("trace");
        int numargs = args.length;
        Universe universe;


        if (typeUniverse.equals("generic")) {
            assert numargs == 5 : "Invalid number of arguments";
            String fname = args[4];
            universe = new GenericUniverse(fname);

        } else if (typeUniverse.equals("central_configuration")) {
            int n = Integer.parseInt(args[4]);
            assert numargs == 5 : "Invalid number of arguments";
            universe = new CentralConfiguration(n);
            //NBodySimulator simulator = new NBodySimulator(universe, dt, pauseTime, trace);
            //simulator.simulate();

        } else {
            assert numargs == 5 : "Invalid number of arguments";
            int n = Integer.parseInt(args[4]);
            universe = new Nplus1(n);
        }

        NBodySimulator simulator = new NBodySimulator(universe, dt, pauseTime, trace);
        simulator.simulate();

    }
}
