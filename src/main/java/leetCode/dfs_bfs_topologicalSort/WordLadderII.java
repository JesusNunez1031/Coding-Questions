package leetCode.dfs_bfs_topologicalSort;

import java.util.*;

public class WordLadderII {
    /*
    A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words
    beginWord -> s1 -> s2 -> ... -> sk such that:

    Every adjacent pair of words differs by a single letter.
    Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
    sk == endWord
    Given two words, beginWord and endWord, and a dictionary wordList, return all the shortest transformation sequences
    from beginWord to endWord, or an empty list if no such sequence exists. Each sequence should be returned as a list
    of the words [beginWord, s1, s2, ..., sk].

    Example 1:
    Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
    Output: [["hit","hot","dot","dog","cog"],["hit","hot","lot","log","cog"]]
    Explanation: There are 2 shortest transformation sequences:
    "hit" -> "hot" -> "dot" -> "dog" -> "cog"
    "hit" -> "hot" -> "lot" -> "log" -> "cog"

    Example 2:
    Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
    Output: []
    Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.

    Constraints:
        1 <= beginWord.length <= 5
        endWord.length == beginWord.length
        1 <= wordList.length <= 1000
        wordList[i].length == beginWord.length
        beginWord, endWord, and wordList[i] consist of lowercase English letters.
        beginWord != endWord
        All the words in wordList are unique.
     */
    //TC: O(26 * l * n + VE) 26 possible characters in a word, where l is the length of words and n is the number of words in list, VE is all possible paths in DFS
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> adjList = new HashMap<>(); //adjacency list for each string in wordList
        Set<String> dictionary = new HashSet<>();

        //add all the words from wordList into a set to ensure constant lookups to new leetCode.backtracking.combinations
        dictionary.addAll(wordList);

        //add the staring word to the dictionary
        adjList.put(beginWord, new ArrayList<>());

        //initialize adjacency list for all words
        for (String word : dictionary) {
            adjList.put(word, new ArrayList<>());
        }

        //Step 1: Perform min-depth BFS to find the minimum depth, min-depth since we add to a level only when on a new level
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord); //push the starting word
        Map<String, Integer> depth = new HashMap<>(); // map to hold the depth each word lies on the graph
        depth.put(beginWord, 0); // the stating node will always be at level 0

        while (!queue.isEmpty()) {
            String current = queue.remove();
            /*
                reference to the original word so we can reference the parent word for all adjacent words that can be made
                from the current word
             */
            StringBuilder temp = new StringBuilder(current);

            for (int i = 0; i < current.length(); i++) { //for all characters
                for (char c = 'a'; c <= 'z'; c++) { //try all 26 possible leetCode.backtracking.combinations
                    //skip any letter from the original word
                    if (temp.charAt(i) == c) {
                        continue;
                    }

                    temp.setCharAt(i, c);
                    String newWord = temp.toString();

                    //check if the new word is in the wordList
                    if (dictionary.contains(newWord)) {
                        //check if the new word has been visited, i.e. has a depth
                        if (!depth.containsKey(newWord)) {
                            depth.put(newWord, depth.get(current) + 1); // depth of this word is +1 its parent
                            queue.add(newWord);
                            //add temp to the nodes under "current"
                            adjList.get(current).add(newWord);
                        } else if (depth.get(newWord) == depth.get(current) + 1) {
                            //add the the new word to the list
                            adjList.get(current).add(newWord);
                        }
                    }
                }
                //revert the change done to make the new word
                temp.setCharAt(i, current.charAt(i));
            }
        }

        //Step 2: Find all possible paths from the min-depth BFS using DFS
        List<String> path = new ArrayList<>();
        List<List<String>> shortestPath = new ArrayList<>();
        dfs(beginWord, endWord, adjList, path, shortestPath);

        return shortestPath;
    }

    private static void dfs(String start, String end, Map<String, List<String>> adjList, List<String> path, List<List<String>> shortestPath) {
        //push the current word to the path
        path.add(start);

        //when we've reached the last word, add the path to the shortestPath
        if (start.equals(end)) {
            shortestPath.add(new ArrayList<>(path));
            //remove the last word from the path so we can add a new word from the same depth on next call
            path.remove(path.size() - 1);
            return;
        }

        //search through all the adjacent nodes of the current word
        for (String neighbor : adjList.get(start)) {
            //search starting from the new neighbor node
            dfs(neighbor, end, adjList, path, shortestPath);
        }
        //backtrack
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(findLadders(beginWord, endWord, wordList));
    }
}
