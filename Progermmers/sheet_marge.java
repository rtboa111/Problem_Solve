package Problem_Solve.Progermmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
class Node {
    String val;
    int[] coords;
    Node next, prev;

    public Node(String val, int[] coords) {
        this.val = val;
        this.coords = coords;
        this.next = this.prev = null;
    }
    public Node(int[] coords) {
        this.val = null;
        this.coords = coords;
        this.next = this.prev = null;
    }

}

public class seet_marge {
    static HashMap<String, ArrayList<Integer>[]> index;
    static Node[][] seet;

    public String[] solution(String[] commands) {

        seet = new Node[51][51];
        index = new HashMap<>(50*50);

        for(int i = 0; i < 50; i++) {
            for(int j = 0; j < 50; j++) {
                Node x = new Node(new int[]{i, j});
                seet[i][j] = x;
            }
        }

        for(String s : commands) {
            String[] cur = s.split(" ");

            switch (cur[0].charAt(3)){
                case 'A':
                    update(cur);
                case 'G':
                case 'E':
                case 'N':
            }
        }

        return answer;

    }
    /**
     @param val1     지울 index의 키값
     @param val2     더할 index의 키값
     @param target   val1에서 지워지고 val2에 추가됨
     **/
    static void index_currection(String val1, String val2, int[] target) {

        ArrayList<Integer> coords = index.remove(val1);

        int idx = 0;
        for(int i = 0; i < coords.size(); i+=2) {
            if(coords[i] != target[0] || coords[i+1] != target[1]) {
                coords[idx++] = coords[i];
                coords[idx++] = coords[i+1];
            }
        }
        // index에 있는 val1의 target 좌표 삭제
        index.put(val1, Arrays.copyOf(coords, idx));

        coords = index.remove(val2);

        coords = Arrays.copyOf(coords, coords.length+2);
        coords[coords.length-2] = target[0];
        coords[coords.length-1] = target[1];
        // index에 있는 val2의 target 좌표 추가
        index.put(val2, coords)
    }

    static void update(String[] cur) {
        if(cur.length == 3) {
            // val1을 키로하는 index 삭제
            int[] coords = index.remove(cur[1]);
            Node x = seet[coords[0]][coords[1]];

            // val1을 키로 하는 좌표들 모두에 대해 val2로 값 변경
            for(int i = 0; i < coord.length; i+=2) {
                Node x = seet[coords[i]][coords[i+1]];
                x.val = cur[3];
            }
            // val2를 키로 하는 index 생성
            index.put(cur[3], coords);

        } else {
            int[] coords = new int[]{Integer.parseInt(cur[1]), Integer.parseInt(cur[2])};
            Node x = seet[coords[0]][coords[1]];
            // 연결된 첫 노드부터
            while(x.prev != null) {
                x = x.prev;
            }
            // 연결된 마지막 노드까지 val바꾸고 해당 val의 index를 수정
            // (병합되어 있는 셀들 모두의 val을 교체)
            while(x.next != null) {
                index_currection(x.val, cur[3], x.get(x.val));
                x.val = cur[3];
                x = x.next;
            }
        }

    }
    static void marge(String[] cur) {
        int r1 = Integer.parseInt(cur[0]);
        int c1 = Integer.parseInt(cur[1]);
        int r2 = Integer.parseInt(cur[2]);
        int c2 = Integer.parseInt(cur[3]);

        if(seet[r1][c1] != null) {
            Node x = seet[r1][c1];
            String val = x.val;
            ArrayList<Integer> temp = new ArrayList<>();
            if(val != null) {
                while(x.prev != null) {
                    x = x.prev;
                }

                // 마지막 노드에 연결 추가하기 위함
                while(x.next != null) {
                    temp.add(x.coords[0]);
                    temp.add(x.coords[1]);
                    x = x.next;
                }

                Node y = seet[r2][c2];
                if(y.val != null){  // index 변경 필요
                    while(y.prev != null) {
                        y = y.prev;
                    }
                    while(y.next != null) {
                        temp.add(y.coords[0]);
                        temp.add(y.coords[1]);
                        y = y.next;
                    }
                }


                y.val = val;
                y.prev = x;
                x.next = y;


                index.put(val, NC);


            } else if(seet[r2][c2] != null) {
                Node x = seet[r2][c2];
                String val = x.val;

                while(x.next != null) {
                    x = x.next;
                }

                Node y = new Node(val, new int[]{r1, c1});
                x.next = y;
                y.prev = x;
            } else {
                Node x = new Node()

            }
        }
    }
    static void unmarge(String[] cur) {

    }
    static String print(String[] cur) {

    }
}