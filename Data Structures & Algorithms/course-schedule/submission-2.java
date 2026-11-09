class Solution {

    Map<Integer, List<Integer>> preqMap = new HashMap<>();
    Set<Integer> visited = new HashSet<>();


    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for(int i = 0; i<numCourses; i++) {
            preqMap.put(i, new ArrayList<>());
        }
        
        for(int[] prq: prerequisites) {
            preqMap.get(prq[0]).add(prq[1]);
        }

        for(int i = 0; i<numCourses; i++) {
            if(!dfs(i))  return false;
        }
        return true;
    }

    boolean dfs(int course) {
        if(visited.contains(course)) {
            return false;
        }

        if(preqMap.get(course).isEmpty()) {
            return true;
        }

        visited.add(course);
        for(int neigh : preqMap.get(course)) {
            if(!dfs(neigh))  return false;
        }
        visited.remove(course);
        preqMap.put(course, new ArrayList<>());
        return true;

    }
}
