class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preMap = new HashMap<>();

        for(int[] pr : prerequisites){
            preMap.computeIfAbsent(pr[0], k -> new ArrayList<>()).add(pr[1]);
        }

        Set<Integer> visitSet = new HashSet<>();

        for(int crs = 0; crs < numCourses; crs++){
            if(!dfs(prerequisites, preMap, visitSet, crs)) return false;
        }
        return true;
    }

    public boolean dfs(int[][] prerequisites, Map<Integer, List<Integer>> preMap, Set<Integer> visitSet, int crs){
        if(visitSet.contains(crs)) return false;
        if(!preMap.containsKey(crs) || preMap.get(crs).size() == 0) return true;

        visitSet.add(crs);
        for(int pre : preMap.get(crs)){
            if(!dfs(prerequisites, preMap, visitSet, pre)) return false;
        }
        visitSet.remove(crs);
        preMap.remove(crs);
        return true;
    }
}
