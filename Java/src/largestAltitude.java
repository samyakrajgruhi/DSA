import java.util.Arrays;

public class largestAltitude {
    public static int largestAltitude(int[] gain){
        int[] altitudes = new int[gain.length + 1];
        int highest = 0;
        altitudes[0] = 0;

        for(int i=0;i<gain.length;i++){
            int gained = gain[i] + altitudes[i];
            if(highest < gained){
                highest = gained;
            }
            altitudes[i+1] = gained;
            System.out.println(Arrays.toString(altitudes));
        }


        return highest;
    }

    public static void main(String[] args){
        int[] gains = {52,-91,72};
        System.out.println(largestAltitude(gains));
    }
}
