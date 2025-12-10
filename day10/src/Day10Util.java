import java.util.ArrayList;
import java.util.List;

public class Day10Util {
    
    private static boolean[] pressButton(List<List<Integer>> buttons, boolean[] currentLights) {
        for (List<Integer> button : buttons) {
            for (int position : button) {
                currentLights[position] = !currentLights[position];
            }
        }
        return currentLights;
    }

    private static boolean areLigthsEqual(boolean[] lights1, boolean[] lights2) {
        if (lights1.length != lights2.length) {
            return false;
        }
        for (int i = 0; i < lights1.length; i++) {
            if (lights1[i] != lights2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int resolveMachine (Machine machine){ 
        boolean[] lights = machine.getLights();
        List<List<Integer>> buttons = machine.getButtons();
        int nButtons = buttons.size();

        for (int size = 1; size <= nButtons; size++) {

            int[] indices = new int[size];

            // Initialize indices for the first combination
            for (int i = 0; i < size; i++) {
                indices[i] = i;
            }

            while (true) {

                // Call the specified function with the current combination
                List<List<Integer>> setButtons = new ArrayList<>();
                int counter=0;
                for (int index : indices) {
                    setButtons.add(buttons.get(index));
                    counter++;
                }
                boolean[] startingLights = new boolean[lights.length];
                for (int x=0;x<lights.length;x++){
                    startingLights[x] = false; 
                }
                if (areLigthsEqual (lights, pressButton(setButtons, startingLights))) {
                    return counter;
                }


                // Find the rightmost index that can be incremented
                int i;
                for (i = size - 1; i >= 0; i--) {
                    if (indices[i] < nButtons - 1 - (size - 1 - i)) {
                        break;
                    }
                }

                // If no such index is found, we are done
                if (i < 0) {
                    break;
                }

                // Increment the current index
                indices[i]++;
                // Update the rest of the indices
                for (int j = i + 1; j < size; j++) {
                    indices[j] = indices[j - 1] + 1;
                }
            }

        }
        return 0; 
    }

}

