package advanceTreeQue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public static void main(String[] args) {

	}

	/*
	 * A transformation sequence from word beginWord to word endWord using a
	 * dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk
	 * such that:
	 * 
	 * Every adjacent pair of words differs by a single letter. Every si for 1 <= i
	 * <= k is in wordList. Note that beginWord does not need to be in wordList. sk
	 * == endWord Given two words, beginWord and endWord, and a dictionary wordList,
	 * return the number of words in the shortest transformation sequence from
	 * beginWord to endWord, or 0 if no such sequence exists.
	 * 
	 * Example 1:
	 * 
	 * Input: beginWord = "hit", endWord = "cog", wordList =
	 * ["hot","dot","dog","lot","log","cog"] Output: 5 Explanation: One shortest
	 * transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is
	 * 5 words long.
	 */

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if(!wordList.contains(endWord)) {
			return 0;
		}
		
		Set<String> visited = new HashSet<>();
		
		Queue<String> q = new LinkedList<>();
		
		q.offer(beginWord);
		
		int length = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			length++;
			
			for(int i=0;i<size;i++) {
				String current = q.poll();
				char[] temp = current.toCharArray();
				for(int j=0; j < current.length(); j++) {
					for(char ch = 'a'; ch <= 'z'; ch++) {
						temp[j] = ch;
						String newWord = new String(temp);
						if(newWord.equals(endWord)) {
							return length+1;
						}
						
						if(wordList.contains(newWord) && !visited.contains(newWord)) {
							q.offer(newWord);
							visited.add(newWord);
						}
					}
				}
			}
		}
		
		return 0;
	}

}
