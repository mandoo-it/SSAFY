package 파이팅;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 상호야성공하자 {
	static int[] diry = {-1,1,0,0};//상 하 좌 우
	static int[] dirx = {0,0,-1,1};
	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		//상호야 이것만은 풀자 
		System.setIn(new FileInputStream("res/상호.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			int height = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			char[][] map = new char[height][width];
			//
			int cha_y = 0;
			int cha_x = 0;
			int d = 0;
			for(int i=0;i<height;i++) {
				String s = br.readLine();
				for(int j=0;j<width;j++) {
					map[i][j] = s.charAt(j);
					if(map[i][j] == '^' || map[i][j] == '<' || map[i][j] == '>' || map[i][j] == 'v') {
						cha_y = i;
						cha_x = j;
						switch(map[i][j]) {
							case '^': d = 0;break; 
							case 'v': d = 1;break; 
							case '<': d = 2;break; 
							case '>': d = 3;break; 
							
							
						}
					}
				}	
			}
			//System.out.println(cha_y + "d" + cha_x);
			
			int command = Integer.parseInt(br.readLine());
			char[] com_arr = new char[command];
			com_arr = br.readLine().toCharArray();
			for(int c=0;c<command;c++) {
				if(com_arr[c] == 'U') { //상
					d = 0;
					map[cha_y][cha_x] = '^';
					int ny = cha_y;
					int nx = cha_x;
					
					ny = ny + diry[0]; 
					nx = cha_x;
					if(ny >= 0 && map[ny][nx] == '.' ) {
						map[cha_y][cha_x] = '.';
						cha_y = ny;
						map[cha_y][cha_x] = '^';
					}
					
				}
				else if(com_arr[c] == 'D') {//하
					d = 1;
					map[cha_y][cha_x] = 'v';
					int ny = cha_y;
					int nx = cha_x;
					
					ny = ny + diry[1];
					nx = cha_x;
					if(ny < height && map[ny][nx] == '.') {
						map[cha_y][cha_x] = '.';
						cha_y = ny;
						map[cha_y][cha_x] = 'v';
					}				
				}
				else if(com_arr[c] == 'L') { //좌
					d = 2;
					map[cha_y][cha_x] = '<';
					int ny = cha_y;
					int nx = cha_x;
					ny = cha_y;
					nx = nx+ dirx[2];
					if(nx >= 0 && map[ny][nx] == '.'  ) {
						map[cha_y][cha_x] = '.';
						cha_x = nx;
						map[cha_y][cha_x] = '<';
					}
				}
				else if(com_arr[c] == 'R') {
					d = 3;
					//System.out.println(cha_y + "hh " + cha_x);
					map[cha_y][cha_x] = '>';
					int ny = cha_y;
					int nx = cha_x;
					ny = cha_y;
					nx = nx+ dirx[3];
				//	System.out.println(ny + "hh2 " + nx);
					if(nx < width &&  map[ny][nx] == '.' ) {
						map[cha_y][cha_x] = '.';
						cha_x = nx;
						map[cha_y][cha_x] = '>';
					}
				}
				else if(com_arr[c] == 'S') {
					if(d == 0) { // 상
						for(int i=cha_y;i >= 0;i--) {
							if(map[i][cha_x] == '*')
							{	
								map[i][cha_x] = '.';
								break;
							}
							else if(map[i][cha_x] == '#') break;
						}
					} 
					else if(d == 1) {//하
						for(int i=cha_y;i < height;i++) {
							if(map[i][cha_x] == '*') 
							{
								map[i][cha_x] = '.';
								break;
							}
								
							else if(map[i][cha_x] == '#') break;
						}
					}
					else if(d == 2) { //좌
						for(int i=cha_x;i >= 0;i--) {
							if(map[cha_y][i] == '*') 
							{
								map[cha_y][i] = '.';
								break;
							}
							else if(map[cha_y][i] == '#') break;
						}
					}
					else {//우
						for(int i=cha_x;i < width;i++) {
							if(map[cha_y][i] == '*') 
							{
								map[cha_y][i] = '.';
								break;
							}
							else if(map[cha_y][i] == '#') break;
						}
					}
				}
//				
			}
		//	System.out.println(cha_y + " "  + cha_x + " " + d);
			System.out.print("#" + tc + " ");
			for(int i=0;i<height;i++) {
				for(int j=0;j<width;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			
			
		}
		
	
	
	
	}

}
