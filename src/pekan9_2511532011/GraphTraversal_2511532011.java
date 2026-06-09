package pekan9_2511532011;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Queue;


public class GraphTraversal_2511532011 {
	private Map<String, List<String>> graph_2011 = new HashMap<>();
	

	public void addEdge_2011(String node1_2011, String node2_2011) {
		graph_2011.putIfAbsent(node1_2011, new ArrayList<>());
		graph_2011.putIfAbsent(node2_2011, new ArrayList<>());
		graph_2011.get(node1_2011).add(node2_2011);
		graph_2011.get(node2_2011).add(node1_2011);
	}
	
	public void printGraph_2011() {
		System.out.println("Graf Awal (Adjacency List):");
		for (String node_2011 : graph_2011.keySet()) {
			System.out.print(node_2011 + " -> ");
			List<String> neighbors_2011 = graph_2011.get(node_2011);
			System.out.println(String.join(", ", neighbors_2011));
		}
		System.out.println();
	}
	
	public void dfs_2011(String start_2011) {
		Set<String> visited_2011 = new HashSet<>();
		System.out.println("Penelusuran DFS:");
		dfsHelper_2011(start_2011, visited_2011);
		System.out.println();
	}

	private void dfsHelper_2011(String current_2011, Set<String> visited_2011) {
		if (visited_2011.contains(current_2011)) 
			return;
		visited_2011.add(current_2011);
		System.out.print(current_2011 + " ");
		for (String neighbor_2011 : graph_2011.getOrDefault(current_2011, new ArrayList<>())) {
			dfsHelper_2011(neighbor_2011, visited_2011);
		}
	}
	
	public void bfs_2011(String start_2011) {
		Set<String> visited_2011 = new HashSet<>();
		Queue<String> queue_2011 = new LinkedList<>();
		queue_2011.add(start_2011);
		visited_2011.add(start_2011);
		System.out.println("Penelusuran BFS:");
		while (!queue_2011.isEmpty()) {
			String current_2011 = queue_2011.poll();
			System.out.print(current_2011 + " ");
			for (String neighbor_2011 : graph_2011.getOrDefault(current_2011, new ArrayList<>())) {
				if (!visited_2011.contains(neighbor_2011)) {
					queue_2011.add(neighbor_2011);
					visited_2011.add(neighbor_2011);
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		GraphTraversal_2511532011 graph_2011 = new GraphTraversal_2511532011();
		
		graph_2011.addEdge_2011("A", "B");
		graph_2011.addEdge_2011("A", "C");
		graph_2011.addEdge_2011("B", "D");
		graph_2011.addEdge_2011("B", "E");
		
		System.out.println("Graf Awal adalah: ");
		graph_2011.printGraph_2011();
		
		graph_2011.dfs_2011("A");
		graph_2011.bfs_2011("A");

	}

}
