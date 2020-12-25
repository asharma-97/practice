package codes.java;

public class MinFlips {
    public int minFlips(String target) {
        int flips = 0;
        char status = '0';
        for(int i = 0; i < target.length(); i++) {
            if(status != target.charAt(i)) {
                flips++;
                status = (status == '0') ? '1' : '0';
            }
        }
        return flips;
    }
}
