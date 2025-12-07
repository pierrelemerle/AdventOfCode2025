public class Day07Util {

    public static int resolve (char[][] map) {
        int result = 0;
        int hauteur = map.length;
        int largeur = map[0].length;

        for (int i=0; i<hauteur-1; i++) {
            for (int j=0; j<largeur; j++) {
                if (map[i][j] == '|' || map[i][j] == 'S') {
                    if (map[i+1][j] == '.') {
                        map[i+1][j] = '|';
                    }
                    if (map[i+1][j] == '^') {
                        result += 1;   
                        //check that it is within the range, and a . before changing
                        if (j-1 >= 0 && map[i+1][j-1] == '.') {
                            map[i+1][j-1] = '|';
                        }
                        if (j+1 < largeur && map[i+1][j+1] == '.') {
                            map[i+1][j+1] = '|';
                        }
                    }
                }
            }
        }
        return result;
    }

    public static String[][] convert (char[][] map) {
        String [][] numberGroups = new String[map.length][map[0].length];
        for (int i=0; i<map.length; i++) {
            for (int j=0; j<map[0].length; j++) {
                if (map[i][j] == 'S') {
                    numberGroups[i][j] = "1";
                }
                else{
                    numberGroups[i][j] = String.valueOf(map[i][j]);
    
                }
            }
        }       
        return numberGroups;
    }

    public static String[][] resolveAndCount (String[][] map) {
        int hauteur = map.length;
        int largeur = map[0].length;

        for (int i=0; i<hauteur-1; i++) {
            for (int j=0; j<largeur; j++) {
                if (!map[i][j].equals(".") && !map[i][j].equals("^")) {
                    if (map[i+1][j].equals("^")) {
                        if (j-1 >= 0) {
                            if (map[i+1][j-1].equals(".")) {
                                map[i+1][j-1] = map[i][j];
                            }
                            else {
                                map[i+1][j-1]= Long.toString(Long.parseLong(map[i+1][j-1]) + Long.parseLong(map[i][j]));
                            }
                        }
                        if (j+1 < largeur) {
                            if (map[i+1][j+1].equals(".")) {
                                map[i+1][j+1] = map[i][j];
                            }
                            else {
                                map[i+1][j+1] = Long.toString(Long.parseLong(map[i+1][j+1]) + Long.parseLong(map[i][j]));
                            }
                        }
                    }
                    else {
                        if (map[i+1][j].equals(".")) {
                            map[i+1][j] = map[i][j];
                        }
                        else {
                            map[i+1][j] = Long.toString(Long.parseLong(map[i+1][j]) + Long.parseLong(map[i][j]));
                        }
                    }
                }
            }
        }
        
        return map;
    }   
    
    public static long calculateNbPositions (String[][] map) {
        long result = 0L;
        for (int j=0; j<map[0].length; j++) {
            if (!map[map.length-1][j].equals("."))
                result += Long.parseLong(map[map.length-1][j]);
        }
        return result;
    }


}


