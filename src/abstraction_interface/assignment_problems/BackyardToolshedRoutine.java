package abstraction_interface.assignment_problems;

public class BackyardToolshedRoutine {

    static abstract class GardenTool {

        public GardenTool() {
        }

        public abstract String use();
    }

    static class CuttingTool extends GardenTool {

        public CuttingTool() {
            super();
        }

        @Override
        public String use() {
            return superUse() + ", blade sharpened first";
        }

        private String superUse() {
            return "Using the tool in the garden";
        }
    }

    static class Pruner extends CuttingTool {

        public Pruner() {
            super();
        }

        @Override
        public String use() {
            return super.use() + ", then trimming branches precisely";
        }
    }

    public static void main(String[] args) {

        CuttingTool c = new CuttingTool();
        Pruner p = new Pruner();

        System.out.println(c.use());
        System.out.println(p.use());
    }
}