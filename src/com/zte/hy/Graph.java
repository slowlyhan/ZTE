package com.zte.hy;

/**
 * 图结构
 * @author hy
 *
 */
public class Graph {
	int n;  //顶点个数              
	int e; //边条数
	int[][] matrix;//图矩阵
	public Graph(int n){
		this.n = n;
	    matrix = new int[n][n]; 
	}
	 
	
}
