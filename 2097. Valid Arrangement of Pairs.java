/*
2097. Valid Arrangement of Pairs
Solved
Hard
Topics
Companies
Hint
You are given a 0-indexed 2D integer array pairs where pairs[i] = [starti, endi]. An arrangement of pairs is valid if for every index i where 1 <= i < pairs.length, we have endi-1 == starti.

Return any valid arrangement of pairs.

Note: The inputs will be generated such that there exists a valid arrangement of pairs.

 

Example 1:

Input: pairs = [[5,1],[4,5],[11,9],[9,4]]
Output: [[11,9],[9,4],[4,5],[5,1]]
Explanation:
This is a valid arrangement since endi-1 always equals starti.
end0 = 9 == 9 = start1 
end1 = 4 == 4 = start2
end2 = 5 == 5 = start3
Example 2:

Input: pairs = [[1,3],[3,2],[2,1]]
Output: [[1,3],[3,2],[2,1]]
Explanation:
This is a valid arrangement since endi-1 always equals starti.
end0 = 3 == 3 = start1
end1 = 2 == 2 = start2
The arrangements [[2,1],[1,3],[3,2]] and [[3,2],[2,1],[1,3]] are also valid.
Example 3:

Input: pairs = [[1,2],[1,3],[2,1]]
Output: [[1,2],[2,1],[1,3]]
Explanation:
This is a valid arrangement since endi-1 always equals starti.
end0 = 2 == 2 = start1
end1 = 1 == 1 = start2
 

Constraints:

1 <= pairs.length <= 105
pairs[i].length == 2
0 <= starti, endi <= 109
starti != endi
No two pairs are exactly the same.
There exists a valid arrangement of pairs.
*/
class Solution {
    List<Integer> circuit;
    public int[][] validArrangement(int[][] pairs) {
        Map<Integer, List<Integer>> graph=new HashMap();
        Map<Integer, Integer> node=new HashMap();

        for(int[] pair:pairs){
            if(!graph.containsKey(pair[0])){
                graph.put(pair[0], new ArrayList());
            }
            graph.get(pair[0]).add(pair[1]);    //Preparing graph
            node.put(pair[0], node.getOrDefault(pair[0],0)-1); //Outgoing
            node.put(pair[1], node.getOrDefault(pair[1],0)+1); //Incoming
        }


        //selecting the starting node
        int startNode=pairs[0][0];
        for(Map.Entry<Integer, Integer> enty:node.entrySet()){
            if(enty.getValue()==-1){
                startNode=enty.getKey();
                break;
            }
        }

        circuit=new ArrayList();
        dfs(graph, startNode);
        Collections.reverse(circuit);
        
       
        int[][] result=new int[pairs.length][2];
        for(int i=1; i<circuit.size(); i++){
            result[i-1][0]=circuit.get(i-1);
            result[i-1][1]=circuit.get(i);
        }

        return result;
    }

    void dfs(Map<Integer, List<Integer>> graph, int u){
        while(graph.containsKey(u) && !graph.get(u).isEmpty()){
            int v=graph.get(u).remove(0);
            dfs(graph, v);
        }
        circuit.add(u);
    }


}
