// https://leetcode.com/problems/most-common-word

class Solution {
  public String mostCommonWord(String paragraph, String[] banned) {
	Set<Character> punctuation = new HashSet<>(Arrays.asList('!', '?', ';', '.', ',',  '\'', ' '));
	StringBuilder filtered = new StringBuilder();
	for (char ch : paragraph.toCharArray())
		filtered.append(punctuation.contains(ch) ? ' ' : Character.toLowerCase(ch));
	paragraph = filtered.toString();

	Map<String, Integer> map = new HashMap<>();
	for (String word : paragraph.split(" "))
		if (!word.trim().isEmpty())
			map.compute(word, (k, v) -> (v == null) ? 1 : v + 1);

	Set<String> set = new HashSet<>();
	for (String ban : banned)
		set.add(ban);

	int max = 0;
	String result = null;
	for (Map.Entry<String, Integer> e : map.entrySet()) {
		if (!set.contains(e.getKey()) && e.getValue() > max) {
			result = e.getKey();
			max = e.getValue();
		}
	}
	return result;
}
}