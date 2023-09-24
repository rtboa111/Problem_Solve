package Problem_Solve;

import java.io.*;
import java.util.*;

public class _17387 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        double x1, y1, x2, y2, xx1, yy1, xx2, yy2;
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        xx1 = Integer.parseInt(st.nextToken());
        yy1 = Integer.parseInt(st.nextToken());
        xx2 = Integer.parseInt(st.nextToken());
        yy2 = Integer.parseInt(st.nextToken());
        double dx1, dx2, dy1, dy2, a1, a2, b1, b2;
        dx1 = x1 - x2;
        dy1 = y1 - y2;
        dx2 = xx1 - xx2;
        dy2 = yy1 - yy2;
        double INF = 1<<30;
        a1 = INF; a2 = INF;
        b1 = 0; b2 = 0;

        if (dx1 != 0) {
            if (dy1 != 0) {
                a1 = dy1 / dx1;
            } else {
                a1 = 0;
            }
            b1 = y1 - a1*x1;
        }
        if (dx2 != 0) {
            if (dy2 != 0) {
                a2 = dy2 / dx2;
            } else {
                a2 = 0;
            }
            b2 = yy1 - a2*xx1;
        }

        boolean flag = false;
        if (a1 == a2) {
            if (b1 == b2) {
                if (a1 == INF) {
                    if (x1 == xx1) {
                        flag = (obs(y1, y2, yy1)) || (obs(y1, y2, yy2)) ||
                                (obs(yy1, yy2, y1)) || (obs(yy1, yy2, y2));
                    }
                } else {
                    if (a1 == 0) {
                        flag = (obs(x1, x2, xx1)) || (obs(x1, x2, xx2)) ||
                                (obs(xx1, xx2, x1)) || (obs(xx1, xx2, x2));
                    } else {
                        flag = (obs(y1, y2, yy1)) || (obs(y1, y2, yy2)) ||
                                (obs(yy1, yy2, y1)) || (obs(yy1, yy2, y2));
                    }
                }
            }

        } else if (a1 == INF) {
            double y = a2*x1 + b2;
            flag = obs(y1, y2, y) && obs(xx1, xx2, x1);

        } else if (a2 == INF) {
            double y = a1*xx1 + b1;
            flag = obs(yy1, yy2, y) && obs(x1, x2, xx1);

        } else {
            float x = (float) ((b1 - b2) / (a2 - a1));
            float y = (float) (x * a1 + b1);
            flag = obs(x1, x2, x) && obs(xx1, xx2, x) &&
                    obs(y1, y2, y) && obs(yy1, yy2, y);
        }

        if (flag) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
    static boolean obs(double a1, double a2, double t) {
        return (Math.min(a1, a2) <= t && t <= Math.max(a1, a2));
    }
}