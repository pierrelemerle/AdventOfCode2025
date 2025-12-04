
public class Day04Util {

    public static int numberRolls(char[][] tabTabChar) {
        int nbRolls=0;
        for (int i=0;i<tabTabChar.length;i++) {
            for (int j=0;j<tabTabChar[i].length;j++) {
                if (tabTabChar[i][j]=='@'){
                    if (rollIsFree(i, j, tabTabChar)) {
                        nbRolls++;
                    }
                }
            }
        }
        return nbRolls;
    }

    public static int removeRolls(char[][] tabTabChar) {
        int nbRolls=0;
        for (int i=0;i<tabTabChar.length;i++) {
            for (int j=0;j<tabTabChar[i].length;j++) {
                if (tabTabChar[i][j]=='@'){
                    if (rollIsFree(i, j, tabTabChar)) {
                        nbRolls++;
                        tabTabChar[i][j]='.';
                    }
                }
            }
        }
        return nbRolls;
    }

    private static boolean rollIsFree(int i, int j, char[][] tabTabChar) {
        int nbRollsaround=0;
        if (i>=1 && j>=1 && tabTabChar[i-1][j-1]=='@'){
                nbRollsaround++;
        }
        if (i>=1 && tabTabChar[i-1][j]=='@'){
                nbRollsaround++;
        }
        if (i>=1 && (j+1)<tabTabChar[i].length && tabTabChar[i-1][j+1]=='@'){
                nbRollsaround++;
        }
        if (j>=1 && tabTabChar[i][j-1]=='@'){
                nbRollsaround++;
        }
        if ((j+1)<tabTabChar[i].length && tabTabChar[i][j+1]=='@'){
                nbRollsaround++;
        }
        if ((i+1)<tabTabChar.length && j>=1 && tabTabChar[i+1][j-1]=='@'){
                nbRollsaround++;
        }
        if ((i+1)<tabTabChar.length && tabTabChar[i+1][j]=='@'){
                nbRollsaround++;
        }
        if ((i+1)<tabTabChar.length && (j+1)<tabTabChar[i].length && tabTabChar[i+1][j+1]=='@'){
                nbRollsaround++;
        }
        if (nbRollsaround<4)
            return true;
        else
            return false;
    }

}


