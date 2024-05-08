package test.algorithm;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mirror {

    static int n, answer ; // n: 입력받은 행렬의 크기 , answer : 거울에 부딪힌 횟수
    static int[][] matrix;

    public static void main(String[] args) throws FileNotFoundException{
        
        Scanner scanner = new Scanner(new FileInputStream("mirror.txt"));
        // 테스트 케이스 횟수
        int t = scanner.nextInt();
        
        for (int m = 0; m < t; m++) {
            // 행렬 크기 
            n = scanner.nextInt();
            // 행렬 생성
            matrix = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }   
            }
            visit(0, 0, 0);
            System.out.println(m+1+"번 결과 : "+answer);
            answer=0;
        }
    }

    // direction (0 : 오른, 1 : 아래, 2:왼쪽, 3: 위)
    // 반환 조건을 제일 처음 확인해야 함
    public static void visit(int i, int j, int direction){
        // 행렬을 벗어나면 반환
        if (i<0 || j<0 || i>=n||j>=n) return;
        
        // 현재 위치의 값을 확인하고,  방향(direction)도 확인해야 함
        if (matrix[i][j]==1) { // 방향 1 거울에 부딪힘
            answer+=1;
            if      (direction==0) direction=3 ; // 오른쪽 방향에서 오고 있었으므로 위로 감
            else if (direction==1) direction=2;
            else if (direction==2) direction=1;
            else if (direction==3) direction=0;    
        }else if (matrix[i][j]==2) { // 방향 2 거울에 부딪힘
            answer+=1;
            if      (direction==0) direction=1; // 오른쪽 방향에서 오고 있었으므로 아래로 감
            else if (direction==1) direction=0;
            else if (direction==2) direction=3;
            else if (direction==3) direction=2;
        }

        // 직진 방향이 결정되었으므로 i나 j를 수정한 후에 visit() 재호출
        if (direction == 0) visit(i,++j,direction);
        else if (direction == 1) visit(++i,j,direction);
        else if (direction == 2) visit(i,--j,direction);
        else if (direction == 3) visit(--i,j,direction);
    }



    // direction (0 : 오른, 1 : 위, 2: 아래, 3: 왼쪽)
    // 반환 조건을 제일 처음 확인해야 함
    // public static void visit(int i, int j, int direction){
    //     // 행렬을 벗어나면 반환
    //     if (i<0 || j<0 || i>=n||j>=n) return;

    //     if (direction==0) {
    //         if (j==9) {
    //             return;
    //         }
    //         ++j;
    //         if (matrix[i][j]==1) visit(i, j, 1); // 오른쪽으로 가다가 방향1을 만나면 위로
    //         else if (matrix[i][j]==2) visit(i, j, 2); // 오른쪽으로 가다가 방향 2를 만나면 아래로
    //         else visit(i, j, 0);
    //     }
    //     if (direction==1) {
    //         answer+=1;
    //         if (i==0) {
    //             return;
    //         }
    //         --i;
    //         if (matrix[i][j] == 1)
    //             visit(i, j, 0); // 위로 가다가 방향 1을 만나면 오른쪽으로
    //         else if (matrix[i][j] == 2)
    //             visit(i, j, 3); // 위로 가다가 방향 2를 만나면 왼쪽으로
    //         else visit(i, j, 1);
    //     }
    //     if (direction==2) {
    //         answer+=1;
    //         if (i==9) {
    //             return;
    //         }
    //         ++i;
    //         if (matrix[i][j] == 1)
    //             visit(i, j, 3); // 아래로 가다가 방향 1을 만나면 왼쪽으로
    //         else if (matrix[i][j] == 2)
    //             visit(i, j, 0); // 아래로 가다가 방향 2를 만나면 오른쪽으로
    //         else
    //             visit(i, j, 2);
    //     }else{
    //         if (j==0) {
    //             return;
    //         }
    //         --j;
    //         if (matrix[i][j] == 1)
    //             visit(i, j, 2); // 왼쪽으로 가다가 방향 1을 만나면 아래로
    //         else if (matrix[i][j] == 2)
    //             visit(i, j, 1); // 왼쪽로 가다가 방향 2를 만나면 위로
    //         else
    //             visit(i, j, 3);
    //     }
    // }    


}
