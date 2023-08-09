package Ch03_2차원배열.삼각달팽이;
//삼각달팽이_level2
public class Main {
    public static int[] solution(int n) {

        int[][] arr = new int[n][n];
        int total = n%2==0 ? (n+1)*(n/2) : (n+1)*(n/2) + (n/2+1); // 끝번호
        System.out.println("total : " + total);

        int[] answer = new int[total];

        int start = 1; //시작값_1부터 시작
        int dir = 0; //0:아래, 1:오른쪽, 2:위
        int x = 0; int y = 0; //2차원배열 초기 시작 값

        while(start<=total) { //1부터 시작해서 끝번호가 나오면 종료

            //처음에는 아래로 이동
            if(dir == 0) {
                if(arr[x][y] == 0 && x < n) {
                    arr[x][y] = start;
                    x++;
                    start++;
                }
                if(x==n || arr[x][y] != 0) {
                    x--;
                    y++;
                    dir = 1;//오른쪽 방향 전환
                }
            }

            //위에서 오른쪽방향으로 전환
            else if(dir == 1) {
                if(arr[x][y] == 0 && y<n) {
                    arr[x][y++] = start;
                    start++;
                }
                if(y==n || arr[x][y] != 0) {
                    dir=2; //위로 방향전환
                    y-=2;
                    x--;
                }
            }

            //이후 다시 위로 이동
            else if(dir == 2) {
                if(arr[x][y] == 0 && x>=0) {
                    arr[x--][y--] = start;
                    start++;
                }
                if(arr[x][y] != 0 || x==-1) {
                    dir=0;
                    x+=2;
                    y++;
                }
            }
            //아래 -> 오른족 -> 위과정을 반복해서 끝번호까지 저장하고 종료
        }

        int num=0;
        for(int i=0; i<n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[num++]=arr[i][j];
            }
        }
        return answer;
    }
}
