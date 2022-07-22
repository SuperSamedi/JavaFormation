package brussels.digitalcity.tu.exo.triangle;

public class DrawTriangleProgram {
    public static void main(String[] args) {
        drawTriangle(1,1,1);
    }

    private static void drawTriangle(int sideA, int sideB, int sideC) {
        int b; // Base (largest side)
        double A; // Area
        double h; // Height
        double s; // Semi-peimeter
        double d; // First half of the base (cut by the height)
        double e; // Second half

        b = sideB;
        int a = sideA;
        int c = sideC;

        if (sideA > b) {
            b = sideA;
            a = sideB;
            c = sideC;
        }
        if(sideC > b) {
            b = sideC;
            a = sideA;
            c = sideB;
        }

        s = (sideA + sideB + sideC) * 0.5;
        // Heron's formula
        A = Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
        h = 2 * A / b;

        // base 2 sides (cut by height perpendicular)

        //      +
        //     +|--+
        //  a +-|----+ c
        //   +--| h-----+
        // +----+----------+
        //   d  +    e

        // b = d + e

        // a² = h² + d²
        // a² - h² = d²
        // sqrt(a² - h²) = d
        d = Math.sqrt(Math.pow(a, 2) - Math.pow(h, 2));
        e = b - d;

        // We'll try to draw 10 lines high.
        // h * x = 10
        // x = 10 / h
        int heightLimit = 10;
        double scaleFactor = heightLimit / h;
        d *= scaleFactor; // first part of base
        e *= scaleFactor; // second part of base

        String sign = "000";
        String emptySpace = "...";
        StringBuilder sb = new StringBuilder();
        int lineCount = 0;
        String lineStart = "\n";

        // Each line.
        for (int i = heightLimit; i > 0; i--) {
            sb.append(lineStart).append(lineCount).append(" ");

            // Each char space of the line
            for (int j = 0; j < Math.round(d + e) + 1; j++) {
                // Before height line. (compare to d)
                if (j == Math.round(d / heightLimit) * i){
                    sb.append(sign);
                }
                else {
                    sb.append(emptySpace);
                }
                // After height line. (compare to e)
            }

            lineCount++;
        }

        System.out.println(sb);
    }
}
