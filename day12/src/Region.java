public class Region {
    private int width;
    private int height;
    private int[] presents;

    public Region(int width, int height, int[] presents) {
        this.width = width;
        this.height = height;
        this.presents = presents;
    }           

    public int getWidth() {
        return width;
    }   
    public int getHeight() {
        return height;
    }   
    public int[] getPresents() {
        return presents;
    }   
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Region (").append(width).append("x").append(height).append(") with presents: ");
        for (int i = 0; i < presents.length; i++) {
            sb.append(presents[i]);
            if (i < presents.length - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }   

}
