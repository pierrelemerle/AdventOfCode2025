import java.util.List;

class Machine {
    boolean[] lights;
    List<List<Integer>> buttons;
    List<Integer> voltage; 
    int resolution;
    int nButtons;

    public Machine(boolean[] lights, List<List<Integer>> buttons, List<Integer> voltage) {
        this.lights = lights;
        this.buttons = buttons;
        this.voltage = voltage;
        this.nButtons = buttons.size();
        this.resolution = 0;
    }
    public boolean[] getLights() {
        return lights;
    }
    public List<List<Integer>> getButtons() {
        return buttons;     
    }
    public List<Integer> getVoltage() {
        return voltage;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lights: [");
        for (boolean light : lights) {
            sb.append(light ? "#" : ".");
        }
        sb.append("]\nButtons:\n");
        for (List<Integer> button : buttons) {
            sb.append(button.toString()).append("\n");
        }
        sb.append("Voltage: ").append(voltage.toString()).append("\n");
        return sb.toString();
    }   

}