class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        int m = prerequisites.length;
        for(int i = 0; i < m; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]); // Fixed syntax for 2D array
        }
        
        int[] indegree = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            for(int it: adj.get(i)){
                indegree[it]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        int topo[] = new int[numCourses];
        int index = 0;
        
        while(!q.isEmpty()){
            int node = q.poll(); // changed q.peek() followed by q.remove() to q.poll()
            topo[index++] = node;
            for(int itt : adj.get(node)){
                indegree[itt]--;
                if(indegree[itt] == 0){
                    q.add(itt);
                }
            }
        }

        // Compare index (number of nodes in topo order) with numCourses
        return index == numCourses;
    }
}
