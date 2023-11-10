
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_B17143_낚시왕_김태희 {

	static class Shark{
		int speed,size,dir;

		public Shark(int speed,int dir, int size) {
			this.size = size;
			this.speed = speed;
			this.dir = dir;
		}
		@Override
		public String toString() {
			return "S[s=" + speed + ",z=" + size + ",d=" + dir + "]";
		}
	}
	static int R,C,M,sum,col;
	static Shark[][] map;
	static final int UP=1,DOWN=2,RIGHT=3,LEFT=4;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sum=col=0;
		map = new Shark[R][C];
		
		int r,c;
		for (int i = 0; i < M; ++i) {
			st = new StringTokenizer(in.readLine(), " ");
			r = Integer.parseInt(st.nextToken())-1;
			c = Integer.parseInt(st.nextToken())-1;
			map[r][c] = new Shark(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		while(col<C) {
			take();
			move();
			++col;
		}
		System.out.println(sum);
	}
	private static void take() {
		for (int i = 0; i < R; ++i) {
			if(map[i][col]!=null) {
				sum += map[i][col].size;
				map[i][col] = null; // 상어사라짐
				break;
			}
		}
	}
	private static void move() {
		Shark curShark;
		int k = 0,s = 0,a = 0,x,y,d;
		Shark[][] temp = new Shark[R][C];
		for (int i = 0; i < R; ++i) {
			for (int j = 0; j < C; ++j) {
				curShark = map[i][j];
				if(curShark==null) continue;
				if(curShark.dir == UP || curShark.dir == DOWN) {
					k = i;
					s = curShark.speed%(2*(R-1));////////////////////////////////////////속도 개선 : 2*R-1번 이동하면 결국 제자리임.
					a = curShark.dir == UP ? -1: 1;						
					while(s-->0) {
						if(k+a<0 || k+a>=R) a = -a;// 다음이동이 경계를 벗어나면 (격자판 경계인경우 방향 바꾸기)
						k += a;
					}
					x = k;
					y = j;
					d = a<0?UP:DOWN;
				}else {
					k = j;
					s = curShark.speed%(2*(C-1));////////////////////////////////////////속도 개선 : 2*C-1번 이동하면 결국 제자리임.
					a = curShark.dir == LEFT ? -1: 1;						
					while(s-->0) {
						if(k+a<0 || k+a>=C) a = -a;
						k += a;
					}		
					x = i;
					y = k;
					d = a<0?LEFT:RIGHT;
				}
				curShark.dir = d;
				if(temp[x][y]==null) {
					temp[x][y] = curShark;
				}else {
					if(temp[x][y].size<curShark.size) temp[x][y] = curShark; 
				}
			}	
		}
		for(int i=0; i<R; ++i) {
			for(int j=0; j<C; ++j) {
				map[i][j] = temp[i][j];
			}
		}
	}
}
