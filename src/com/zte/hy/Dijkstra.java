package com.zte.hy;

import java.util.HashMap;
import java.util.Stack;

/**
 * 改进的Dijkstra,用于计算单源最短路径
 * @author hy
 *
 */
public class Dijkstra {

	/**
	 * 
	 * @param g 图数据结构
	 * @param dist 用于记录各个节点到源点的最短距离
	 * @param path 用于记录各个节点距离源点的最短距离
	 * @param road1 必经路径1 road1[0],road1[1]
	 * @param road2 必经路径2 road2[0],road2[1]
	 * @param node 必经结点 node[0] node[1]
	 * @param source 源点
	 * @param visited 用于记录结点是否访问过
	 */
	public void doDijkstra(Graph g,int[] dist,HashMap<Integer,Integer> path,int[] road1,int[] road2,int[] node,int source,boolean[] visited){
		int i,j,k;
		//boolean[] visited = new boolean[100];
		int INT_MAX = Integer.MAX_VALUE;
		for(i=0;i<g.n;i++)     //初始化 
		{
			if(g.matrix[source][i]>0&&i!=source)
			{
				dist[i]=g.matrix[source][i];    
				path.put(i, source);//path记录最短路径上从v0到i的前一个顶点 
			}
			else
			{
				dist[i]=INT_MAX;    //若i不与v0直接相邻，则权值置为无穷大 
				path.put(i,-1);
			}
			visited[i]=false;
			path.put(source, source);
			dist[source]=0;
		}
		visited[source]=true;
		//判断是否为必经路径或必经点
		if(judeRoadAndNode.jude(g,source, road1, road2, node, path, visited,dist)) i++;
		for(i=1;i<g.n;i++)     //循环扩展n-1次 
		{
			int min=INT_MAX;
			int u=-1;
			for(j=0;j<g.n;j++)    //寻找未被扩展的权值最小的顶点 
			{
				if(visited[j]==false&&dist[j]<min)
				{
					min=dist[j];
					u=j;        
				}
			} 
			if(u!=-1)
			visited[u]=true;
			//判断是否为必经路径或必经点
			if(judeRoadAndNode.jude(g,u, road1, road2, node, path, visited,dist)) i++;
			for(k=0;k<g.n;k++)   //更新dist数组的值和路径的值 
			{
				if(visited[k]==false&&g.matrix[u][k]>0&&min+g.matrix[u][k]<dist[k])
				{
					dist[k]=min+g.matrix[u][k];
					path.put(k, u);
				}
			}        
		}    
		
	}
	
	
	
	/**
	 * 
	 * @param path 记录最短路径
	 * @param dest 目的结点
	 * @param source 源点
	 * @param s 记录目的结点到源结点的栈
	 */
	public void showPath(HashMap<Integer,Integer> path,int dest,int source,Stack<Integer> s)   //打印最短路径上的各个顶点 
	{
		int u=dest;
		while(u!=source)
		{
			s.push(u);
			u = path.get(u);
		}
		s.push(source);
		/* for (Integer x : s) { 
			 if(x!=dest)
				System.out.print(x+"-->");
			 else
				System.out.println(x); 
		 } */
	
	}
	
	
}
