import java.io.*;
import java.util.*;


public class Main {
    
    static int findMinDistance(int[] distances, boolean[] visited, int vertices) {
        int minDistance = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && distances[i] < minDistance) {
                minDistance = distances[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

   
    static void dijkstra(int[][] graph, int src, int vertices, String[] vertexNames) {
        int[] distances = new int[vertices]; 
        boolean[] visited = new boolean[vertices]; 
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src] = 0;

        for (int count = 0; count < vertices - 1; count++) {
            int u = findMinDistance(distances, visited, vertices);
            if (u == -1) break;
            visited[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (!visited[v] && graph[u][v] != 0 && distances[u] != Integer.MAX_VALUE
                        && distances[u] + graph[u][v] < distances[v]) {
                    distances[v] = distances[u] + graph[u][v];
                }
            }
        }

        
        System.out.println("Starting Vertex: " + vertexNames[src]);
        for (int i = 0; i < vertices; i++) {
            if (distances[i] == Integer.MAX_VALUE) {
                System.out.println(vertexNames[i] + " is not reachable.");
            } else {
                System.out.println("Shortest path to " + vertexNames[i] + " has a weight of " + distances[i] + ".");
            }
        }
    }


        
        public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        try {
            String fileName = "graph.txt";
            File file = new File(fileName);
            if (!file.exists()) {
                throw new FileNotFoundException("File not found: " + fileName);
            }

            Scanner fileScanner = new Scanner(file);


            List<String> vertexList = new ArrayList<>();
            boolean edgeSection = false;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }
                if (!line.contains(" ")) {
                    vertexList.add(line); 
                } else {
                    edgeSection = true;
                    break;
                }
            }

            if (vertexList.isEmpty()) {
                throw new IllegalArgumentException("The file does not contain any vertices.");
            }

            String[] vertexNames = vertexList.toArray(new String[0]);
            int vertices = vertexNames.length;

            int[][] graph = new int[vertices][vertices];
            for (int i = 0; i < vertices; i++) {
                Arrays.fill(graph[i], 0);
            }

            Scanner edgeScanner = new Scanner(file);
            while (edgeScanner.hasNextLine()) {
                String line = edgeScanner.nextLine().trim();
                if (line.isEmpty() || !line.contains(" ")) {
                    continue; 
                }
                String[] edge = line.split(" ");
                if (edge.length != 3) {
                    System.out.println("Invalid edge format: " + line);
                    continue; 
                }
                int from = Arrays.asList(vertexNames).indexOf(edge[0]);
                int to = Arrays.asList(vertexNames).indexOf(edge[1]);
                int weight;
                try {
                    weight = Integer.parseInt(edge[2]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid weight format: " + edge[2]);
                    continue;
                }

                if (from == -1 || to == -1) {
                    System.out.println("Invalid vertices in edge: " + line);
                    continue; 
                }
                graph[from][to] = weight;
            }


            System.out.print("Enter the starting vertex: ");
            String startVertex = input.nextLine();
            int startIndex = Arrays.asList(vertexNames).indexOf(startVertex);

            if (startIndex == -1) {
                throw new IllegalArgumentException("Invalid starting vertex: " + startVertex);
            }


            dijkstra(graph, startIndex, vertices, vertexNames);

        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        } finally {
            input.close();
        }
    }

    
}