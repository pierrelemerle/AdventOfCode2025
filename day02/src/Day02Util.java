public class Day02Util {

    public static long iterateAllIdsPart1(long startId, long endId) {
        long wrongIds = 0;
        for (long id = startId; id <= endId; id++) {
            if (Day02Util.isIdValidPart1(id)) {
                wrongIds+=id;
            }
        }
        return wrongIds;
    }
    
    public static long iterateAllIdsPart2(long startId, long endId) {
        long wrongIds = 0;
        for (long id = startId; id <= endId; id++) {
            if (Day02Util.isIdValidPart2(Long.toString(id))) {
                wrongIds+=id;
            }
        }
        return wrongIds;
    }

    private static boolean isIdValidPart1(long id) {
        int length = numberOfDigits(id);
        if ((length % 2 )!= 0) {
            return false;
        }
        else {
            for (int i = 0; i < length / 2; i++) {
                long firstDigit = (long) (id / Math.pow(10, length/2+i)) % 10;
                long secondDigit = (long) (id / Math.pow(10, i)) % 10;
                if (firstDigit != secondDigit) {
                    return false;
                }
            }
        }
        // System.out.println("Valid ID: " + id);
        return true;
    }

    private static boolean isIdValidPart2(String id) {
        int length = id.length();
        for (int i=1; i<= length/2 ;i++){
            if ((length % i) ==0){
                boolean isValid = true;
                for (int j=0; j<length-i;j+=i){
                    String firstBloc =  id.substring(j, j+i);
                    String secondBloc = id.substring(j+i, j+i+i);
                    if (!firstBloc.equals(secondBloc)) {
                        isValid = false;
                    }
                }
                if (isValid){
                    return true;
                }
            }
        }    
        return false;
    }    

    private static int numberOfDigits(long id) {
        return String.valueOf(Math.abs(id)).length();
    }

}


