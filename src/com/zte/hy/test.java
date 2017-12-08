package com.zte.hy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 测试
 * @author hy
 *
 */
public class test {

	public static void main(String[] args) {
		int n=18;
		int e=41; 
		int source=0;//起点
		int finallyDest=17;
		int[] road1={2,4};//
		int[] road2={13,14};
		int[] node={7,12};
		int[] anteater={11,12};
		Scanner scall = null;
		try {
			//添加限制条件
			scall = new Scanner(new File("Limitations.txt"));
			n = Integer.parseInt(scall.nextLine());
			source = Integer.parseInt(scall.nextLine());
			finallyDest = Integer.parseInt(scall.nextLine());
			
				 String str = scall.nextLine();
				 String[] b = str.split(",");
				 road1[0] = Integer.parseInt(b[0]);
				 road1[1] = Integer.parseInt(b[1]);
				 
			     str = scall.nextLine();
				 b = str.split(",");
				 road2[0] = Integer.parseInt(b[0]);
				 road2[1] = Integer.parseInt(b[1]);
				 
				 str = scall.nextLine();
				 b = str.split(",");
				 node[0] = Integer.parseInt(b[0]);
				 node[1] = Integer.parseInt(b[1]);
				 
				 str = scall.nextLine();
				 b = str.split(",");
				 anteater[0] = Integer.parseInt(b[0]);
				 anteater[1] = Integer.parseInt(b[1]);
				
			
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Graph g = new Graph(n);
		
		g.n=n;
		g.e=e;
		
		if(e!=0)
		{
			//创建图
			
			int s,t,w;      //表示存在一条边s->t,权值为w
			
			try {
				scall = new Scanner(new File("Graph.txt"));
				 while(scall.hasNextLine()){
					 String str = scall.nextLine();
					 String[] b = str.split(",");
					 s = Integer.parseInt(b[0]);
					 t = Integer.parseInt(b[1]);
					 w = Integer.parseInt(b[2]);
					 g.matrix[s][t] = w;
				 }
				 
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{
				scall.close();
			}
			
			ShortestPath.findPath(g, road1, road2, node, source, finallyDest, anteater);
			
		}
	}
}
