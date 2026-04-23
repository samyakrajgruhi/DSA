import java.util.Arrays;

public class AssignCookies {
    public static int findContentChildren(int[] g, int[] s) {
        int count = 0;
        int gleft = g.length - 1;
        int sleft = s.length - 1;

        Arrays.sort(g);
        Arrays.sort(s);

        while (gleft >= 0 && sleft >= 0) {
            if (s[sleft] >= g[gleft]) {
                sleft--;
                count++;
            }
            gleft--;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};

        System.out.println(findContentChildren(g, s));
    }
}
