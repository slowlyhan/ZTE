package com.zte.hy;

import java.util.HashMap;

/**
 * 判断是否是必经路径的结点
 * @author hy
 *
 */
public class judeRoadAndNode {
	/**
	 * 判断此结点是否为路径的开始结点
	 * @param g
	 * @param currentNode
	 * @param road1
	 * @param road2
	 * @param node
	 * @param path
	 * @param visited
	 * @param dist
	 * @return
	 */
	public static boolean jude( Graph g,int currentNode,int[] road1,int[] road2,int[] node,HashMap<Integer,Integer> path,boolean[] visited,int[] dist){
		//判断是否为必经路径的节点
				if(currentNode==road1[0]){
					visited[road1[1]]=true;
					path.put(road1[1], currentNode);
					dist[road1[1]] = dist[road1[0]]+g.matrix[road1[0]][road1[1]];
					currentNode = road1[1];
					return true;
				}
				else if(currentNode==road1[1]){
					visited[road1[0]]=true;
					path.put(road1[0], currentNode);
					dist[road1[0]] = dist[road1[1]]+g.matrix[road1[0]][road1[1]];
					currentNode = road1[0];
					return true;
				}
				else if(currentNode==road2[0]){
					visited[road2[1]]=true;
					path.put(road2[1], currentNode);
					dist[road2[1]] = dist[road2[0]]+g.matrix[road2[0]][road2[1]];
					currentNode = road2[1];
					return true;
				}
				else if(currentNode==road2[1]){
					visited[road2[0]]=true;
					path.put(road2[0], currentNode);
					dist[road2[0]] = dist[road2[1]]+g.matrix[road2[0]][road2[1]];
					currentNode = road2[0];
					return true;
				}
		return false;
	}
}
